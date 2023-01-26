package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
 public static  Properties properties;
 /*
 METHODU DEVREYE SOKABILMEK ICIN  FILEINPUTSTREAM ILE DOSYA YOLUNU BELITMEMIZ GEREKIR
 METHODDAN ONCE CALISMASI ICIN STATIC BLOK ICERISINE FILEINPUTSTREAM OLUSTURMAMIZ GEREKIR.
  */
    static {
        String dosyaYolu="config.properties";
     try {
         FileInputStream fis=new FileInputStream(dosyaYolu);
         properties=new Properties();//yukarda olusturdugumuz objesinin atamasini yaptik
         properties.load(fis);//fis'in okudugu bilgiuleri properties'e yukler
     } catch (IOException e) {
         throw new RuntimeException(e);
     }
 }
    public static String getProperty(String key){
        /*
        Test methodundan gonderdigimiz string key degerini alip properties class'indan
        getProperty() methodunu kullanarak bu key'e ait value degerini bize gertirir.
         */
        return properties.getProperty(key);
    }
}
