package com.boot.quartz.multiplejobs.db.entity;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by zou on 2018/7/7.
 */
public class DeliverListEntiy extends BaseEntity {
   
    String erpNumber; // ERP/WMS单据编号
   
    String branch; // 地区
   
    String clientReferenceNumber; // 外部查询单号
   
    String autoProcessMode; // 订单处理模式
   
    String vendorcode; // 承运商在oTMS系统中的公司代码
   
    String shipFrom_companyName; //发货方
   
    String shipFrom_province; // 发货省份
   
    String shipFrom_town; // 发货城市
   
    String shipFrom_county; // 发货区县
   
    String shipFrom_address; // 详细地址
   
    String shipFrom_loading; // 装货标记
   
    String shipFrom_contact_name; // 发货方联系人
   
    String shipFrom_contact_phone; // 发货方座机
   
    String shipFrom_contact_phoneAreaCode; // 发货方座机区号
   
    String shipFrom_contact_mobile; // 发货方手机
   
    String shipFrom_locationRemarks; // 发货点备注
   
    String shipTo_companyName; // 收货方
   
    String shipTo_province; // 收货省份
   
    String shipTo_town; // 收货城市
   
    String shipTo_county; // 收货区县
   
    String shipTo_address; // 收货详细地址
   
    String shipTo_loading ; // 装货标记
   
    String shipTo_contact_name; // 收货方联系人
   
    String shipTo_contact_phone; // 收货方座机
   
    String shipTo_contact_phoneAreaCode; // 收货方座机区号
   
    String shipTo_contact_mobile; // 收货方手机
   
    String shipTo_locationRemarks; // 收货点备注
   
    Date pickupDate; // 计划提货日期
   
    Date pickupTimeFrom; // 提货开始时间
   
    Date pickupTimeTo; // 提货结束时间
   
    Date deliveryDate; // 计划送达日期
   
    Date deliveryTimeFrom; // 送达开始时间
   
    Date deliveryTimeTo; //  送达结束时间
   
    String productName; // 物品名称
   
    String productCode; // 物品编码
   
    String unitType; // 计量单位
   
    int volume; // 体积
   
    int unitWidth; // 单品重量
   
    int quantity; // 数量

    String customText1; // 销售单号
    Date customText2; //过账时限
    String customText3; //业务员
    String customText4; //业务员电话
    String customText5; // 制单人
    Date customText6; //制单时间
    String customText7; // 客户名称
    String customText8; //交货单行号
    String customText9; //随货同行单行号
    String customText15; //批号
    Date customText16; //生产日期
    Date customText17; //有效期至
    String customText18; //备注

    public String getErpNumber() {
        return erpNumber;
    }

