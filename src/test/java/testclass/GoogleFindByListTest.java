package testclass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleFindByListTest extends BaseSeleniumTest {

    @FindBy(name = "q")
    private List<WebElement> elementst;
    @FindBy(id = "introAgreeButton")
    private WebElement agree;

    @Test
    public void googleFindByList() throws InterruptedException {
        PageFactory.initElements(driver, this); //inicjalizacja page elementow

        driver.get("https://www.google.com");
        //obsluga ramki ze zgoda na cookie google
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(driver -> driver.switchTo().frame(0));
        //WebElement agree = driver.findElement(By.id("introAgreeButton"));
        agree.click();

        elementst.get(0).sendKeys("seleniumhq");
        elementst.get(0).sendKeys(Keys.ENTER);  //klikamy przy uzyciu javascript
    }

}
