package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class PageKullanimi {
    @Test(groups = "gp1")
    public void testName() {
        AmazonPage amazonPage=new AmazonPage();
        //amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        //iphonearatalim
        amazonPage.aramaKutusu.sendKeys("iphone", Keys.ENTER);
        //sonuc yazisinin iphone icerdigini test edelim
      String actualSonuc=  amazonPage.sonucYazisi.getText();
      String arananKelime="iphone";
      assert actualSonuc.contains(arananKelime);
      Driver.closeDriver();
    }

}
