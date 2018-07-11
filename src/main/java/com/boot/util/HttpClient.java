package com.boot.util;

//import com.sun.deploy.net.HttpResponse;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by zhaos on 2018/7/5.
 */
@Slf4j
public class HttpClient {
    public static String sendXmlByPut(String url, String xmlParam) throws Exception{
        log.info("url="+url);
        log.info("xmlParm="+xmlParam);
        int status = 0;
        HttpResponse<String> response = Unirest.put(url)
                .header("content-type", "application/xml")
                .header("cache-control", "no-cache")
                .body(xmlParam)
                .asString();
        status = response.getStatus();
        if(status == 200){
            return response.getBody();
        }else{
            log.error("请求异常");
            throw new Exception("请求异常");
        }
    }

    public static void main(String[] args) throws Exception {
        String url = "https://demo.otms.cn/ws/orderImport?ZAbR9ngZ=ONVdqpzx16As7ZeR";
        String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<orderImportRequest login=\"ZAbR9ngZ\" password=\"ONVdqpzx16As7ZeR\" version=\"0.1\"> \n" +
                "  <orders> \n" +
                "    <order sequence=\"0\"> \n" +
                "      <branch>西安</branch>  \n" +
                "      <cargoDetails> \n" +
                "        <totalWeight>24</totalWeight>  \n" +
                "        <totalVolume>4</totalVolume>  \n" +
                "        <cargoType>1</cargoType>  \n" +
                "        <packageType>A</packageType>  \n" +
                "        <totalQuantity>9</totalQuantity> \n" +
                "      </cargoDetails>  \n" +
                "      <clientReferenceNumber>SH001</clientReferenceNumber>  \n" +
                "      <customFields> \n" +
                "        <customText1>SX001</customText1>  \n" +
                "        <customText15>PC0001</customText15>  \n" +
                "        <customText16>2018-01-01 00:00:00</customText16>  \n" +
                "        <customText17>2018-01-01 00:00:00</customText17>  \n" +
                "        <customText18>baizhu备注</customText18>  \n" +
                "        <customText2>2018-01-01 00:00:00</customText2>  \n" +
                "        <customText3>销售员</customText3>  \n" +
                "        <customText4>18898988989</customText4>  \n" +
                "        <customText5>制单人</customText5>  \n" +
                "        <customText6>2018-01-01 00:00:00</customText6>  \n" +
                "        <customText7>CNEE</customText7>  \n" +
                "        <customText8>1</customText8>  \n" +
                "        <customText9>1</customText9> \n" +
                "      </customFields>  \n" +
                "      <erpNumber>SH001</erpNumber>  \n" +
                "      <orderLines> \n" +
                "        <orderLine> \n" +
                "          <cargoDescription> \n" +
                "            <productCode>WL00001</productCode>  \n" +
                "            <productName>物料名称</productName>  \n" +
                "            <unitType>4</unitType> \n" +
                "          </cargoDescription>  \n" +
                "          <quantity>6</quantity> \n" +
                "        </orderLine>  \n" +
                "        <orderLine> \n" +
                "          <cargoDescription> \n" +
                "            <productCode>WL00002</productCode>  \n" +
                "            <productName>物料名称2</productName>  \n" +
                "            <unitType>4</unitType> \n" +
                "          </cargoDescription>  \n" +
                "          <quantity>3</quantity> \n" +
                "        </orderLine> \n" +
                "      </orderLines>  \n" +
                "      <shipFrom> \n" +
                "        <companyName>chengdu</companyName>  \n" +
                "        <province>四川省</province>  \n" +
                "        <town>成都市</town>  \n" +
                "        <loading>false</loading>  \n" +
                "        <contact> \n" +
                "          <name>lianxiren</name>  \n" +
                "          <phone>88877722</phone>  \n" +
                "          <phoneAreaCode>029</phoneAreaCode>  \n" +
                "          <mobile>13571231099</mobile> \n" +
                "        </contact>  \n" +
                "        <locationRemarks>baizhu备注</locationRemarks> \n" +
                "      </shipFrom>  \n" +
                "      <shipTo> \n" +
                "        <companyName>CNEE</companyName>  \n" +
                "        <province>陕西省</province>  \n" +
                "        <town>西安市</town>  \n" +
                "        <county>临潼区</county>  \n" +
                "        <address>详细地址</address>  \n" +
                "        <loading>false</loading>  \n" +
                "        <contact> \n" +
                "          <name>shouhuolianxiren</name>  \n" +
                "          <phone>88999988</phone>  \n" +
                "          <phoneAreaCode>029</phoneAreaCode>  \n" +
                "          <mobile>13991919292</mobile> \n" +
                "        </contact> \n" +
                "      </shipTo>  \n" +
                "      <timeSchedule> \n" +
                "        <pickupDate>2018-01-01 00:00:00</pickupDate>  \n" +
                "        <deliveryDate>2018-01-05 00:00:00</deliveryDate>  \n" +
                "        <pickupTimeFrom>2018-01-01 01:11:11</pickupTimeFrom>  \n" +
                "        <pickupTimeTo>2018-01-01 02:22:22</pickupTimeTo>  \n" +
                "        <deliveryTimeFrom>2018-01-05 03:33:33</deliveryTimeFrom>  \n" +
                "        <deliveryTimeTo>2018-01-05 04:44:44</deliveryTimeTo> \n" +
                "      </timeSchedule>  \n" +
                "      <transportMode> \n" +
                "        <transportType>LTL</transportType>  \n" +
                "        <truckType>2</truckType> \n" +
                "      </transportMode>  \n" +
                "      <vendorcode>carrier</vendorcode> \n" +
                "    </order> \n" +
                "  </orders>\n" +
                "</orderImportRequest>\n";
      String  response = sendXmlByPut(url,body);
        System.out.print(response);
    }

    private static String getXmlInfo() {
              StringBuilder sb = new StringBuilder();
              sb.append("<?xml version='1.0' encoding='UTF-8'?>");
              sb.append("<Message>");
              sb.append(" <header>");
              sb.append("     <action>readMeetingStatus</action>");
              sb.append("     <service>meeting</service>");
              sb.append("     <type>xml</type>");
              sb.append("     <userName>admin</userName>");
              sb.append("     <password>admin</password>");
              sb.append("     <siteName>box</siteName>");
              sb.append(" </header>");
              sb.append(" <body>");
              sb.append("     <confKey>43283344</confKey>");
              sb.append(" </body>");
              sb.append("</Message>");

              return sb.toString();
    }
}
