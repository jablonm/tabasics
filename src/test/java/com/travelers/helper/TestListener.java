package com.travelers.helper;

import com.travelers.helper.DriverFactory;
import com.travelers.helper.SeleniumHelper;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            System.out.println("On test failure");
            SeleniumHelper.takeScreenshot(DriverFactory.getDriver(DriverType.FIREFOX));
        } catch (IOException | NoSuchDriverException e) {
            e.printStackTrace();
        }
    }

}
