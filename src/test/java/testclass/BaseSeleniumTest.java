package testclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseSeleniumTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        String driverPath = new File("src/main/resources/executables/drivers/chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", driverPath);

        //zgoda na cookie google
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.cookies", 1);
        prefs.put("network.cookie.cookieBehavior", 0);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        //koniec cookie

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }


    @AfterTest
    public void tearDown() {
        //driver.quit();
    }

}
