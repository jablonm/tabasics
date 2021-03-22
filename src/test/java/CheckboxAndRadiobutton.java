import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class CheckboxAndRadiobutton {

    @Test
    public void checkboxAndOthers() {
        String driverPath = new File("src/main/resources/executables/drivers/chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(new File("src/main/resources/files/Test.html").getAbsolutePath());

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
