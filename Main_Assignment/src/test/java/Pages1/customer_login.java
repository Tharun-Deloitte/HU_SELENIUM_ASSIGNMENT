package Pages1;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class customer_login {
    WebDriver driver;
    By login=By.xpath("//button[@class='btn btn-default']");
    By user=By.xpath("//*[@id='userSelect']");
    By deposit=By.xpath("//*[@ng-click='deposit()']");
    By money=By.xpath("//*[@ng-model='amount']");
    By balance_amount=By.xpath("//div[@class='center']/strong[2]");
    By click_deposit=By.xpath("//button[@class='btn btn-default']");
    public customer_login(WebDriver driver){
        this.driver=driver;
    }
    int amount;
    excel_data xls1;

    public void select_customer() throws InterruptedException {
        Thread.sleep(3000);
        Select se = new Select(driver.findElement(user));
        List<WebElement> l = se.getOptions();
        int n = l.size()-1;
        se.selectByIndex(n);
        Thread.sleep(3000);
    }
    public void login() throws InterruptedException {
        driver.findElement(login).click();
        Thread.sleep(3000);
    }
    public void get_amount_fromexcel(int row){
        try {
            xls1 = new excel_data("C:\\Users\\naratreddy\\IdeaProjects\\maindata.xlsx");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        amount=xls1.getData1(1,row,0);
    }

    public void select_deposit(){
        driver.findElement(deposit).click();
    }
    public void depoist() throws InterruptedException, IOException {
        Thread.sleep(2000);
        WebElement e3 = driver.findElement(money);
        e3.sendKeys(Integer.toString(amount));
        Thread.sleep(3000);
        if(amount<=0)
        {
            WebDriverWait wt = new WebDriverWait(driver, 5);
            wt.until(ExpectedConditions.elementToBeClickable(click_deposit));
            System.out.println("amount should be greater than 0");
        }
        else {
            int initialbalance,finalbalance;
            WebElement e2= driver.findElement(balance_amount);
            String s1=e2.getText();
            initialbalance=Integer.parseInt(s1);
            driver.findElement(click_deposit).click();
            WebElement e4= driver.findElement(balance_amount);
            String s2=e4.getText();
            finalbalance=Integer.parseInt(s2);
            if(finalbalance==amount+initialbalance)
            {
                System.out.println("Balance updated successfulluy");
            }
            else
            {
                System.out.println("Balance not updated successfully");
            }
            Thread.sleep(3000);
        }
    }
}