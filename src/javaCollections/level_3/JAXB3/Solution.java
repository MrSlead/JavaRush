package javaCollections.level_3.JAXB3;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javaCollections.level_3.JAXB3.Shop.Goods;                                                  
                                                  
/*                                                   
Создание класса по строке xml                                                  
*/                                                  
public class Solution {                                                  
    public static void main(String[] args) throws JAXBException {                                                  
        String xmlData =                                                  
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +                                                  
                        "<shop>\n" +                                                  
                        "    <goods>\n" +                                                  
                        "        <names>S1</names>\n" +                                                  
                        "        <names>S2</names>\n" +                                                  
                        "    </goods>\n" +                                                  
                        "    <count>12</count>\n" +                                                  
                        "    <profit>123.4</profit>\n" +                                                  
                        "    <secretData>String1</secretData>\n" +                                                  
                        "    <secretData>String2</secretData>\n" +                                                  
                        "    <secretData>String3</secretData>\n" +                                                  
                        "    <secretData>String4</secretData>\n" +                                                  
                        "    <secretData>String5</secretData>\n" +                                                  
                        "</shop>";                                                  
                                                  
        StringReader reader = new StringReader(xmlData);                                                  
                                                  
        JAXBContext context = JAXBContext.newInstance(getClassName());                                                  
        Unmarshaller unmarshaller = context.createUnmarshaller();                                                  
                                                  
        Object o = unmarshaller.unmarshal(reader);                                                  
                                                  
        System.out.println(o.toString()); 
        
        /*context = JAXBContext.newInstance(Shop.class); 
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 
        
        StringWriter writer = new StringWriter();
        Shop shop = new Shop();
        shop.setCount(12);
        shop.setProfit(123.4);
        shop.setSecretData(new String[] {"String", "String2", "String3"});
        Goods goods = new Goods();
        goods.setNames("S", "S2", "S3");
        shop.setGoods(goods);

        marshaller.marshal(shop, writer);
        System.out.println(writer.toString());*/
    }                                                  
                                                  
    public static Class getClassName() {                                                  
        return Shop.class;
    }                                               
}