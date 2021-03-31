package com.travelers.tests;

import com.aventstack.extentreports.ExtentTest;
import com.travelers.helper.ExcelHelper;
import com.travelers.helper.TestListener;
import com.travelers.pages.HomePage;
import com.travelers.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Listeners(TestListener.class)
public class SearchHotelTest extends BaseSeleniumTest {

    @Test(dataProvider = "getData")
    public void searchHotelTest(String city, String checkInDate, String checkOutDate, String fHotel,
                                String fPrice, String sHotel, String sPrice, String tHotel, String tPrice) throws IOException {
        //driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS); //niepotrzebne po zastapieniu Thread.sleepow
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);

        //DEKLARACJA RAPORTOW
        ExtentTest test = reports.createTest("Search Hotel Test");
        test.info("On PHP Traveles Home Page", getScreenshot());

        //WARTOSCI PODAWNAE RECZNIE DO WYSZUKIWANIA
        /*ResultPage resultPage = homePage
                .setCityHotel("Dubai")
                .setDateRange("09/11/2018", "09/13/2019")
                .openTravelersModel()
                .addAdult()
                .addChild()
                .addChild()
                .performSearch();*/

        //WARTOSCI WCZYTANE Z EXCELA
        homePage.setCityHotel(city)
                .setDateRange(checkInDate, checkOutDate)
                .openTravelersModel()
                .addAdult()
                .addChild()
                .addChild()
                .performSearch();

        String infoText = "Performing search for city %s, checkin date %s, chout date %s";
        test.info(String.format(infoText, city, checkInDate, checkOutDate), getScreenshot());
        ResultPage resultPage = homePage.performSearch();

        test.info("Checking hotel names", getScreenshot());
        List<String> hotelNames = resultPage.getHotelNames();
        /*Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");*/

        Assert.assertEquals(hotelNames.get(0), fHotel);
        Assert.assertEquals(hotelNames.get(1), sHotel);
        Assert.assertEquals(hotelNames.get(2), tHotel);

       test.info("Checking hotel prices", getScreenshot());
        List<String> hotelPrices = resultPage.getHotelPrices();
        /*Assert.assertEquals(hotelPrices.get(0), "$22");
        Assert.assertEquals(hotelPrices.get(1), "$50");
        Assert.assertEquals(hotelPrices.get(2), "$80");
        Assert.assertEquals(hotelPrices.get(3), "$150");*/

        Assert.assertEquals(hotelPrices.get(0), fPrice);
        Assert.assertEquals(hotelPrices.get(1), sPrice);
        Assert.assertEquals(hotelPrices.get(2), tPrice);

    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = null;
        try {
            data = ExcelHelper.readExcelFile(new File("src//test//resources//files//Dane.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
