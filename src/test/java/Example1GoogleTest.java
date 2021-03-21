import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Example1GoogleTest {

    @Test
    public void googleTest() {
        String driverPath = "C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverPath);

        //zgoda na cookie google
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.cookies", 2);
        prefs.put("network.cookie.cookieBehavior", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        //koniec cookie

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("test");
        //WebElement seachButton = driver.findElement(By.name("btnK"));
        searchInput.sendKeys(Keys.ENTER);

        WebElement firstLink = driver.findElement(By.cssSelector("div.tF2Cxc:nth-child(2) > div:nth-child(1) > a:nth-child(1)"));
        firstLink.click();
    }

}
