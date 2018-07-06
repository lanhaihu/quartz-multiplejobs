package com.boot.quartz.multiplejobs.entity.baseEntity;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created by zou on 2018/7/6.
 */
@XmlRootElement(name = "order")
@XmlType(propOrder = {"clientReferenceNumber","importStatus","responseCodes","orderNumber"})
public class orderResponseEntity implements Serializable{
    private static final Long serialVersionUID=1L;
    private String sequence;
    private String clientReferenceNumber;
    private String importStatus;
    private List<responseCodeEntity> responseCodes;
    private String orderNumber;

    public orderResponseEntity(String sequence, String clientReferenceNumber, String importStatus, List<responseCodeEntity> responseCodes, String orderNumber) {
        this.sequence = sequence;
        this.clientReferenceNumber = clientReferenceNumber;
        this.importStatus = importStatus;
        this.responseCodes = responseCodes;
        this.orderNumber = orderNumber;
    }

    public orderResponseEntity() {
    }

    @XmlAttribute(name = "sequence")
    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
    @XmlElement(name = "clientReferenceNumber")
    public String getClientReferenceNumber() {
        return clientReferenceNumber;
    }

    public void setClientReferenceNumber(String clientReferenceNumber) {
        this.clientReferenceNumber = clientReferenceNumber;
    }

    @XmlElement(name = "importStatus")
    public String getImportStatus() {
        return importStatus;
    }

    public void setImportStatus(String importStatus) {
        this.importStatus = importStatus;
    }

    @XmlElementWrapper(name="responseCodes")
    @XmlElement(name = "responseCode")
    public List<responseCodeEntity> getResponseCodes() {
        return responseCodes;
    }

    public void setResponseCodes(List<responseCodeEntity> responseCodes) {
        this.responseCodes = responseCodes;
    }
    @XmlElement(name = "orderNumber")
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
