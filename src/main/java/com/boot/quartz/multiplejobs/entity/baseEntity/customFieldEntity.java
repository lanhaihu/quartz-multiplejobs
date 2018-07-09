package com.boot.quartz.multiplejobs.entity.baseEntity;

import com.boot.util.XmlyyyyMMddHHmmssDateAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zou on 2018/7/7.
 */
@XmlRootElement(name = "customFields")
public class customFieldEntity implements Serializable{
    private static final Long serialVersionUID=1L;

    String customText1; // 销售单号
    Date customText2; //过账时限
    String customText3; //业务员
    String customText4; //业务员电话
    String customText5; // 制单人
    Date customText6; //制单时间
    String customText7; // 客户名称
    String customText8; //交货单行号
    String customText9; //随货同行单行号
    String customText10;
    String customText11;
    String customText12;
    String customText13;
    String customText15; //批号
    Date customText16; //生产日期
    Date customText17; //有效期至
    String customText18; //备注

    @XmlElement(name ="customText1")
    public String getCustomText1() {
        return customText1;
    }

    public void setCustomText1(String customText1) {
        this.customText1 = customText1;
    }
    @XmlElement(name ="customText2")
    @XmlJavaTypeAdapter(XmlyyyyMMddHHmmssDateAdapter.class)
    public Date getCustomText2() {
        return customText2;
    }

    public void setCustomText2(Date customText2) {
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
    @XmlJavaTypeAdapter(XmlyyyyMMddHHmmssDateAdapter.class)
    public Date getCustomText6() {
        return customText6;
    }

    public void setCustomText6(Date customText6) {
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

    @XmlElement(name ="customText15")
    public String getCustomText15() {
        return customText15;
    }

    public void setCustomText15(String customText15) {
        this.customText15 = customText15;
    }

    @XmlElement(name ="customText16")
    @XmlJavaTypeAdapter(XmlyyyyMMddHHmmssDateAdapter.class)
    public Date getCustomText16() {
        return customText16;
    }

    public void setCustomText16(Date customText16) {
        this.customText16 = customText16;
    }

    @XmlElement(name ="customText17")
    @XmlJavaTypeAdapter(XmlyyyyMMddHHmmssDateAdapter.class)
    public Date getCustomText17() {
        return customText17;
    }

    public void setCustomText17(Date customText17) {
        this.customText17 = customText17;
    }

    @XmlElement(name ="customText18")
    public String getCustomText18() {
        return customText18;
    }

    public void setCustomText18(String customText18) {
        this.customText18 = customText18;
    }
}
