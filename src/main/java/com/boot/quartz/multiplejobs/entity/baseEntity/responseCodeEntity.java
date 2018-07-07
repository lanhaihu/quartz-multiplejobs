package com.boot.quartz.multiplejobs.entity.baseEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by zou on 2018/7/6.
 */
@XmlRootElement(name = "responseCode")
public class responseCodeEntity {
    private String  code;

    @XmlElement(name="code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public responseCodeEntity(String code) {
        this.code = code;
    }

    public responseCodeEntity() {
    }
}
