package tests;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DhtmlPage;
import utilities.ConfigReader;
import utilities.Driver;


public class Practice01 {
    /*
--http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html adresine gidiniz
--Tüm ülkeleri yazdırınız
--Ülkeler ile şehirleri eşleştiriniz
 */
    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("dhtmlUrl"));
        DhtmlPage dhtmlPage=new DhtmlPage();
        dhtmlPage.ulkeler.forEach(t-> System.out.println(t.getText()));
        Actions action= new Actions(Driver.getDriver());
        action.dragAndDrop(dhtmlPage.Seoul,dhtmlPage.Korea).
                dragAndDrop(dhtmlPage.oslo,dhtmlPage.Norway).
                dragAndDrop(dhtmlPage.Stockholm,dhtmlPage.Sweden).
                dragAndDrop(dhtmlPage.Washington,dhtmlPage.abd).
                dragAndDrop(dhtmlPage.Rome,dhtmlPage.Italy).
                dragAndDrop(dhtmlPage.Madrid,dhtmlPage.Spain).
                dragAndDrop(dhtmlPage.Copenhagen,dhtmlPage.Denmark).perform();





}}
