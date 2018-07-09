package com.boot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;
/**
 * Created by zhaos on 2018/7/9.
 */
public class XmlyyyyMMddHHmmssDateAdapter extends XmlAdapter<String, Date> {
    private SimpleDateFormat yyyyMMddHHmm = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    @Override
    public Date unmarshal(String v) throws Exception {
        if ("无".equals(v)) {
            return null;
        }
        return yyyyMMddHHmm.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return yyyyMMddHHmm.format(v);
    }

}
