package com.boot.quartz.multiplejobs.entity.baseEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by zou on 2018/7/3.
 */
@XmlRootElement(name="transportMode")
@XmlType(propOrder = { "transportType","truckType"})
public class transportModeEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    private String transportType;
    private String truckType;

    public transportModeEntity(){

    }
    public transportModeEntity(String transportType, String truckType) {
        this.transportType = transportType;
        this.truckType = truckType;
    }
    @XmlElement(name="transportType")
    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }
    @XmlElement(name = "truckType")
    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }
}
