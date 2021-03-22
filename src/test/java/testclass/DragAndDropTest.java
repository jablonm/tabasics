package testclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseSeleniumTest {

    @Test
    public void dragAndDropTest() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement acceptAndClose = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptAndClose.click();
        Thread.sleep(2000);

        WebElement elementToDrag = driver.findElement(By.id("draggable"));
        WebElement dropZone = driver.findElement(By.id("droptarget"));

        Actions action = new Actions(driver);
        action.dragAndDrop(elementToDrag,dropZone).build().perform();
        //zakomentuj metode quit z BaseSeleniumTest
    }

}
