import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LokalizowanieElementow {

    @Test
    public void elementLocalistation() {
        String driverPath = "C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("C:\\Users\\m.jablonski\\tabasics\\src\\main\\resources\\files\\Test.html");
        WebElement firstNameInput = driver.findElement(By.name("fname"));
        WebElement clickOnMeButton2 = ((ChromeDriver) driver).findElementById("clickOnMe");
        // metoda findElementById jest definiowana w odpowiednim driverze przeglądarki, dlatego należy użyć rzutownia
        WebElement clickOnMeButton = driver.findElement(By.id("clickOnMe"));
        //lokalizowanie po tekście linku
        WebElement w3SchoolLink = ((ChromeDriver) driver).findElementByLinkText("Visit W3Schools.com!");
        WebElement w3SchoolLink2 = driver.findElement(By.linkText("Visit W3Schools.com!"));
        WebElement googleLink = driver.findElement(By.partialLinkText("Weird"));
        //lokalizowanie po klasie
        WebElement topSecretParagraph = driver.findElement(By.className("topSecret"));
        //lokalizowanie po tagu html
        WebElement firstInput = driver.findElement(By.tagName("input"));
        //lokalizowanie po css
        WebElement clickOnMeCssButton = driver.findElement(By.cssSelector("#fname"));
        WebElement firstLink = driver.findElement(By.cssSelector("a"));
        WebElement topSecretCSS = driver.findElement(By.cssSelector(".topSecret"));
        WebElement tdFirstChild = driver.findElement(By.cssSelector("td:first-child"));
        //loklalizowanie po xpath
        WebElement clickOnMeXpathButton = driver.findElement(By.xpath("/html/body/button"));
        WebElement clickOnMeXpathButton2 = driver.findElement(By.xpath("//button"));
        WebElement linkXpath = driver.findElement(By.xpath("//a"));
        WebElement topSecretXpath = driver.findElement(By.xpath("//p[@class='topSecret']"));
        WebElement topSecretXpath2 = driver.findElement(By.xpath("//*[@class='topSecret']"));
        WebElement linkText = driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));
    }
}
