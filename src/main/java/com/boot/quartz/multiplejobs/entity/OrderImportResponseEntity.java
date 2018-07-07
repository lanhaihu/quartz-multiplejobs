package com.boot.quartz.multiplejobs.entity;



import com.boot.quartz.multiplejobs.entity.baseEntity.orderResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zou on 2018/7/6.
 */
@XmlRootElement(name = "orderImportResponse")
@XmlType(propOrder = {"responseCode","processedOrders","orders"})
public class OrderImportResponseEntity implements Serializable{

    private String version;


    private String responseCode;

    private String processedOrders;
    private List<orderResponseEntity> orders;

    public OrderImportResponseEntity(String version, String responseCode, String processedOrders, List<orderResponseEntity> orders) {
        this.version = version;
        this.responseCode = responseCode;
        this.processedOrders = processedOrders;
        this.orders = orders;
    }

    public OrderImportResponseEntity() {
    }

    @XmlAttribute(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    @XmlElement(name = "processedOrders")
    public String getProcessedOrders() {
        return processedOrders;
    }

    public void setProcessedOrders(String processedOrders) {
        this.processedOrders = processedOrders;
    }
    @XmlElementWrapper(name = "orders")
    @XmlElement(name = "order")
    public List<orderResponseEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<orderResponseEntity> orders) {
        this.orders = orders;
    }

    @XmlElement(name = "responseCode")
    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
