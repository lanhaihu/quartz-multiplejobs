package convertTest;


import com.boot.quartz.multiplejobs.entity.OrderImportRequestEntity;
import com.boot.quartz.multiplejobs.entity.OrderImportResponseEntity;
import com.boot.util.XmlConverter;
import org.junit.Test;

/**
 * Created by zou on 2018/7/5.
 */
public class TestXmlChangeEntity {
        @Test
        public void XmlToEntity(){
         OrderImportResponseEntity entityRespones= (OrderImportResponseEntity) XmlConverter.convertXmlFileToObject(OrderImportResponseEntity.class,"E:\\qy_code\\quartz-multiplejobs\\src\\test\\java\\convertTest\\orderImportRespone.xml");
         System.out.print("reponseConvertToEntiy is ok");
         String xml=XmlConverter.convertToXml(entityRespones);
         System.out.print("entityConvertToRespons is ok");

         OrderImportRequestEntity entityRequest= (OrderImportRequestEntity) XmlConverter.convertXmlFileToObject(OrderImportRequestEntity.class,"E:\\qy_code\\quartz-multiplejobs\\src\\test\\java\\convertTest\\orderImportRequest.xml");
         System.out.print("requestConvertToEntiy is ok");
         String xmls=XmlConverter.convertToXml(entityRequest);
         System.out.print("entityConvertTorequest is ok");
        }
}
