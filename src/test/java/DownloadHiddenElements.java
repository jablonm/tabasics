import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class DownloadHiddenElements {

    @Test
    public void getHidden() throws InterruptedException {
        String driverPath = new File("src/main/resources/executables/drivers/chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(new File("src/main/resources/files/Test.html").getAbsolutePath());

        WebElement hiddenParagraph = driver.findElement(By.className("topSecret"));
        System.out.println("Ukryty tekst to " + hiddenParagraph.getText()); //ta metoda nie zadziała na ukrytym elemencie
        System.out.println("Ukryty tekst to " + hiddenParagraph.getAttribute("value")); //ta metoda też nie zadziała
        System.out.println("Ukryty tekst to " + hiddenParagraph.getAttribute("textContent"));
        driver.quit();
    }

}
