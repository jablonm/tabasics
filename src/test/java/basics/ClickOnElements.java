package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ClickOnElements {

    @Test
    public void clickOnMe() {
        String driverPath = new File("src/main/resources/executables/drivers/chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(new File("src/main/resources/files/Test.html").getAbsolutePath());

        WebElement clickOnMe = driver.findElement(By.id("clickOnMe"));
        WebElement firstNameInput = driver.findElement(By.id("fname"));

        clickOnMe.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        firstNameInput.sendKeys("Test");
        firstNameInput.clear();
        firstNameInput.sendKeys("Test2");
    }
}
