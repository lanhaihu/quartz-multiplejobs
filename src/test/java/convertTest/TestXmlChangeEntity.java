package convertTest;


import com.boot.quartz.multiplejobs.entity.OrderImportRequestEntity;
import com.boot.quartz.multiplejobs.entity.OrderImportResponseEntity;
import com.boot.quartz.multiplejobs.entity.baseEntity.customFieldEntity;
import com.boot.util.HttpClient;
import com.boot.util.XmlConverter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * Created by zou on 2018/7/5.
 */
public class TestXmlChangeEntity {
        public void setup(){


        }

        @Test
        public void xmlToEntity(){

         OrderImportResponseEntity entityRespones= (OrderImportResponseEntity) XmlConverter.convertXmlFileToObject(OrderImportResponseEntity.class,"E:\\qy_code\\quartz-multiplejobs\\src\\test\\java\\convertTest\\orderImportRespone.xml");
         System.out.print("reponseConvertToEntiy is ok");
         String xml=XmlConverter.convertToXml(entityRespones);
         System.out.print("entityConvertToRespons is ok");

         OrderImportRequestEntity entityRequest= (OrderImportRequestEntity) XmlConverter.convertXmlFileToObject(OrderImportRequestEntity.class,"E:\\qy_code\\quartz-multiplejobs\\src\\test\\java\\convertTest\\orderImportRequest.xml");
         System.out.print("requestConvertToEntiy is ok");
         String xmls=XmlConverter.convertToXml(entityRequest);
         System.out.print("entityConvertTorequest is ok");

//         String response= HttpClient.send()
          customFieldEntity testentiy=new customFieldEntity();
          try{
              String response=HttpClient.send("https://demo.otms.cn/ws/orderImport",xmls);
             entityRespones= (OrderImportResponseEntity) XmlConverter.convertXmlStrToObject(OrderImportResponseEntity.class,response);
          }catch (Exception e){
          }
        }
}
