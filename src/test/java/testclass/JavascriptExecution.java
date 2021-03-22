package testclass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class JavascriptExecution extends BaseSeleniumTest{

    @Test
    public void googleSearchTest() {
        driver.get("https://www.google.com");
        WebElement searchInput = driver.findElement(By.name("q"));

        //wywolanie javascript
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        Actions action = new Actions(driver); //symulacja wywołania kliknięcia prawym przyciskiem myszy
        action.contextClick().build().perform();
        executor.executeScript("arguments[0].setAttribute('value', 'seleniumhq')", searchInput);
        searchInput.sendKeys(Keys.ENTER);

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
            executor.executeScript("arguments[0].click();", seleniumLink); //klikanie z javy
            String expectedTitle = "SeleniumHQ Browser Automation";
            Assert.assertEquals(driver.getTitle(), expectedTitle);
        }
    }

}
