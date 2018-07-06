package com.boot.quartz.multiplejobs.entity.baseEntity;

import javax.print.attribute.standard.MediaSize;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zou on 2018/7/3.
 */
@XmlRootElement(name="order")
public class orderInfoEntity implements Serializable{
    private static final Long serialVersionUID=1L;
    private int sequence;
    private String clientCode;
    private String branch;
    private String vendorcode;
    private String customFields;
    private String clientReferenceNumber;
    private String erpNumber;
    private shipFromEntity shipFrom;
    private shipToEntity shipTo;
    private List<orderLineEntity> orderLines;
    private timeScheduleEntity timeSchedule;
    private cargoDetailsEntity cargoDetails;
    private transportModeEntity transportMode;

    public orderInfoEntity() {
    }


    @XmlAttribute(name = "sequence")
    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @XmlElement(name = "clientCode")
    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    @XmlElement(name = "clientReferenceNumber")
    public String getClientReferenceNumber() {
        return clientReferenceNumber;
    }

    public void setClientReferenceNumber(String clientReferenceNumber) {
        this.clientReferenceNumber = clientReferenceNumber;
    }

    @XmlElement(name = "erpNumber")
    public String getErpNumber() {
        return erpNumber;
    }

    public void setErpNumber(String erpNumber) {
        this.erpNumber = erpNumber;
    }

    @XmlElement(name = "shipFrom")
    public shipFromEntity getShipFrom() {
        return shipFrom;
    }

    public void setShipFrom(shipFromEntity shipFrom) {
        this.shipFrom = shipFrom;
    }

    @XmlElement(name = "shipTo")
    public shipToEntity getShipTo() {
        return shipTo;
    }

    public void setShipTo(shipToEntity shipTo) {
        this.shipTo = shipTo;
    }

    @XmlElement(name = "timeSchedule")
    public timeScheduleEntity getTimeSchedule() {
        return timeSchedule;
    }

    public void setTimeSchedule(timeScheduleEntity timeSchedule) {
        this.timeSchedule = timeSchedule;
    }

    @XmlElement(name = "cargoDetails")
    public cargoDetailsEntity getCargoDetails() {
        return cargoDetails;
    }

    public void setCargoDetails(cargoDetailsEntity cargoDetails) {
        this.cargoDetails = cargoDetails;
    }
    @XmlElement(name = "transportMode")
    public transportModeEntity getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(transportModeEntity transportMode) {
        this.transportMode = transportMode;
    }
    @XmlElement(name = "branch")
    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
    @XmlElement(name="vendorcode")
    public String getVendorcode() {
        return vendorcode;
    }

    public void setVendorcode(String vendorcode) {
        this.vendorcode = vendorcode;
    }
    @XmlElement(name="customFields")
    public String getCustomFields() {
        return customFields;
    }

    public void setCustomFields(String customFields) {
        this.customFields = customFields;
    }

    @XmlElementWrapper(name = "orderLines")
    @XmlElement(name = "orderLine")
    public List<orderLineEntity> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<orderLineEntity> orderLines) {
        this.orderLines = orderLines;
    }
}
