package com.travelers.helper;

import com.travelers.exceptions.NoSuchDriverException;
import com.travelers.utils.DriverFactory;
import com.travelers.utils.DriverType;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

public class TestListener extends TestListenerAdapter {

    Logger logger = Logger.getLogger(TestListener.class);

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            logger.debug("On test failure");
            SeleniumHelper.takeScreenshot(DriverFactory.getDriver(DriverType.CHROME));
        } catch (IOException | NoSuchDriverException e) {
            e.printStackTrace();
        }
    }

}
