package com.boot.quartz.multiplejobs.entity.baseEntity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by zou on 2018/7/7.
 */
@XmlRootElement(name = "customFields")
public class customFieldEntity implements Serializable{
    private static final Long serialVersionUID=1L;
    @XmlElement(name ="customText1")
    @Autowired
    private String customText1;

    @XmlElement(name ="customText2")
    @Autowired
    private String customText2;

    @XmlElement(name ="customText3")
    @Autowired

    private String customText3;
    @XmlElement(name ="customText4")
    @Autowired
    private String customText4;

    @XmlElement(name ="customText5")
    @Autowired
    private String customText5;

    @XmlElement(name ="customText6")
    @Autowired
    private String customText6;

    @XmlElement(name ="customText7")
    @Autowired
    private String customText7;

    @XmlElement(name ="customText8")
    @Autowired
    private String customText8;

    @XmlElement(name ="customText9")
    @Autowired
    private String customText9;

    @XmlElement(name ="customText10")
    @Autowired
    private String customText10;

    @XmlElement(name ="customText11")
    @Autowired
    private String customText11;

    @XmlElement(name ="customText12")
    @Autowired
    private String customText12;

    @XmlElement(name ="customText13")
    @Autowired
    private String customText13;
}
