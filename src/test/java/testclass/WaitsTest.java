package testclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitsTest extends BaseSeleniumTest {

    @Test
    public void waitsTest() {
        //jedna metoda to implicitlyWait, jak zaladuja sie wszystkie elementy to konczy test
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        driver.get(new File("src/main/resources/files/Waits.html").getAbsolutePath());
        driver.findElement(By.tagName("button")).click();

        //druga metoda to Thread.sleep()
        //Thread.sleep(5000); //jedna metoda

        //trzecia metoda
        waitForWebElement(By.tagName("p"));

        WebElement paragraph = driver.findElement(By.tagName("p"));
        System.out.println(paragraph.getText());
        Assert.assertTrue(paragraph.getText().equals("Dopiero się pojawiłem!"));
    }

    //trzecia metoda
    //TYPY GENERYCZNE JAVA POWTORZYC
    public void waitForWebElement(By locator) {
        //UZYCIE INTERFEJSU WAIT
        //Wait<WebDriver> wait = new WebDriverWait(driver, 10L);
        //((WebDriverWait) wait).pollingEvery(Duration.ofMillis(500L)); //co ile ma być odswiezana strona

        //UZYCIE KLASY FluentWait
        //FluentWait<WebDriver> wait = new FluentWait<>(driver);
        //wait.pollingEvery(Duration.ofMillis(500));
        //wait.withTimeout(Duration.ofSeconds(10L));
        //wait.ignoring(NoSuchElementException.class);

        //UZYCIE KLASY WebDrive
        //WebDriverWait wait = new WebDriverWait(driver, 10L);

        //niezmienna czesc kodu
        //wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        //wlasna implementacja expectedConditions
        WebDriverWait wait = new WebDriverWait(driver, 10L);
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                System.out.println("Sprawdzam czy element jest wyswietlony");
                if (driver.findElement(locator).isDisplayed()) {
                    System.out.println("Element jest widoczny");
                    return true;
                } else {
                    System.out.println("Element nie jest widoczny");
                    return false;
                }
            }
        });
    }
}
