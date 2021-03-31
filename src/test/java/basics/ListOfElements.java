package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ListOfElements {

    @Test
    public void listElements() {
        String driverPath = new File("src/main/resources/executables/drivers/chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(new File("src/main/resources/files/Test.html").getAbsolutePath());
        List<WebElement> links = driver.findElements(By.tagName("input"));

        for (int i = 0; i < links.size(); i++) {
            System.out.println("Element " + i + " to " + links.get(i));
        }
    }
}
