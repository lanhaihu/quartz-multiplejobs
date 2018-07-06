package com.boot.quartz.multiplejobs.entity.baseEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by zou on 2018/7/3.
 */
@XmlRootElement(name = "cargoDetails")
@XmlType(propOrder = {"totalWeight","totalVolume","cargoType","packageType"})
public class cargoDetailsEntity implements Serializable {
    private static final Long serialVersionUID=1L;
    private String totalWeight;
    private String totalVolume;
    private String cargoType;
    private String packageType;

    public cargoDetailsEntity() {
    }

    public cargoDetailsEntity(String totalWeight, String totalVolume, String cargoType, String packageType) {
        this.totalWeight = totalWeight;
        this.totalVolume = totalVolume;
        this.cargoType = cargoType;
        this.packageType = packageType;
    }
    @XmlElement(name = "totalWeight")
    public String getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(String totalWeight) {
        this.totalWeight = totalWeight;
    }
    @XmlElement(name = "totalVolume")
    public String getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(String totalVolume) {
        this.totalVolume = totalVolume;
    }
    @XmlElement(name="cargoType")
    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public String getPackageType() {
        return packageType;
    }

    @XmlElement(name = "packageType")
    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

}
