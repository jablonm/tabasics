import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SprawdzEdytowalnyElement {

    @Test
    public void checkIfEdit() {
        String driverPath = "C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\files\\Test.html");

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
