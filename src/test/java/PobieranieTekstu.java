import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PobieranieTekstu {

    @Test
    public void getText() {
        String driverPath = "C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\files\\Test.html");

        WebElement firstNameInput = driver.findElement(By.id("fname"));
        firstNameInput.sendKeys("Test");
        //System.out.println("Wartość elementu to: " + firstNameInput.getText()); //nie działa do pobierania wartości textboxa
        System.out.println("Wartość elementu to: " + firstNameInput.getAttribute("value"));

        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println("Wartość label to: " + label.getText());

        driver.quit();
    }

}
