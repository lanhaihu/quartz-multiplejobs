package com.boot.quartz.multiplejobs.entity;



import com.boot.quartz.multiplejobs.entity.baseEntity.orderResponseEntity;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by zou on 2018/7/6.
 */
@XmlRootElement(name = "orderImportResponse")
@XmlType(propOrder = {"processedOrders","orders"})
public class OrderImportResponseEntity {
    private String version;
    private String processedOrders;
    private List<orderResponseEntity> orders;

    public OrderImportResponseEntity(String version, String processedOrders, List<orderResponseEntity> orders) {
        this.version = version;
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
}
