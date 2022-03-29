package Pages1;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Bank_Manager_Login{
    WebDriver driver;
    By Add_customer=By.xpath("//button[@ng-class='btnClass1']");
    By open_Account=By.xpath("//button[@ng-class='btnClass2']");
    public Bank_Manager_Login(WebDriver driver){
        this.driver=driver;
    }
    public void Click_Add_customer(){
        driver.findElement(Add_customer).click();
    }
    public void Click_Open_Account(){
        driver.findElement(open_Account).click();
    }
}
