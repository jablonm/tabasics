import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class CheckIfLoaded {

    @Test
    public void checkLoading() throws InterruptedException {
        String driverPath = new File("src/main/resources/executables/drivers/chromedriver.exe").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(new File("src/main/resources/files/Test.html").getAbsolutePath());

        //w przypadku obrazka sprawdzamy jego wysokosc
        WebElement image = driver.findElement(By.id("smileImage"));
        if (image.getSize().height > 0) {
            System.out.println("Wysokość obrazka to " + image.getSize().getHeight());
            System.out.println("Wysokość obrazka to " + image.getSize().height);
            System.out.println(("Naturalna wysokość to " + image.getAttribute("naturalHeight")));
        } else {
            System.out.println("Obrazek nie załadował się");
        }

        //w przypadku elementu ukrytego
        WebElement topSecretElement = driver.findElement(By.className("topSecret"));
        if (topSecretElement.isDisplayed()) {
            System.out.println("Element jest widoczny na stronie");
            System.out.println(topSecretElement.getText()); //gdy jest widoczny mozna wyswietlic jego text
        } else {
            System.out.println("Element jest ukryty");
            System.out.println(topSecretElement.getAttribute("textContent")); //gdy jest ukryty pobiera sie atrybut
        }

        //sprawdzenie stanu elementu, czy istnieje na stronie, w tym celu tworzymy metode checkIfExist
        checkIfExist(By.tagName("a"), driver);
        checkIfExist(By.tagName("test"), driver);
        checkIfExist(driver, By.tagName("a"));
        checkIfExist(driver, By.tagName("test"));
        driver.quit();
    }

    public boolean checkIfExist(By locator, WebDriver driver) {
        if(driver.findElements(locator).size()>0) {
            System.out.println("Szukany element istnieje");
            return true;
        } else {
            System.out.println("Szukany element nie istnieje");
            return false;
        }
    }

    public void checkIfExist(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            System.out.println("Element istnieje");
        } catch (NoSuchElementException exc) {
            System.out.println("Element nie istnieje, wyjątek " + exc.getClass());
        }
    }
}
