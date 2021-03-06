package com.boot.quartz.multiplejobs.importorder.service;

import com.boot.quartz.multiplejobs.db.entity.CargoListEntity;
import com.boot.quartz.multiplejobs.db.mapper.ImportOrderMapper;
import com.boot.quartz.multiplejobs.entity.OrderImportRequestEntity;
import com.boot.quartz.multiplejobs.entity.OrderImportResponseEntity;
import com.boot.quartz.multiplejobs.entity.baseEntity.*;
import com.boot.util.ConstantInfoUtil;
import com.boot.util.HttpClient;
import com.boot.util.XmlConverter;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by zhaos on 2018/7/7.
 */
@Service
@Slf4j
public class ImportOrderService {
    @Autowired
    private ImportOrderMapper importOrderMapper;

    public void startImportCargoList(String type){
        log.info("导入订单开始");
        log.info("type="+type);
        List<CargoListEntity> entitys = new ArrayList<CargoListEntity>();

        if("cargo".equals(type)){
            entitys = importOrderMapper.findByOutputStatus("0");
        }else if("delivery".equals(type)){
            entitys = importOrderMapper.findDelistByOutputStatus("0");
        }else{
            log.error("type没有匹配到");
        }

        if(entitys.size() > 0){
            String url = ConstantInfoUtil.getUrl();
            HashSet<String> billListSet = getBillCodeList(entitys);
            List billList = new ArrayList<>(billListSet);
            List<List<String>> billListArray = Lists.partition(billList,ConstantInfoUtil.getSendMaxCount());
            for(List<String> strBillList : billListArray){
                OrderImportRequestEntity orderImportRequestEntity = new OrderImportRequestEntity();
                OrderImportResponseEntity orderImportResponseEntity = new OrderImportResponseEntity();
                String strRequestXml = "";
                String strResponseXml = "";
                String strResponseCode = "";
                orderImportRequestEntity = dataLoad(strBillList,entitys);
                strRequestXml = XmlConverter.convertToXml(orderImportRequestEntity);
                try{
                    log.info("发送导入请求开始，原始数据为"+strRequestXml);
                    strResponseXml = HttpClient.sendXmlByPut(url,strRequestXml);
                    log.info("导入请求响应结果为"+strResponseXml);
                    orderImportResponseEntity = (OrderImportResponseEntity)XmlConverter.convertXmlStrToObject(OrderImportResponseEntity.class,strResponseXml);
                    strResponseCode = orderImportResponseEntity.getResponseCode();
                    if("0".equals(strResponseCode)){
                        //客户验证失败
                        log.error("用户校验失败");
                    }else if("1".equals(strResponseCode)){
                        //不支持的请求版本
                        log.error("不支持的请求版本");
                    }else if("2".equals(strResponseCode)){
                        //请求中的导入订单过多
                        log.error("请求中的导入订单过多");
                    }else{
                        //成功
                        List<orderResponseEntity> orderResponseList = orderImportResponseEntity.getOrders();
                        for(orderResponseEntity orderResponseEntity : orderResponseList){
                            String strImportStatus = orderResponseEntity.getImportStatus();
                            String billCode = orderResponseEntity.getClientReferenceNumber();

                            //String strClientReferenceNumber = orderResponseEntity.getClientReferenceNumber();
                            //String cargoId = getCarGoidByBillCode(entitys,strClientReferenceNumber);
                            log.info("strImportStatus="+strImportStatus);
                            if("NOT IMPORTED".equals(strImportStatus)){
                                //导入失败
                                List<responseCodeEntity> responseCodeList= orderResponseEntity.getResponseCodes();
                                StringBuilder strBuilder = errorCodeConvert(billCode,responseCodeList);
                                log.error(strBuilder.toString());
                            }else if("DRAFT".equals(strImportStatus)){
                                //草稿 (订单信息不全)
                                updateStatus(type,billCode);
                            }else if("INBOX".equals(strImportStatus)){
                                //已导入
                                updateStatus(type,billCode);
                            }else if("RELEASED".equals(strImportStatus)){
                                //已释放
                                updateStatus(type,billCode);
                            }else if("DISPATCHED".equals(strImportStatus)){
                                //已分配
                                updateStatus(type,billCode);
                            }else{
                                log.error("未知返回状态");
                            }
                        }
                   /* ArrayList<String> ids = null;
                    ids = getCarGoIdList(entitys);
                    importOrderMapper.updateCargoListByIds(ids);
                    importOrderMapper.updateCargoListBByCarGoIds(ids);*/
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    log.error("请求异常",e);
                }
            }
        }
        log.info("导入订单结束");
    }

    private void updateStatus(String type,String id) {
        if("cargo".equals(type)){
            importOrderMapper.updateCargoListByIds(id);
            importOrderMapper.updateCargoListBByCarGoIds(id);
        }else if("delivery".equals(type)){
            importOrderMapper.updateDeliveryListByIds(id);
            importOrderMapper.updateDeliveryListBByCarGoIds(id);
        }else{
            log.error("type没有匹配到");
        }
    }


    private StringBuilder errorCodeConvert(String billCode,List<responseCodeEntity> responseCodeList){
        StringBuilder strbuilder = new StringBuilder();
        if(responseCodeList != null){
            for(responseCodeEntity entity : responseCodeList){
                String code = entity.getCode();
                String reason = ConstantInfoUtil.codeMapper(code);
                strbuilder.append("billCode=" + billCode + ",resultCode=" + code + ",原因=" + reason + "\r\n");
            }
        }
        return strbuilder;
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

    private String getCarGoidByBillCode(List<CargoListEntity> entitys,String billCode){
        String result = "";
        for(CargoListEntity entity : entitys){
            if(billCode.equals(entity.getErpNumber())){
                result = entity.getId();
                break;
            }
        }
        return result;
    }

    private OrderImportRequestEntity dataLoad(List<String> billCodeList,List<CargoListEntity> entitys) {
        int i = 0;

        OrderImportRequestEntity orderImportRequestEntity = new OrderImportRequestEntity();

        List<orderInfoEntity> orderInfoList = new ArrayList<orderInfoEntity>();

        orderImportRequestEntity.setLogin(ConstantInfoUtil.getUser());
        orderImportRequestEntity.setPassword(ConstantInfoUtil.getPassWord());
        orderImportRequestEntity.setVersion(ConstantInfoUtil.getVersion());

        //HashSet<String> billCodeList = getBillCodeList(entitys);
        //重量保留3位，体积保留六位
        DecimalFormat weightForm  =   new  DecimalFormat(ConstantInfoUtil.getWeightFormat());
        DecimalFormat volumForm  =   new  DecimalFormat(ConstantInfoUtil.getVolumeFormat());
        for(String billCode : billCodeList){
            float totalVolume = 0;
            float totalWeight = 0;
            int totalQuantity=0;

            customFieldEntity customFields =  new customFieldEntity();
            shipFromEntity shipFrom = new shipFromEntity();
            contactEntity shipFromContactEntity = new contactEntity();

            shipToEntity shipTo = new shipToEntity();
            contactEntity shipToContactEntity = new contactEntity();
            //List<orderLineEntity> orderLines = new ArrayList<orderLineEntity>();
            timeScheduleEntity timeSchedule = new timeScheduleEntity();
            cargoDetailsEntity cargoDetails = new cargoDetailsEntity();
            transportModeEntity transportMode = new transportModeEntity();

            CargoListEntity entity = new CargoListEntity();
            List<CargoListEntity> entityBList = new ArrayList<CargoListEntity>();
            List<orderLineEntity> orderLines = new ArrayList<orderLineEntity>();

            entity = getOneCargoListEntityByBillCode(entitys,billCode);
            entityBList = getCargoListBByBillCode(entitys,billCode);


            for(CargoListEntity entityB : entityBList){
                totalQuantity += entityB.getQuantity();
                //totalVolume += entityB.getVolume();
                //totalWeight += entityB.getUnitWeight();
                totalVolume += entityB.getSumVolume();
                totalWeight += entityB.getSumWeight();
                orderLineEntity orderLine = new orderLineEntity();
                cargoDescriptionEntity cargoDescription = new cargoDescriptionEntity();
                cargoDescription.setProductCode(entityB.getProductCode());
                cargoDescription.setProductName(entityB.getProductName());
                //cargoDescription.setUnitHeight();
                //cargoDescription.setUnitLength();
                cargoDescription.setUnitType(entityB.getUnitType());
                cargoDescription.setUnitWeight(weightForm.format(entityB.getUnitWeight()));
                //cargoDescription.setUnitWidth();
                orderLine.setQuantity(entityB.getQuantity() + "");
                orderLine.setVolume(volumForm.format(entityB.getSumVolume()));
                orderLine.setWeight(weightForm.format(entityB.getSumWeight()));
                orderLine.setRemarks(entityB.getCustomText18());
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
            shipFrom.setCounty(entity.getShipFrom_county());
            shipFrom.setProvince(entity.getShipFrom_province());
            shipFrom.setTown(entity.getShipFrom_town());
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
            shipTo.setCounty(entity.getShipTo_county());
            shipTo.setProvince(entity.getShipTo_province());
            shipTo.setTown(entity.getShipTo_town());
            //shipTo.setPostcode();

            timeSchedule.setDeliveryDate(entity.getDeliveryDate());
            timeSchedule.setPickupDate(entity.getPickupDate());
            timeSchedule.setDeliveryTimeFrom(entity.getDeliveryTimeFrom());
            timeSchedule.setDeliveryTimeTo(entity.getDeliveryTimeTo());
            timeSchedule.setPickupTimeFrom(entity.getPickupTimeFrom());
            timeSchedule.setPickupTimeTo(entity.getPickupTimeTo());

            cargoDetails.setCargoType("1");
            cargoDetails.setPackageType("A");

            //体积保存六位
            //cargoDetails.setTotalVolume(volumForm.format(totalVolume));
            //重量保存三位
            //cargoDetails.setTotalWeight(weightForm.format(totalWeight));
            //添加总数
            //cargoDetails.setTotalQuantity(totalQuantity+"");

            customFields.setCustomText1(entity.getCustomText1());
            customFields.setCustomText2(entity.getCustomText2());
            customFields.setCustomText3(entity.getCustomText3());
            customFields.setCustomText4(entity.getCustomText4());
            customFields.setCustomText5(entity.getCustomText5());
            customFields.setCustomText6(entity.getCustomText6());
            customFields.setCustomText7(entity.getCustomText7());
            customFields.setCustomText8(entity.getCustomText8());
            customFields.setCustomText9(entity.getCustomText9());
            customFields.setCustomText15(entity.getCustomText15());
            customFields.setCustomText16(entity.getCustomText16());
            customFields.setCustomText17(entity.getCustomText17());
            customFields.setCustomText18(entity.getCustomText18());

//                  A. "MATERIAL_TYPE" customText10 -- 物料类型(0成品、1配方颗粒)
//                   ,A."TAXPAYER_CODE" customText11 -- 纳税人识别编码
//                   ,A."CHANNEL_CODE" customText12 -- 渠道编码
//                   ,A."CHANNEL_NAME" customText13 – 渠道名称
//                   ,A."BRANCH_OFFICE" customText14 -- 办事处
//                   ,A."WAREHOUSE" customText19 – 库房
//                   ,A."RESERVED1" customText20 -- （预留1）
//                   ,A."RESERVED2" customText21 -- （预留2）
//                   ,A."RESERVED3" customText22 -- （预留3）
            customFields.setCustomText10(entity.getCustomText10());
            customFields.setCustomText11(entity.getCustomText11());
            customFields.setCustomText12(entity.getCustomText12());
            customFields.setCustomText13(entity.getCustomText13());
            customFields.setCustomText14(entity.getCustomText14());
            customFields.setCustomText19(entity.getCustomText19());
            customFields.setCustomText20(entity.getCustomText20());
            customFields.setCustomText21(entity.getCustomText21());
            customFields.setCustomText22(entity.getCustomText22());


            transportMode.setTransportType("LTL");
            transportMode.setTruckType("2");

            orderInfoEntity  orderInfo = new orderInfoEntity();
            orderInfo.setBranch(entity.getBranch());
            orderInfo.setCargoDetails(cargoDetails);
            //orderInfo.setClientCode();
            orderInfo.setClientReferenceNumber(entity.getClientReferenceNumber());

            //TODO
            orderInfo.setCustomFields(customFields);

            orderInfo.setErpNumber(entity.getErpNumber());
            orderInfo.setOrderLines(orderLines);
            orderInfo.setSequence(i);
            orderInfo.setShipFrom(shipFrom);
            orderInfo.setShipTo(shipTo);
            orderInfo.setTimeSchedule(timeSchedule);
            orderInfo.setTransportMode(transportMode);
            orderInfo.setVendorcode(entity.getVendorcode());

            orderInfoList.add(orderInfo);
            i++ ;
        }
        orderImportRequestEntity.setOrders(orderInfoList);
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
