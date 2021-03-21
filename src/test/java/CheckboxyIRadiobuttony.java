import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckboxyIRadiobuttony {

    @Test
    public void checkboxAndOthers() {
        String driverPath = "C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\files\\Test.html");

        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (!checkBox.isSelected()) {
            checkBox.click();
            System.out.println("Zaznaczam checkbox");
        } else {
            System.out.println("Checkbox jest zaznaczony");
        }

        //radiobuttony
        WebElement radioButton = driver.findElement(By.xpath("//input[@value='male']"));
        radioButton.click();
    }

}
