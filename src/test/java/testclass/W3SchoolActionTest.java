package testclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class W3SchoolActionTest extends BaseSeleniumTest {

    @Test
    public void hoverTest() {
        driver.get("https://www.w3schools.com/");

        Actions action = new Actions(driver);
        //action.contextClick().build().perform();
        action.moveToElement(driver.findElement(By.id("navbtn_tutorials"))).build().perform();

    }

}
