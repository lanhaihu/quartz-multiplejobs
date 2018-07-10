package com.boot.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhaos on 2018/7/5.
 */
@Slf4j
public class HttpClient {
    public static String send(String url,String xmlParam) throws Exception{
        log.info("url="+url);
        log.info("xmlParm="+xmlParam);
        int status = 0;
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity requestEntity = new HttpEntity(xmlParam, headers);
        //  执行HTTP请求
        ResponseEntity<String> response = client.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        status = response.getStatusCode().value();
        if(status == 200){
            return response.getBody();
        }else{
            log.error("请求异常");
            throw new Exception("请求异常");
        }
    }
/*
    public static void main(String[] args) {
        String url = "https://demo.otms.cn/ws/orderImport?ZAbR9ngZ=ONVdqpzx16As7ZeR";
        String body = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<orderImportRequest version=\"0.1\" login=\"ZAbR9ngZ\" password=\"ONVdqpzx16As7ZeR\">\n" +
                "    <orders>\n" +
                "        <order sequence=\"1\">\n" +
                "            <erpNumber></erpNumber>\n" +
                "      \t    <branch>西安</branch>\n" +
                "            <clientReferenceNumber></clientReferenceNumber>\n" +
                "            <autoProcessMode>1</autoProcessMode>\n" +
                "\t    <vendorcode>966137</vendorcode>\n" +
                "      \t\t<customFields>\n" +
                "        \t\t<customText1>销售单号</customText1>\n" +
                "        \t\t<customText2>运输时限</customText2>\n" +
                "        \t\t<customText3>过账时间</customText3>\n" +
                "      \t\t</customFields>\n" +
                "            <shipFrom>\n" +
                "                <companyName>未央仓</companyName>\n" +
                "               <province>陕西省</province>\n" +
                "               <town>西安市</town>\n" +
                "\t       <county>雁塔区</county>\n" +
                "                <address>陕西省西安市未央区</address>\n" +
                "                <loading>false</loading>\n" +
                "                <contact>\n" +
                "                    <name>Jim</name>\n" +
                "                    <phone>56565579</phone>\n" +
                "            \t    <phoneAreaCode>0311</phoneAreaCode>\n" +
                "                    <mobile>13571231099</mobile>\n" +
                "                </contact>\n" +
                "                <locationRemarks></locationRemarks>\n" +
                "            </shipFrom>\n" +
                "            <shipTo>\n" +
                "                <companyName>西安A库</companyName>\n" +
                "               <province>陕西省</province>\n" +
                "               <town>西安市</town>\n" +
                "               <county>雁塔区</county>\n" +
                "\t\t<address>陕西省西安市碑林区</address>\n" +
                "                <loading>false</loading>\n" +
                "              <contact>\n" +
                "                    <name>Jim</name>\n" +
                "                    <phone>56565579</phone>\n" +
                "            \t    <phoneAreaCode>0311</phoneAreaCode>\n" +
                "                    <mobile>13571231099</mobile>\n" +
                "               </contact>\n" +
                "                <locationRemarks></locationRemarks>\n" +
                "            </shipTo>\n" +
                "            <timeSchedule>\n" +
                "                <pickupDate>2018-06-19</pickupDate>\n" +
                "\t\t<pickupTimeFrom>2018-06-19 00:00:00</pickupTimeFrom>\n" +
                "\t\t<pickupTimeTo>2018-06-19 23:59:59</pickupTimeTo>\n" +
                "                <deliveryDate>2018-06-30</deliveryDate>\n" +
                "\t\t<deliveryTimeFrom>2018-06-19 00:00:00</deliveryTimeFrom>\n" +
                "\t\t<deliveryTimeTo>2018-06-19 23:59:59</deliveryTimeTo>\n" +
                "            </timeSchedule>\n" +
                "            <orderLines>\n" +
                "                <orderLine>\n" +
                "                    <cargoDescription>\n" +
                "                        <productCode>air-PK-2305</productCode>\n" +
                "                        <productName>阿迪达斯</productName>\n" +
                "                        <unitType>2</unitType>\n" +
                "                        <unitLength>1</unitLength>    \n" +
                "                        <unitWidth>1</unitWidth>\n" +
                "                        <unitHeight>1</unitHeight>\n" +
                "                        <unitWeight>1</unitWeight>\n" +
                "                    </cargoDescription>\n" +
                "                    <quantity>200</quantity>\n" +
                "                </orderLine>\n" +
                "                <orderLine>\n" +
                "                    <cargoDescription>\n" +
                "                        <productCode>air-PK-2305</productCode>\n" +
                "                        <productName>阿迪达斯</productName>\n" +
                "                        <unitType>2</unitType>\n" +
                "                        <unitLength>1</unitLength>\n" +
                "                        <unitWidth>1</unitWidth>\n" +
                "                        <unitHeight>1</unitHeight>\n" +
                "                        <unitWeight>1</unitWeight>\n" +
                "                    </cargoDescription>\n" +
                "                    <quantity>200</quantity>\n" +
                "                </orderLine>\n" +
                "            </orderLines>\n" +
                "            <cargoDetails>\n" +
                "                <totalQuantity>400</totalQuantity>\n" +
                "                <totalWeight>400</totalWeight>\n" +
                "                <totalVolume>1</totalVolume>\n" +
                "                <cargoType>1</cargoType>\n" +
                "                <packageType>A</packageType>\n" +
                "            </cargoDetails>\n" +
                "            <transportMode>\n" +
                "                <transportType>LTL</transportType>\n" +
                "                <truckType>2</truckType>\n" +
                "                <transportRemarks></transportRemarks>\n" +
                "                <truckLength></truckLength>\n" +
                "            </transportMode>\n" +
                "        </order>\n" +
                "    </orders>\n" +
                "</orderImportRequest>";
       String result =  send(url,body);
       System.out.println(result);
    }*/
}
