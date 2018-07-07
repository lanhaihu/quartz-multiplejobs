package com.boot.quartz.multiplejobs.entity.baseEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zou on 2018/7/3.
 */
@XmlRootElement(name = "timeSchedule")
@XmlType(propOrder = {"pickupDate","deliveryDate"})
public class timeScheduleEntity implements Serializable{
    private  static final Long serialVersionUID=1L;
    private Date pickupDate;
    private Date deliveryDate;
    @XmlElement(name = "pickupDate")
    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    @XmlElement(name = "deliveryDate")
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
