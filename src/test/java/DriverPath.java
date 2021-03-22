import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class DriverPath {

    @Test
    public void googleOpenTest() {
        String driverPath = new File("src/main/resources/executables/drivers/chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver",driverPath);

        Dimension dimension = new Dimension(1600,800);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(dimension);
        //driver.manage().window().maximize();

        driver.get(new File("src/main/resources/files/Test.html").getAbsolutePath());
        driver.findElement(By.id("newPage")).click();
        driver.close(); // metoda close zamyka pierwotne okno z focusem
        //driver.quit(); //metoda quit zamyka wszystkie okna
    }

}
