package testclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleSearchTest extends BaseSeleniumTest {

    @Test
    public void googleSearchTest() {
        driver.get("https://www.google.com");
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("seleniumhq");
        searchInput.sendKeys(Keys.ENTER);  //klikamy przy uzyciu javascript

        //iterowanie po obiektach jakiegos typu na stronie
        List<WebElement> refList = driver.findElements(By.tagName("a"));
        WebElement seleniumLink = null;
        boolean linkExist = false;

        for (WebElement we : refList) {
            if (we.getAttribute("href") != null && we.getAttribute("href").equals("https://www.selenium.dev/")) {
                seleniumLink = we;
                linkExist = true;
            }
        }
        if (linkExist) {
            seleniumLink.click();
            String expectedTitle = "SeleniumHQ Browser Automation";
            Assert.assertEquals(driver.getTitle(), expectedTitle);
        }
    }

}
