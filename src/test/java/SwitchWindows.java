import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Set;

public class SwitchWindows {

    @Test
    public void switchDriver() {
        String driverPath = new File("src/main/resources/executables/drivers/chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(new File("src/main/resources/files/Test.html").getAbsolutePath());

        WebElement newPageButton = driver.findElement(By.id("newPage"));
        String currentWindowName = driver.getWindowHandle();
        newPageButton.click();
        switchToNewWindow(driver, currentWindowName);
        System.out.println("Tytuł strony: " + driver.getTitle() + " URL: " + driver.getCurrentUrl());
        driver.switchTo().window(currentWindowName); //powrót do pierwotnego okna

    }

    private void switchToNewWindow(WebDriver driver, String currentWindowName) {
        System.out.println("Wartość obecnego okna " + currentWindowName);
        Set<String> windows = driver.getWindowHandles();
        System.out.println("Ilość okien " + windows.size());

        for (String window : windows) {
            if (!window.equals(currentWindowName)) {
                driver.switchTo().window(window);
            }
        }
    }

}
