package testclass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoogleFindByTest extends BaseSeleniumTest {

    @FindBy(name = "q")
    private WebElement searchInput;
    @FindBy(id = "introAgreeButton")
    private WebElement agree;

    @Test
    public void googleFindBy() throws InterruptedException {
        PageFactory.initElements(driver, this); //inicjalizacja page elementow

        driver.get("https://www.google.com");
        //obsluga ramki ze zgoda na cookie google
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(driver -> driver.switchTo().frame(0));
        //WebElement agree = driver.findElement(By.id("introAgreeButton"));
        agree.click();

        searchInput.sendKeys("seleniumhq");
        searchInput.sendKeys(Keys.ENTER);  //klikamy przy uzyciu javascript
    }

}
