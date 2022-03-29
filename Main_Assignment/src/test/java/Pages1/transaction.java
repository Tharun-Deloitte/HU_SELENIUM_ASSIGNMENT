package Pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class transaction  {
    WebDriver driver;
    By transactions=By.xpath("//*[@ng-click='transactions()']");
    By back=By.xpath("//button[@ng-click='back()']");
    int initial;
    int after;
    public transaction(WebDriver driver){
        this.driver=driver;
    }
    public void click_trancactions(){
        driver.findElement(transactions).click();
    }
    public void get_transactions(int i) throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> li =driver.findElements(By.tagName("tr"));
        if(i==0)
            initial=li.size();
        else
            after=li.size();
        li.clear();
    }

    public void click_back(){
        driver.findElement(back).click();
    }
    public void compare(){
        if(after==initial+1){
            System.out.println("Updated successfully");
        }
        else{
            System.out.println("Not Updated");
        }
    }
}

