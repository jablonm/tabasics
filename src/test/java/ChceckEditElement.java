import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class ChceckEditElement {

    @Test
    public void checkIfEdit() {
        String driverPath = new File("src/main/resources/executables/drivers/chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(new File("src/main/resources/files/Test.html").getAbsolutePath());

        WebElement firstNameInput = driver.findElement(By.name("fname"));
        firstNameInput.sendKeys("Test");
        //w przypadku gdy input posiada atrybut disabled test zakończy się błędem invalid element state

        if (firstNameInput.isEnabled()) {
            System.out.println("Element nie jest zablokowany");
        } else {
            System.out.println("Element jest zablokowany");
        }
    }

}
