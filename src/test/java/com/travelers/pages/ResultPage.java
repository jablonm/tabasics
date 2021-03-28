package com.travelers.pages;

import com.travelers.helper.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage {

    @FindBy(xpath = "//table[@class='bgwhite table table-striped']")
    private WebElement resultsTable;

    private SeleniumHelper helper;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
    }

    public List<String> getHotelNames() {
        List<String> hotelNamesList = new ArrayList<>();
        //ten wait i tak nie zadziala, bo przy ladowaniu tworza sie puste elementy listy, lepszy bedzie zwykly wait
        helper.waitForListOfWebElements(resultsTable.findElements(By.xpath(".//h4//b")));

        List<WebElement> hotelNames = resultsTable.findElements(By.xpath(".//h4//b"));

        for (WebElement hotelName : hotelNames) {
            //czekanie az dlugosc elementu bedzie wieksza od 0
            helper.waitForElementLength(hotelName);
            System.out.println(hotelName.getText());
            hotelNamesList.add(hotelName.getText());
        }
        return hotelNamesList;
    }

    public List<String> getHotelPrices() {
        List<WebElement> hotelPrices = resultsTable.findElements(By.xpath("//div[contains(@class,'price_tab')]//b"));
        //hotelPrices.stream().forEach(hotelPrice -> System.out.println(hotelPrice.getText()));
        List<String> hotelPricesList = hotelPrices.stream().map(element -> element.getText()).collect(Collectors.toList());
        return hotelPricesList;
    }

}
