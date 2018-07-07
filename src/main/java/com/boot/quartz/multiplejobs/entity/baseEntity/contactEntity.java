package com.boot.quartz.multiplejobs.entity.baseEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by zou on 2018/7/3.
 */
@XmlRootElement(name = "contact")
@XmlType(propOrder = {"name","phone","phoneAreaCode","mobile","email"})
public class contactEntity implements Serializable{
    private static final Long serialVersionUID=1L;
    private  String name;
    private  String  phone;
    private  String phoneAreaCode;
    private  String mobile;
    private String email;

    public contactEntity() {
    }

    public contactEntity(String name, String phone, String phoneAreaCode, String mobile, String email) {
        this.name = name;
        this.phone = phone;
        this.phoneAreaCode = phoneAreaCode;
        this.mobile = mobile;
        this.email = email;
    }
    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlElement(name = "phoneAreaCode")
    public String getPhoneAreaCode() {
        return phoneAreaCode;
    }

    public void setPhoneAreaCode(String phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode;
    }

    @XmlElement(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @XmlElement(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
