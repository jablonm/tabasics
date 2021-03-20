import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    @Test
    public void googleOpenTest() {
        String driverPath = "C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);

        Dimension dimension = new Dimension(1600,800);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(dimension);
        //driver.manage().window().maximize();

        driver.get("C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\files\\Test.html");
        driver.findElement(By.id("newPage")).click();
        driver.close(); // metoda close zamyka pierwotne okno z focusem
        //driver.quit(); //metoda quit zamyka wszystkie okna
    }

}