    public void setErpNumber(String erpNumber) {
        this.erpNumber = erpNumber;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getClientReferenceNumber() {
        return clientReferenceNumber;
    }

    public void setClientReferenceNumber(String clientReferenceNumber) {
        this.clientReferenceNumber = clientReferenceNumber;
    }

    public String getAutoProcessMode() {
        return autoProcessMode;
    }

    public void setAutoProcessMode(String autoProcessMode) {
        this.autoProcessMode = autoProcessMode;
    }

    public String getVendorcode() {
        return vendorcode;
    }

    public void setVendorcode(String vendorcode) {
        this.vendorcode = vendorcode;
    }

    public String getShipFrom_companyName() {
        return shipFrom_companyName;
    }

    public void setShipFrom_companyName(String shipFrom_companyName) {
        this.shipFrom_companyName = shipFrom_companyName;
    }

    public String getShipFrom_province() {
        return shipFrom_province;
    }

    public void setShipFrom_province(String shipFrom_province) {
        this.shipFrom_province = shipFrom_province;
    }

    public String getShipFrom_town() {
        return shipFrom_town;
    }

    public void setShipFrom_town(String shipFrom_town) {
        this.shipFrom_town = shipFrom_town;
    }

    public String getShipFrom_county() {
        return shipFrom_county;
    }

    public void setShipFrom_county(String shipFrom_county) {
        this.shipFrom_county = shipFrom_county;
    }

    public String getShipFrom_address() {
        return shipFrom_address;
    }

    public void setShipFrom_address(String shipFrom_address) {
        this.shipFrom_address = shipFrom_address;
    }

    public String getShipFrom_loading() {
        return shipFrom_loading;
    }

    public void setShipFrom_loading(String shipFrom_loading) {
        this.shipFrom_loading = shipFrom_loading;
    }

    public String getShipFrom_contact_name() {
        return shipFrom_contact_name;
    }

    public void setShipFrom_contact_name(String shipFrom_contact_name) {
        this.shipFrom_contact_name = shipFrom_contact_name;
    }

    public String getShipFrom_contact_phone() {
        return shipFrom_contact_phone;
    }

    public void setShipFrom_contact_phone(String shipFrom_contact_phone) {
        this.shipFrom_contact_phone = shipFrom_contact_phone;
    }

    public String getShipFrom_contact_phoneAreaCode() {
        return shipFrom_contact_phoneAreaCode;
    }

    public void setShipFrom_contact_phoneAreaCode(String shipFrom_contact_phoneAreaCode) {
        this.shipFrom_contact_phoneAreaCode = shipFrom_contact_phoneAreaCode;
    }

    public String getShipFrom_contact_mobile() {
        return shipFrom_contact_mobile;
    }

    public void setShipFrom_contact_mobile(String shipFrom_contact_mobile) {
        this.shipFrom_contact_mobile = shipFrom_contact_mobile;
    }

    public String getShipFrom_locationRemarks() {
        return shipFrom_locationRemarks;
    }

    public void setShipFrom_locationRemarks(String shipFrom_locationRemarks) {
        this.shipFrom_locationRemarks = shipFrom_locationRemarks;
    }

    public String getShipTo_companyName() {
        return shipTo_companyName;
    }

    public void setShipTo_companyName(String shipTo_companyName) {
        this.shipTo_companyName = shipTo_companyName;
    }

    public String getShipTo_province() {
        return shipTo_province;
    }

    public void setShipTo_province(String shipTo_province) {
        this.shipTo_province = shipTo_province;
    }

    public String getShipTo_town() {
        return shipTo_town;
    }

    public void setShipTo_town(String shipTo_town) {
        this.shipTo_town = shipTo_town;
    }

    public String getShipTo_county() {
        return shipTo_county;
    }

    public void setShipTo_county(String shipTo_county) {
        this.shipTo_county = shipTo_county;
    }

    public String getShipTo_address() {
        return shipTo_address;
    }

    public void setShipTo_address(String shipTo_address) {
        this.shipTo_address = shipTo_address;
    }

    public String getShipTo_loading() {
        return shipTo_loading;
    }

    public void setShipTo_loading(String shipTo_loading) {
        this.shipTo_loading = shipTo_loading;
    }

    public String getShipTo_contact_name() {
        return shipTo_contact_name;
    }

    public void setShipTo_contact_name(String shipTo_contact_name) {
        this.shipTo_contact_name = shipTo_contact_name;
    }

    public String getShipTo_contact_phone() {
        return shipTo_contact_phone;
    }

    public void setShipTo_contact_phone(String shipTo_contact_phone) {
        this.shipTo_contact_phone = shipTo_contact_phone;
    }

    public String getShipTo_contact_phoneAreaCode() {
        return shipTo_contact_phoneAreaCode;
    }

    public void setShipTo_contact_phoneAreaCode(String shipTo_contact_phoneAreaCode) {
        this.shipTo_contact_phoneAreaCode = shipTo_contact_phoneAreaCode;
    }

    public String getShipTo_contact_mobile() {
        return shipTo_contact_mobile;
    }

    public void setShipTo_contact_mobile(String shipTo_contact_mobile) {
        this.shipTo_contact_mobile = shipTo_contact_mobile;
    }

    public String getShipTo_locationRemarks() {
        return shipTo_locationRemarks;
    }

    public void setShipTo_locationRemarks(String shipTo_locationRemarks) {
        this.shipTo_locationRemarks = shipTo_locationRemarks;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getPickupTimeFrom() {
        return pickupTimeFrom;
    }

    public void setPickupTimeFrom(Date pickupTimeFrom) {
        this.pickupTimeFrom = pickupTimeFrom;
    }

    public Date getPickupTimeTo() {
        return pickupTimeTo;
    }

    public void setPickupTimeTo(Date pickupTimeTo) {
        this.pickupTimeTo = pickupTimeTo;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getDeliveryTimeFrom() {
        return deliveryTimeFrom;
    }

    public void setDeliveryTimeFrom(Date deliveryTimeFrom) {
        this.deliveryTimeFrom = deliveryTimeFrom;
    }

    public Date getDeliveryTimeTo() {
        return deliveryTimeTo;
    }

    public void setDeliveryTimeTo(Date deliveryTimeTo) {
        this.deliveryTimeTo = deliveryTimeTo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getUnitWidth() {
        return unitWidth;
    }

    public void setUnitWidth(int unitWidth) {
        this.unitWidth = unitWidth;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomText1() {
        return customText1;
    }

    public void setCustomText1(String customText1) {
        this.customText1 = customText1;
    }

    public Date getCustomText2() {
        return customText2;
    }

    public void setCustomText2(Date customText2) {
        this.customText2 = customText2;
    }

    public String getCustomText3() {
        return customText3;
    }

    public void setCustomText3(String customText3) {
        this.customText3 = customText3;
    }

    public String getCustomText4() {
        return customText4;
    }

    public void setCustomText4(String customText4) {
        this.customText4 = customText4;
    }

    public String getCustomText5() {
        return customText5;
    }

    public void setCustomText5(String customText5) {
        this.customText5 = customText5;
    }

    public Date getCustomText6() {
        return customText6;
    }

    public void setCustomText6(Date customText6) {
        this.customText6 = customText6;
    }

    public String getCustomText7() {
        return customText7;
    }

    public void setCustomText7(String customText7) {
        this.customText7 = customText7;
    }

    public String getCustomText8() {
        return customText8;
    }

    public void setCustomText8(String customText8) {
        this.customText8 = customText8;
    }

    public String getCustomText9() {
        return customText9;
    }

    public void setCustomText9(String customText9) {
        this.customText9 = customText9;
    }

    public String getCustomText15() {
        return customText15;
    }

    public void setCustomText15(String customText15) {
        this.customText15 = customText15;
    }

    public Date getCustomText16() {
        return customText16;
    }

    public void setCustomText16(Date customText16) {
        this.customText16 = customText16;
    }

    public Date getCustomText17() {
        return customText17;
    }

    public void setCustomText17(Date customText17) {
        this.customText17 = customText17;
    }

    public String getCustomText18() {
        return customText18;
    }

    public void setCustomText18(String customText18) {
        this.customText18 = customText18;
    }
}
