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
 
    private String customText1;


    private String customText2;



    private String customText3;

 
    private String customText4;


 
    private String customText5;


 
    private String customText6;


 
    private String customText7;

 
    private String customText8;


 
    private String customText9;

 
    private String customText10;


 
    private String customText11;


 
    private String customText12;
    
 
    private String customText13;

    @XmlElement(name ="customText1")
    public String getCustomText1() {
        return customText1;
    }

    public void setCustomText1(String customText1) {
        this.customText1 = customText1;
    }
    @XmlElement(name ="customText2")
    public String getCustomText2() {
        return customText2;
    }

    public void setCustomText2(String customText2) {
        this.customText2 = customText2;
    }
    @XmlElement(name ="customText3")
    public String getCustomText3() {
        return customText3;
    }

    public void setCustomText3(String customText3) {
        this.customText3 = customText3;
    }
    @XmlElement(name ="customText4")
    public String getCustomText4() {
        return customText4;
    }

    public void setCustomText4(String customText4) {
        this.customText4 = customText4;
    }
    @XmlElement(name ="customText5")
    public String getCustomText5() {
        return customText5;
    }

    public void setCustomText5(String customText5) {
        this.customText5 = customText5;
    }
    @XmlElement(name ="customText6")
    public String getCustomText6() {
        return customText6;
    }

    public void setCustomText6(String customText6) {
        this.customText6 = customText6;
    }
    @XmlElement(name ="customText7")
    public String getCustomText7() {
        return customText7;
    }

    public void setCustomText7(String customText7) {
        this.customText7 = customText7;
    }
    @XmlElement(name ="customText8")
    public String getCustomText8() {
        return customText8;
    }

    public void setCustomText8(String customText8) {
        this.customText8 = customText8;
    }
    @XmlElement(name ="customText9")
    public String getCustomText9() {
        return customText9;
    }

    public void setCustomText9(String customText9) {
        this.customText9 = customText9;
    }
    @XmlElement(name ="customText10")
    public String getCustomText10() {
        return customText10;
    }

    public void setCustomText10(String customText10) {
        this.customText10 = customText10;
    }
    @XmlElement(name ="customText11")
    public String getCustomText11() {
        return customText11;
    }

    public void setCustomText11(String customText11) {
        this.customText11 = customText11;
    }
    @XmlElement(name ="customText12")
    public String getCustomText12() {
        return customText12;
    }

    public void setCustomText12(String customText12) {
        this.customText12 = customText12;
    }
    @XmlElement(name ="customText13")
    public String getCustomText13() {
        return customText13;
    }

    public void setCustomText13(String customText13) {
        this.customText13 = customText13;
    }
}
