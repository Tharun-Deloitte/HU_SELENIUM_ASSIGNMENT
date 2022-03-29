package Pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home_Page {
    WebDriver driver;
    By Bank_Manager_login=By.xpath("//button[@ng-click='manager()']");
    By Customer=By.xpath("//button[@ng-click='customer()']");
    public Home_Page(WebDriver driver){
        this.driver=driver;
    }

    public void Bank_Manager(){
        driver.findElement(Bank_Manager_login).click();
    }

    public void Customer(){
       driver.findElement(Customer).click();
    }
}
