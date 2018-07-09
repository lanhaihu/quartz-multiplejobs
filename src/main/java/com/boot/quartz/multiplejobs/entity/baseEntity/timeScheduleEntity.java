package com.boot.quartz.multiplejobs.entity.baseEntity;

import com.boot.util.XmlyyyyMMddHHmmssDateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zou on 2018/7/3.
 */
@XmlRootElement(name = "timeSchedule")
@XmlType(propOrder = {"pickupDate","deliveryDate","pickupTimeFrom","pickupTimeTo","deliveryTimeFrom","deliveryTimeTo"})
public class timeScheduleEntity implements Serializable{
    private  static final Long serialVersionUID=1L;
    private Date pickupDate;
    private Date deliveryDate;

    private Date pickupTimeFrom;
    private Date pickupTimeTo;

    private Date deliveryTimeFrom;
    private Date deliveryTimeTo;

    @XmlElement(name = "pickupDate")
    @XmlJavaTypeAdapter(XmlyyyyMMddHHmmssDateAdapter.class)
    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    @XmlElement(name = "deliveryDate")
    @XmlJavaTypeAdapter(XmlyyyyMMddHHmmssDateAdapter.class)
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @XmlElement(name = "pickupTimeFrom")
    @XmlJavaTypeAdapter(XmlyyyyMMddHHmmssDateAdapter.class)
    public Date getPickupTimeFrom() {
        return pickupTimeFrom;
    }

    public void setPickupTimeFrom(Date pickupTimeFrom) {
        this.pickupTimeFrom = pickupTimeFrom;
    }

    @XmlElement(name = "pickupTimeTo")
    @XmlJavaTypeAdapter(XmlyyyyMMddHHmmssDateAdapter.class)
    public Date getPickupTimeTo() {
        return pickupTimeTo;
    }

    public void setPickupTimeTo(Date pickupTimeTo) {
        this.pickupTimeTo = pickupTimeTo;
    }

    @XmlElement(name = "deliveryTimeFrom")
    @XmlJavaTypeAdapter(XmlyyyyMMddHHmmssDateAdapter.class)
    public Date getDeliveryTimeFrom() {
        return deliveryTimeFrom;
    }

    public void setDeliveryTimeFrom(Date deliveryTimeFrom) {
        this.deliveryTimeFrom = deliveryTimeFrom;
    }

    @XmlElement(name = "deliveryTimeTo")
    @XmlJavaTypeAdapter(XmlyyyyMMddHHmmssDateAdapter.class)
    public Date getDeliveryTimeTo() {
        return deliveryTimeTo;
    }

    public void setDeliveryTimeTo(Date deliveryTimeTo) {
        this.deliveryTimeTo = deliveryTimeTo;
    }
}
