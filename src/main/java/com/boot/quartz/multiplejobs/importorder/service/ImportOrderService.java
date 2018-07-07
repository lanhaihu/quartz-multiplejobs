package com.boot.quartz.multiplejobs.importorder.service;

import com.boot.quartz.multiplejobs.db.entity.CargoListEntity;
import com.boot.quartz.multiplejobs.db.mapper.ImportOrderMapper;
import com.boot.quartz.multiplejobs.entity.OrderImportRequestEntity;
import com.boot.quartz.multiplejobs.entity.OrderImportResponseEntity;
import com.boot.quartz.multiplejobs.entity.baseEntity.*;
import com.boot.util.ConstantInfoUtil;
import com.boot.util.HttpClient;
import com.boot.util.XmlConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhaos on 2018/7/7.
 */
public class ImportOrderService {
    @Autowired
    private ImportOrderMapper importOrderMapper;

    public void startImportCargoList(){

        List<CargoListEntity> entitys = new ArrayList<CargoListEntity>();
        OrderImportRequestEntity orderImportRequestEntity = new OrderImportRequestEntity();
        OrderImportResponseEntity orderImportResponseEntity = new OrderImportResponseEntity();

        String strRequestXml = "";
        String strResponseXml = "";
        String strResponseCode = "";

        entitys = importOrderMapper.findByOutputStatus("0");

        if(entitys.size() > 0){
            String url = ConstantInfoUtil.getUrl();
            orderImportRequestEntity = dataLoad(entitys);
            strRequestXml = XmlConverter.convertToXml(orderImportRequestEntity);
            try{
                strResponseXml = HttpClient.send(url,strRequestXml);
                orderImportResponseEntity = (OrderImportResponseEntity)XmlConverter.convertXmlStrToObject(OrderImportResponseEntity.class,strResponseXml);
                strResponseCode = orderImportResponseEntity.getResponseCode();
                if("0".equals(strResponseCode)){
                    //客户验证失败
                    System.out.println("用户校验失败");
                }else if("1".equals(strResponseCode)){
                    //不支持的请求版本
                    System.out.println("不支持的请求版本");
                }else if("2".equals(strResponseCode)){
                    //请求中的导入订单过多
                    System.out.println("请求中的导入订单过多");
                }else{
                    //成功
                    ArrayList<String> ids = null;
                    ids = getCarGoIdList(entitys);
                    importOrderMapper.updateCargoListByIds(ids);
                    importOrderMapper.updateCargoListBByCarGoIds(ids);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private ArrayList<String> getCarGoIdList(List<CargoListEntity> entitys){
        ArrayList<String> resultList = new ArrayList<String>();
        HashSet<String> idsSet = new HashSet<String>();
        for(CargoListEntity entity : entitys){
            idsSet.add(entity.getId());
        }
        for(String id : idsSet){
            resultList.add(id);
        }
        return resultList;
    }

    private OrderImportRequestEntity dataLoad(List<CargoListEntity> entitys) {
        int i = 0;
        int totalVolume = 0;
        int totalWeight = 0;
        OrderImportRequestEntity orderImportRequestEntity = new OrderImportRequestEntity();

        List<orderInfoEntity> orderInfoList = new ArrayList<orderInfoEntity>();

        customFieldEntity customFields =  new customFieldEntity();
        shipFromEntity shipFrom = new shipFromEntity();
        contactEntity shipFromContactEntity = new contactEntity();

        shipToEntity shipTo = new shipToEntity();
        contactEntity shipToContactEntity = new contactEntity();
        List<orderLineEntity> orderLines = new ArrayList<orderLineEntity>();
        timeScheduleEntity timeSchedule = new timeScheduleEntity();
        cargoDetailsEntity cargoDetails = new cargoDetailsEntity();
        transportModeEntity transportMode = new transportModeEntity();

        HashSet<String> billCodeList;
        orderImportRequestEntity.setLogin(ConstantInfoUtil.getUser());
        orderImportRequestEntity.setPassword(ConstantInfoUtil.getPassWord());
        orderImportRequestEntity.setVersion(ConstantInfoUtil.getVersion());

        billCodeList = getBillCodeList(entitys);
        for(String billCode : billCodeList){
            CargoListEntity entity = new CargoListEntity();
            List<CargoListEntity> entityBList = new ArrayList<CargoListEntity>();

            entity = getOneCargoListEntityByBillCode(entitys,billCode);
            entityBList = getCargoListBByBillCode(entitys,billCode);

            totalVolume = 0;
            totalWeight = 0;
            for(CargoListEntity entityB : entityBList){
                totalVolume += entityB.getVolume();
                totalWeight += entity.getUnitWeight();
                orderLineEntity orderLine = new orderLineEntity();
                cargoDescriptionEntity cargoDescription = new cargoDescriptionEntity();
                cargoDescription.setProductCode(entityB.getProductCode());
                cargoDescription.setProductName(entityB.getProductName());
                //cargoDescription.setUnitHeight();
                //cargoDescription.setUnitLength();
                cargoDescription.setUnitType(entityB.getUnitType());
                //cargoDescription.setUnitWeight();
                //cargoDescription.setUnitWidth();
                orderLine.setQuantity(entityB.getQuantity() + "");
                orderLine.setCargoDescription(cargoDescription);

                orderLines.add(orderLine);
            }

            //shipFromContactEntity.setEmail();
            shipFromContactEntity.setMobile(entity.getShipFrom_contact_mobile());
            shipFromContactEntity.setName(entity.getShipFrom_contact_name());
            shipFromContactEntity.setPhone(entity.getShipFrom_contact_phone());
            shipFromContactEntity.setPhoneAreaCode(entity.getShipFrom_contact_phoneAreaCode());

            shipFrom.setAddress(entity.getShipFrom_address());
            shipFrom.setCompanyName(entity.getShipFrom_companyName());
            shipFrom.setContactEntityEntiy(shipFromContactEntity);
            shipFrom.setLoading(entity.getShipFrom_loading());
            shipFrom.setLocationRemarks(entity.getShipFrom_locationRemarks());
            //shipFrom.setPostcode();

            //shipToContactEntity.setEmail();
            shipToContactEntity.setMobile(entity.getShipTo_contact_mobile());
            shipToContactEntity.setName(entity.getShipTo_contact_name());
            shipToContactEntity.setPhone(entity.getShipTo_contact_phone());
            shipToContactEntity.setPhoneAreaCode(entity.getShipTo_contact_phoneAreaCode());

            shipTo.setAddress(entity.getShipTo_address());
            shipTo.setCompanyName(entity.getShipTo_companyName());
            shipTo.setContactEntityEntiy(shipToContactEntity);
            shipTo.setLoading(entity.getShipTo_loading());
            shipTo.setLocationRemarks(entity.getShipTo_locationRemarks());
            //shipTo.setPostcode();

            timeSchedule.setDeliveryDate(entity.getDeliveryDate());
            timeSchedule.setPickupDate(entity.getPickupDate());
            timeSchedule.setDeliveryTimeFrom(entity.getDeliveryTimeFrom());
            timeSchedule.setDeliveryTimeTo(entity.getDeliveryTimeTo());
            timeSchedule.setPickupTimeFrom(entity.getPickupTimeFrom());
            timeSchedule.setPickupTimeTo(entity.getPickupTimeTo());

            cargoDetails.setCargoType("1");
            cargoDetails.setPackageType("A");
            cargoDetails.setTotalVolume(totalVolume + "");
            cargoDetails.setTotalWeight(totalWeight + "");


            transportMode.setTransportType("ETL");
            transportMode.setTruckType("2");

            orderInfoEntity  orderInfo = new orderInfoEntity();
            orderInfo.setBranch(entity.getBranch());
            orderInfo.setCargoDetails(cargoDetails);
            //orderInfo.setClientCode();
            orderInfo.setClientReferenceNumber(entity.getClientReferenceNumber());

            //TODO
            //orderInfo.setCustomFields();

            orderInfo.setErpNumber(entity.getErpNumber());
            orderInfo.setOrderLines(orderLines);
            orderInfo.setSequence(i);
            orderInfo.setShipFrom(shipFrom);
            orderInfo.setShipTo(shipTo);
            orderInfo.setTimeSchedule(timeSchedule);
            orderInfo.setTransportMode(transportMode);
            orderInfo.setVendorcode(entity.getVendorcode());

            i++ ;
        }
        return orderImportRequestEntity;
    }

    private List<CargoListEntity> getCargoList(){
        List<CargoListEntity> entitys = new ArrayList<CargoListEntity>();
        entitys = importOrderMapper.findByOutputStatus("1");
        return entitys;
    }

    private List<CargoListEntity> getCargoListBByBillCode( List<CargoListEntity> entitys,String billCode){
        List<CargoListEntity> result = new ArrayList<CargoListEntity>();
        for(CargoListEntity entity : entitys){
            if(billCode.equals(entity.getErpNumber())){
                result.add(entity);
            }
        }
        return result;
    }

    private HashSet<String> getBillCodeList(List<CargoListEntity> entitys){
        HashSet billCodeList = new HashSet();
        for(CargoListEntity entity : entitys){
            billCodeList.add(entity.getErpNumber());
        }
        return billCodeList;
    }

    private CargoListEntity getOneCargoListEntityByBillCode(List<CargoListEntity> entitys,String billCode){
        CargoListEntity result = null;
        for(CargoListEntity entity : entitys){
            if(billCode.equals(entity.getErpNumber())){
                result = entity;
                return result;
            }
        }
        return result;
    }
}
