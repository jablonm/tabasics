package testclass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;

public class SeleniumHelper {

    private WebDriver driver;

    public SeleniumHelper(WebDriver newDriver) {
        this.driver = newDriver;
    }

    public void takeScreenshot() {
        try {
            TakesScreenshot screenshoter = (TakesScreenshot) driver;
            File screenshot = screenshoter.getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), Paths.get("src/main/resources/screenshots/screenshot" + LocalTime.now().getNano() + ".png"));
        } catch (IOException e) {
            System.out.println("Nie znaleziono pliku");
        }
    }

}
