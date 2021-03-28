package com.travelers.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static WebDriver driverInstance;

    public static WebDriver getDriver(DriverType driverType) throws NoSuchDriverException {
        if (driverInstance == null) {
            getSpecificDriver(driverType);
        }
        return driverInstance;
    }

    private static void getSpecificDriver(DriverType driverType) throws NoSuchDriverException {

        switch (driverType) {
            case IE:
                File ieDriverPath = new File("src//main//resources//executables//drivers//iedriverserver.exe");
                InternetExplorerDriverService ieDriverService = new InternetExplorerDriverService.Builder()
                        .usingDriverExecutable(ieDriverPath)
                        .usingAnyFreePort()
                        .build();

                driverInstance = new InternetExplorerDriver(ieDriverService);
                driverInstance.manage().window().maximize();
            break;
            case CHROME:
                File chromeDriverPath = new File("src//main//resources//executables//drivers//chromedriver.exe");
                ChromeDriverService chromeDriverService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(chromeDriverPath)
                        .usingAnyFreePort()
                        .build();

                //zgoda na cookie
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_setting_values.cookies", 1);
                prefs.put("network.cookie.cookieBehavior", 0);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                //koniec cookie

                driverInstance = new ChromeDriver(chromeDriverService, options);
                driverInstance.manage().window().maximize();
            break;
            case FIREFOX:
                File firefoxDriverPath = new File("src//main//resources//executables//drivers//geckodriver.exe");
                GeckoDriverService firefoxDriverService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(firefoxDriverPath)
                        .usingAnyFreePort()
                        .build();

                driverInstance = new FirefoxDriver(firefoxDriverService);
                driverInstance.manage().window().maximize();
            break;
            default:
                System.out.println("Brak drivera danaeo typu");
                throw new NoSuchDriverException();        }

    }

}
