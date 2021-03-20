import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class ListElements {

    @Test
    public void googleOpenTest() {
        String driverPath = "C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\files\\Test.html");
        List<WebElement> links = driver.findElements(By.tagName("input"));

        for (int i = 0; i < links.size(); i++) {
            System.out.println("Element " + i + " to " + links.get(i));
        }
    }
}
