package com.boot.quartz.multiplejobs.entity.baseEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by zou on 2018/7/3.
 */
@XmlRootElement(name = "shipFrom")
@XmlType(propOrder = {"companyName","postcode","address","loading", "contactEntityEntiy","locationRemarks"})
public class shipFromEntity implements Serializable {
    private static final Long serialVersionUID=1L;
    private String companyName;
    private String postcode;
    private String province;
    private String town;
    private String county;
    private String  address;
    private String loading;
    private contactEntity contactEntityEntiy;
    private String locationRemarks;

    public shipFromEntity() {
    }

    public shipFromEntity(String companyName, String postcode, String address, String loading, contactEntity contactEntityEntiy, String locationRemarks) {
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
    public String isLoading() {
        return loading;
    }

    public void setLoading(String loading) {
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

    @XmlElement(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @XmlElement(name = "town")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @XmlElement(name = "county")
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLoading() {
        return loading;
    }
}
