import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;

public class GetText {

    @Test
    public void getText() {
        String driverPath = new File("src/main/resources/executables/drivers/chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(new File("src/main/resources/files/Test.html").getAbsolutePath());

        WebElement firstNameInput = driver.findElement(By.id("fname"));
        firstNameInput.sendKeys("Test");
        //System.out.println("Wartość elementu to: " + firstNameInput.getText()); //nie działa do pobierania wartości textboxa
        System.out.println("Wartość elementu to: " + firstNameInput.getAttribute("value"));

        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println("Wartość label to: " + label.getText());

        driver.quit();
    }

}
