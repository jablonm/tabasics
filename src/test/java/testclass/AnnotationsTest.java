package testclass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class AnnotationsTest extends BaseSeleniumTest {

    @FindBys({
            @FindBy(tagName = "table"), //kolejnosc elementow ma znaczenie, wyszukiwanie po drzewie
            @FindBy(className = "tableHeader")
    })
    private List<WebElement> elements;

    @FindBy(xpath = "//input")
    private List<WebElement> inputs;

    @FindBy(xpath = "//button")
    private List<WebElement> buttons;

    @FindAll({
            @FindBy(xpath = "//input"),
            @FindBy(xpath = "//button")
    })
    private List<WebElement> inputsAndButtons;

    @Test
    public void googleFindByList() throws InterruptedException {
        PageFactory.initElements(driver, this); //inicjalizacja page elementow
        driver.get(new File("src/main/resources/files/Test.html").getAbsolutePath());
        System.out.println("Liczba elementów w liście to: " + elements.size());
        System.out.println("Liczba inputów na stronie to:" + inputs.size());
        System.out.println("Liczba buttonów na stronie to:" + buttons.size());
        System.out.println("Liczba inputów i buttonów to:" + inputsAndButtons.size());
    }

}
