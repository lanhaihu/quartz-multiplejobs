package com.boot.quartz.multiplejobs.entity.baseEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by zou on 2018/7/3.
 */
@XmlRootElement(name = "shipTo")
@XmlType(propOrder = {"companyName","postcode","address","loading", "contactEntityEntiy","locationRemarks"})
public class shipToEntity implements Serializable {
    private static final Long serialVersionUID=1L;
    private String companyName;
    private String postcode;
    private String  address;
    private boolean loading;
    private contactEntity contactEntityEntiy;
    private String locationRemarks;

    public shipToEntity() {
    }

    public shipToEntity(String companyName, String postcode, String address, boolean loading, contactEntity contactEntityEntiy, String locationRemarks) {
        this.companyName = companyName;
        this.postcode = postcode;
        this.address = address;
        this.loading = loading;
        this.contactEntityEntiy = contactEntityEntiy;
        this.locationRemarks = locationRemarks;
    }

    @XmlElement(name = "companyName")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @XmlElement(name = "postcode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @XmlElement(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement(name = "loading")
    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    @XmlElement(name = "contact")
    public contactEntity getContactEntityEntiy() {
        return contactEntityEntiy;
    }

    public void setContactEntityEntiy(contactEntity contactEntityEntiy) {
        this.contactEntityEntiy = contactEntityEntiy;
    }

    @XmlElement(name = "locationRemarks")
    public String getLocationRemarks() {
        return locationRemarks;
    }

    public void setLocationRemarks(String locationRemarks) {
        this.locationRemarks = locationRemarks;
    }
}