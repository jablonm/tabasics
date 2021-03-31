package com.travelers.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SeleniumHelper {

    final WebDriver driver;

    public SeleniumHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeDisplayed(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void waitForElementToBeDisplayed(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitForElementLength(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(driver -> element.getText().length() > 0);
    }

    public void waitForListOfWebElements(List<WebElement> elementsList) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        //METODA Z LAMBDA
        wait.until(driver -> elementsList.size() > 0);

        //METODA Z DEKLARACJA FUNKCJI
        /*System.out.println(elementsList.size());
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                if (elementsList.size() > 0) {
                    return true;
                } else {
                    return false;
                }
            }
        });*/
    }

    public static String takeScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
        File screenshotFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "screenshot-" +
                LocalDate.now() + "_" +
                LocalTime.now().getHour() +
                LocalTime.now().getMinute() +
                LocalTime.now().getSecond() +
                LocalTime.now().getNano() + ".png";
        File destinationFile = new File("src/test/resources/reports/screenshots/" + fileName);
        Files.copy(screenshotFile.toPath(), destinationFile.toPath());
        return "reports/screenshots/" + fileName;
    }

}
