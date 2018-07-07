package com.boot.quartz.multiplejobs.entity.baseEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by zou on 2018/7/6.
 */
@XmlRootElement(name = "cargoDescription")
public class cargoDescriptionEntity implements Serializable {
    private static final Long serialVersionUID=1L;
    private String productCode;
    private String productName;
    private String unitType;
    private String unitLength;
    private String unitWidth;
    private String unitHeight;
    private String unitWeight;

    public cargoDescriptionEntity(String productCode, String productName, String unitType, String unitLength, String unitWidth, String unitHeight, String unitWeight) {
        this.productCode = productCode;
        this.productName = productName;
        this.unitType = unitType;
        this.unitLength = unitLength;
        this.unitWidth = unitWidth;
        this.unitHeight = unitHeight;
        this.unitWeight = unitWeight;
    }

    public cargoDescriptionEntity() {
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    @XmlElement(name = "productCode")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    @XmlElement(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    @XmlElement(name = "unitType")
    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @XmlElement(name = "unitLength")
    public String getUnitLength() {
        return unitLength;
    }

    public void setUnitLength(String unitLength) {
        this.unitLength = unitLength;
    }
    @XmlElement(name = "unitWidth")
    public String getUnitWidth() {
        return unitWidth;
    }

    public void setUnitWidth(String unitWidth) {
        this.unitWidth = unitWidth;
    }
    @XmlElement(name = "unitHeight")
    public String getUnitHeight() {
        return unitHeight;
    }

    public void setUnitHeight(String unitHeight) {
        this.unitHeight = unitHeight;
    }
    @XmlElement(name = "unitWeight")
    public String getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(String unitWeight) {
        this.unitWeight = unitWeight;
    }
}
