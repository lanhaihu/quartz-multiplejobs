package com.boot.util;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhaos on 2018/7/7.
 */
public class ConstantInfoUtil {
    private static String userName;
    private static String passWord;
    private static String version;
    private static String url;

    public static String getUser(){
        return userName;
    }

    public static String getPassWord(){
        return passWord;
    }

    public static void setUserName(String user){
        userName = user;
    }

    public static void setPassWord(String pwd){
        passWord = pwd;
    }

    public static String getVersion(){
        return version;
    }

    public static void setVersion(String v){
        version = v;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ConstantInfoUtil.url = url;
    }
}
