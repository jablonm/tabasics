package testclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseSeleniumTest {

    @Test
    public void uploadFileTest() {
        driver.get(new File("src/main/resources/files/FileUpload.html").getAbsolutePath());
        String path = new File("src/main/resources/files/smile.png").getAbsolutePath();
        driver.findElement(By.id("myFile")).sendKeys(path);



    }

}
