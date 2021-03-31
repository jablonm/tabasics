package com.travelers.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.travelers.helper.SeleniumHelper;
import com.travelers.utils.DriverFactory;
import com.travelers.utils.DriverType;
import com.travelers.exceptions.NoSuchDriverException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.LocalTime;

public abstract class BaseSeleniumTest {

    protected WebDriver driver;
    protected ExtentSparkReporter reporter;
    protected ExtentReports reports;

    @BeforeTest
    public void setUpReporter() {
        reporter = new ExtentSparkReporter("src//test//resources//reports//report" + LocalTime.now().getNano() + ".html");
        reports = new ExtentReports();
        reports.attachReporter(reporter);
    }

    @BeforeMethod
    public void setUp() throws NoSuchDriverException {
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        DriverFactory.resetDriver();
    }

    @AfterTest
    public void tearDownReporter() {
        reports.flush();
    }

    protected Media getScreenshot() throws IOException {
        return MediaEntityBuilder.createScreenCaptureFromPath(SeleniumHelper.takeScreenshot(driver)).build();

    }

}
