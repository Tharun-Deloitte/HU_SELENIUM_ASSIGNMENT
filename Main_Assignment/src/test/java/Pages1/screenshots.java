package Pages1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;


public class screenshots {
    WebDriver driver;
    public screenshots(WebDriver driver){
        this.driver=driver;
    }
    public void takescreenshot(String name) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SourceFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("C:\\Users\\naratreddy\\Documents\\Screenshots\\"+name+".jpg");
        FileUtils.copyFile(SourceFile, DestFile);
    }
}
