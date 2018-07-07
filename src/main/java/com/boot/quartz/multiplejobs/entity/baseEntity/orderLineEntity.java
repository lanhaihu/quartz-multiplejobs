package com.boot.quartz.multiplejobs.entity.baseEntity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by zou on 2018/7/5.
 */
@XmlRootElement(name = "orderLine")
public class orderLineEntity implements Serializable{
    private static final Long serialVersionUID=1L;
    private cargoDescriptionEntity cargoDescription;
    private String quantity;

    public orderLineEntity(cargoDescriptionEntity cargoDescription, String quantity) {
        this.cargoDescription = cargoDescription;
        this.quantity = quantity;
    }

    public orderLineEntity() {
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }
    @XmlElement(name="cargoDescription")
    public cargoDescriptionEntity getCargoDescription() {
        return cargoDescription;
    }

    public void setCargoDescription(cargoDescriptionEntity cargoDescription) {
        this.cargoDescription = cargoDescription;
    }
    @XmlElement(name = "quantity")
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
