package com.travelers.pages;

import com.travelers.helper.SeleniumHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

public class HomePage {

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchSpan;

    //@FindBy(xpath = "//input[class='select2-input'") //jest za duzo elementow tego typu na stronie
    @FindBy(xpath = "//*[@id='select2-drop']//input")
    private WebElement searchCityInput;

    @FindBy(name = "checkin")
    private WebElement checkInInput;

    @FindBy(name = "checkout")
    private WebElement checkOutInput;

    @FindBy(id = "travellersInput")
    private WebElement travelersInput;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='select2-result-label']")
    private WebElement selectResultLable;

    final WebDriver driver;

    final SeleniumHelper helper;

    private Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
    }

    public HomePage setCityHotel(String cityname) {
        logger.info("Input city name " + cityname);
        searchSpan.click();
        searchCityInput.sendKeys(cityname);

        //PAIRWSZA METODA WAIT
        //By locationLabel = By.xpath("//div[@class='select2-result-label']");
        //helper.waitForElementToBeDisplayed(locationLabel);

        //DRUGA METODA WAIT
        //WebElement element = driver.findElement(By.xpath("//div[@class='select2-result-label']")); //trzeba uzyc @FindBy
        helper.waitForElementToBeDisplayed(selectResultLable);

        searchCityInput.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage setDateRange(String checkInDate, String checkOutDate) {
        checkInInput.sendKeys(checkInDate);
        checkOutInput.sendKeys(checkOutDate);
        checkOutInput.click();
        return this;
    }

    public HomePage openTravelersModel() {
        travelersInput.click();
        helper.waitForElementToBeDisplayed(adultPlusBtn);
        return this;
    }

    public HomePage addAdult() {
        adultPlusBtn.click();
        return this;
    }

    public HomePage addChild() {
        childPlusBtn.click();
        return this;
    }

    public ResultPage performSearch() {
        searchButton.click();
        return new ResultPage(driver);
    }

}
