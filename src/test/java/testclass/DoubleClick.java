package testclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class DoubleClick extends BaseSeleniumTest {

    @Test
    public void doubleClick() {
        SeleniumHelper helper = new SeleniumHelper(driver);
        driver.get(new File("src/main/resources/files/DoubleClick.html").getAbsolutePath());
        WebElement button = driver.findElement(By.id("bottom"));
        Actions action = new Actions(driver);
        action.moveToElement(button).doubleClick().build().perform();

        //screenshot z klasy SeleniumHelper
        helper.takeScreenshot();

        Assert.assertTrue(driver.getWindowHandles().size() > 1);
    }

}
