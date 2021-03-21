import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Asercje {

    @Test
    public void assertionTest() {
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
        searchInput.sendKeys("Seleniumhq");
        searchInput.sendKeys(Keys.ENTER);

        //iterowanie po obiektach jakiegos typu na stronie
        List<WebElement> refList = driver.findElements(By.tagName("a"));
        WebElement seleniumLink = null;
        Boolean linkExist = false;

        for (WebElement we : refList) {
            if (we.getAttribute("href") != null && we.getAttribute("href").equals("https://www.selenium.dev/")) {
                //System.out.println(we.getAttribute("href"));
                seleniumLink = we;
                linkExist = true;
            }
        }
        if (linkExist) {
            seleniumLink.click();
            String expectedTitle = "SeleniumHQ Browser Automation";
            Assert.assertEquals(driver.getTitle(), expectedTitle);
            Assert.assertTrue(driver.getTitle().equals(expectedTitle), "Tytuły nie są równe");
            //Assert.assertTrue(driver.getTitle().equals("Test"), "Tytuły nie są równe");
        }

        driver.quit();
    }
}
