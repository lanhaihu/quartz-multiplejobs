package com.boot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by zhaos on 2018/7/7.
 */

public class ConstantInfoUtil {


    private static String USERNAME;


    private static String USERPASSWORD;


    private static String REQUESTVERSION;


    private static String REQUESTURL;

    public static AtomicBoolean importOrderRunningFlg = new AtomicBoolean(false);

    public static String getUser(){
        return USERNAME;
    }

    public static String getPassWord(){
        return USERPASSWORD;
    }

    public static String getVersion(){
        return REQUESTVERSION;
    }

    public static String getUrl() { return REQUESTURL;}


    public static void setUSERNAME(String uSERNAME) {
        USERNAME = uSERNAME;
    }


    public static void setUSERPASSWORD(String uSERPASSWORD) {
        USERPASSWORD = uSERPASSWORD;
    }


    public static void setREQUESTVERSION(String rEQUESTVERSION) {
        REQUESTVERSION = rEQUESTVERSION;
    }


    public static void setREQUESTURL(String rEQUESTURL) {
        REQUESTURL = rEQUESTURL;
    }

    public static String codeMapper(String code){
        String result = "";
        switch (code){
            case "1000" :	result = "客户代码未找到。";break;
            case "1001" :	result = "无效的数据类型。可检查当前的电话号码格式是否正确（座机与手机格式应不同）";break;
            case "1002" :	result = "备用。";break;
            case "1003" :	result = "shipFromExternalId发货方外部代码未找到。";break;
            case "1004" :	result = "shipToExternalId收货方外部代码未找到。";break;
            case "1005" :	result = "singleLine/externalId产品明细/货物(产品)外部代码未找到。";break;
            case "1006" :	result = "缺少transportType运输方式。";break;
            case "1007" :	result = "truckType车辆类型匹配结果不唯一。";break;
            case "1008" :	result = "truckType车辆类型不匹配。";break;
            case "1009" :	result = "发货方外部代码重复。";break;
            case "1010" :	result = "收货方外部代码重复。";break;
            case "1011" :	result = "货物(产品)外部代码重复。";break;
            case "1012" :	result = "订单未设置价格(仅针对承运商)。";break;
            case "1013" :	result = "发货方oTMS邮政编码匹配到乡镇。";break;
            case "1014" :	result = "发货方oTMS邮政编码只与6位邮政编码匹配。";break;
            case "1015" :	result = "发货方oTMS邮政编码不匹配。";break;
            case "1016" :	result = "发货方oTMS邮政编码与6位和乡镇的都匹配。";break;
            case "1017" :	result = "收货方oTMS邮政编码只与乡镇匹配。";break;
            case "1018" :	result = "收货方邮政编码只与6位邮政编码匹配。";break;
            case "1019" :	result = "收货方oTMS邮政编码不匹配。";break;
            case "1020" :	result = "收货方oTMS邮政编码与6位和乡镇匹配。";break;
            case "1021" :	result = "缺少货物/产品信息。订单明细中至少需提供externalId或cargoDescription之一。";break;
            case "1022" :	result = "ERP单号重复。订单不能导入。";break;
            case "1023" :	result = "试图更新的订单不是由导入接口导入。更新被拒绝。";break;
            case "1024" :	result = "试图更新的订单不在收件箱或草稿箱中。更新被拒绝。";break;
            case "1025" :	result = "没有匹配的价格文件。";break;
            case "1026" :	result = "匹配了多个价格文件。";break;
            case "1027" :	result = "订单信息不全无法自动分配。";break;
            case "1028" :	result = "未提供司机和卡车的信息。";break;
            case "1029" :	result = "匹配到的卡车不唯一。";break;
            case "1030" :	result = "自定义字段不能识别——可能公司已经取消了自定义字段。订单不能导入。";break;
            case "1031" :	result = "未启用自定义字段,将忽略导入订单中的自定义字段。";break;
            case "1032" :	result = "订单缺少必填的自定义字段。订单不能导入。";break;
            case "1033" :	result = "未定义的自定义字段枚举值。订单不能导入。";break;
            case "1034" :	result = "订单明细缺少必填的自定义字段。订单不能导入。";break;
            case "1035" :	result = "用户地区和试图更新的订单地区不匹配。更新被拒绝。";break;
            case "1036" :	result = "货物/产品明细列表中有货物/产品的产品类别无效。订单不能导入。";break;
            case "1037" :	result = "试图更新的订单的货物/产品明细列表中有货物/产品的产品类别不可更新。更新被拒绝。";break;
            case "1040" :	result = "地区不存在。";break;
            case "1041" :	result = "未提供发货方。";break;
            case "1042" :	result = "未提供收货方。";break;
            case "1043" :	result = "分公司未识别,或用户权限不匹配。";break;
            case "1044" :	result = "拒绝草稿状态订单。rejectDraft为true时,不完整订单将被拒绝而非进入草稿箱。";break;
            case "1049" :	result = "订单信息不完整，订单信息或货物/产品明细信息无效。";break;
            case "1052" :	result = "发货方oTMS邮政编码只与乡镇匹配。";break;
            case "1053" :	result = "收货方oTMS邮政编码只与乡镇匹配。";break;
            case "1070" :	result = "承运商的状态异常。";break;
            case "1072" :	result = "试图更新的订单已有货差。更新被拒绝。";break;
            case "1073" :	result = "试图更新的订单已在账单中。更新被拒绝。";break;
            case "1080" :	result = "无法匹配到卡车。";break;
            case "1081" :	result = "匹配到的卡车与订单不匹配。";break;
            case "1082" :	result = "无法匹配到司机。";break;
            case "1083" :	result = "匹配到的司机不唯一。";break;
            case "1084" :	result = "匹配到的卡车已在途,且绑定的司机不匹配。";break;
            case "1085" :	result = "匹配到的司机已在途,且绑定的卡车不匹配。";break;
            case "1086" :	result = "试图更新的订单被锁定。更新被拒绝。";break;
            case "1090" :	result = "试图更新的订单只能被订单所属公司更新。更新被拒绝。";break;
            case "1091" :	result = "试图更新的订单货物信息有无效信息。更新被拒绝。";break;
            case "1094" :	result = "货物类型和温度报警阀值不匹配。";break;
            case "1095" :	result = "温度报警阀值无效。";break;
            case "1096" :	result = "温控箱编号无效。";break;
            case "1097" :	result = "包装类型和温控箱编号不匹配。";break;
            case "1100" :	result = "其他错误。";break;
            case "1116" :	result = "订单导入时，订单总重或总体积不在配置的总重或总体积的正常范围内。";break;
            case "1117" :	result = "订单更新时，被更新订单的总重或总体积不在配置的总重或总体积的正常范围内。";break;
            case "1118" :	result = "发货方如果email里需要追踪信息的连接， Email 或者手机号是必填。订单不能导入。";break;
            case "1119" :	result = "收货方如果email里需要追踪信息的连接， Email 或者手机号是必填。订单不能导入。";break;
            case "1120" :	result = "收货点和发货点不能重复。";break;
            default: result="当前响应CODE："+code+"无对应的映射值，请联系平台客服";
        }
        return result;
    }
}
