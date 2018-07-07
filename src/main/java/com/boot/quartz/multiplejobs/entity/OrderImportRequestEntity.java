package com.boot.quartz.multiplejobs.entity;



import com.boot.quartz.multiplejobs.entity.baseEntity.orderInfoEntity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zou on 2018/7/3.
 */
@XmlRootElement(name="orderImportRequest")
public class OrderImportRequestEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String version;
    private String login;
    private String password;
    private List<orderInfoEntity> orders;

    public OrderImportRequestEntity(){

    };

    public OrderImportRequestEntity(String version, String login, String password, List<orderInfoEntity> orders) {
        this.version = version;
        this.login = login;
        this.password = password;
        this.orders = orders;
    }

    @XmlAttribute(name="version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    @XmlAttribute(name="login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @XmlAttribute(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @XmlElementWrapper(name="orders")
    @XmlElement(name="order")
    public List<orderInfoEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<orderInfoEntity> orders) {
        this.orders = orders;
    }
}
