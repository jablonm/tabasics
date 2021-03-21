import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class KlikanieNaElementy {

    @Test
    public void clickOnMe() {
        String driverPath = "C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\files\\Test.html");

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
