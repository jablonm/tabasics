package com.travelers.tests;

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
                                String fPrice, String sHotel, String sPrice, String tHotel, String tPrice) {
        //driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS); //niepotrzebne po zastapieniu Thread.sleepow
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);

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
        ResultPage resultPage = homePage
                .setCityHotel(city)
                .setDateRange(checkInDate, checkOutDate)
                .openTravelersModel()
                .addAdult()
                .addChild()
                .addChild()
                .performSearch();

        List<String> hotelNames = resultPage.getHotelNames();
        /*Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");*/

        Assert.assertEquals(hotelNames.get(0), fHotel);
        Assert.assertEquals(hotelNames.get(1), sHotel);
        Assert.assertEquals(hotelNames.get(2), tHotel);

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
            data = ExcelHelper.readExcelFile(new File("src//main//resources//files//Dane.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
