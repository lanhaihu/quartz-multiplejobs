package com.boot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by zhaos on 2018/7/7.
 */

public class ConstantInfoUtil {


    private static String USERNAME;


    private static String USERPASSWORD;


    private static String REQUESTVERSION;


    private static String REQUESTURL;

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
}
