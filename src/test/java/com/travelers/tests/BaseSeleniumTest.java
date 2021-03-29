package com.travelers.tests;

import com.travelers.utils.DriverFactory;
import com.travelers.utils.DriverType;
import com.travelers.exceptions.NoSuchDriverException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public abstract class BaseSeleniumTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException, NoSuchDriverException {
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        DriverFactory.resetDriver();
    }

}
