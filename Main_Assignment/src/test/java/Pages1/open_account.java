package Pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
public class open_account{
    WebDriver driver;
    By open_account=By.xpath("//*[@ng-click='openAccount()']");
    By customer_name=By.xpath("//*[@id='userSelect']");
    By currency=By.xpath("//*[@id='currency']");
    By click_submit=By.xpath("//*[@type='submit']");
    By home=By.xpath("//*[@class='btn home']");
    public open_account(WebDriver driver){
        this.driver=driver;
    }
    public void select_customer() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(open_account).click();
        Thread.sleep(3000);
        Select se = new Select(driver.findElement(customer_name));
        List<WebElement> l = se.getOptions();
        int n= l.size()-1;
        se.selectByIndex(n);
        Thread.sleep(3000);
    }
    public void click_home(){
        driver.findElement(home).click();
    }
    public void select_currency() throws InterruptedException {
        WebElement e2 = driver.findElement(currency);
        Select select = new Select(e2);
        select.selectByIndex(3);    //selecting rupees
        Thread.sleep(3000);
        driver.findElement(click_submit).click();
        Thread.sleep(3000);
    }
    public void alert() throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }
}
