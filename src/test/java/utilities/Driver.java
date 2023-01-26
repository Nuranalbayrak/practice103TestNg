package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
   static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver==null){//Eger driver'a deger atanmamissa deger ata,Eger atanmissa driver'i ayni sayfada return et.
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
            }
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){//Driver' a deger atanmissa
            driver.close();
            driver=null;
        }

    }
    public static void quitDriver() {
        if (driver != null) {//Driver' a deger atanmissa
            driver.quit();
            driver = null;
        }
    }
}
