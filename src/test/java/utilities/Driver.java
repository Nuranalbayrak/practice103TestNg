package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
   /*
   Driverdaki temel mantik extent yontemiyle degil yani TestBase class'ina extent etmek yerine Driver class'indan static
   methodlar kullanarak driver olustururuz.
   Ilk olarak public static WebDriver getDriver() methodu olusturmak. Bu method bize bir driver getirecek
    Ikinci olarak driver'i kapatacagimiz zaman public static void closeDriver() method olusturmak. Istedigimiz zaman
    bu methodla driver'i kapatacagiz.
    */
   //    Driver.getDriver(); -> driver
   private static WebDriver driver;
    //    Driver.getDriver(); -> driver

    //    getDriver() is used to instantiate the driver object
    public static WebDriver getDriver(){
        if (driver==null){
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
            }
//            NOTE: sel 4.5
//            driver = WebDriverManager.chromedriver().create();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
    //    closeDriver() is used to close the driver
    public static void closeDriver(){
//        if driver is already being used(pointing an object)
//        then quit the driver
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
