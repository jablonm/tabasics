package com.travelers.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchSpan;

    //@FindBy(xpath = "//input[class='select2-input'") //jest za duzo elementow tego typu na stronie
    @FindBy(xpath = "//*[@id='select2-drop']//input")
    private WebElement searchCityInput;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sendKeysToCityInput(String cityname) {
        searchSpan.click();
        searchCityInput.sendKeys(cityname);
    }

}
