package com.travelers.tests;

import com.travelers.helper.DriverFactory;
import com.travelers.helper.DriverType;
import com.travelers.helper.NoSuchDriverException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseSeleniumTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() throws IOException, NoSuchDriverException {
        driver = DriverFactory.getDriver(DriverType.FIREFOX);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
