package com.travelers.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.*;

public class ReportTest {
    public static void main(String[] args) {

        ExtentSparkReporter reporter = new ExtentSparkReporter("index.html");
        ExtentReports reports = new ExtentReports();
        reports.attachReporter(reporter);

        ExtentTest test = reports.createTest("Pierwszy test");
        test.log(Status.INFO, "Info pierwszy krok");
        test.log(Status.PASS, "Pass drugi krok");
        test.log(Status.FAIL, "Debug fail krok");
        test.pass("Koniec testu");

        reports.flush();
    }
}
