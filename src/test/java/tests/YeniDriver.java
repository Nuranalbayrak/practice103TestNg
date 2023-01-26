package tests;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class YeniDriver {
    @Test
    public void testName() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get("techproUrl");
        Driver.getDriver().get("https://www.facebook.com");
        Driver.closeDriver();
    }
}
