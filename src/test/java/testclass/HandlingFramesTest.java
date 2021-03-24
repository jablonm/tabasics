package testclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class HandlingFramesTest extends BaseSeleniumTest {

    @Test
    public void handlingFramesTest() {
        driver.get(new File("src/main/resources/files/iFrameTest.html").getAbsolutePath());
        driver.switchTo().frame(0); //przepiecie miedzy ramkami
        WebElement clickOnMeButton = driver.findElement(By.id("clickOnMe"));
        clickOnMeButton.click();
        driver.switchTo().alert().accept(); //zamkniecie wyskakujacego okna po kliknieciu na button
        driver.switchTo().defaultContent(); //powrot do glownej strony
        List<WebElement> headers = driver.findElements(By.tagName("h1"));
        System.out.println(headers.size());
        headers.forEach(we -> System.out.println(we.getText()));
    }

}
