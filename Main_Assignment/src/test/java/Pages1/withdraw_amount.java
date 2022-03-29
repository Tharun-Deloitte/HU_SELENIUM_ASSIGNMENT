package Pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
public class withdraw_amount {
    WebDriver driver;
    By click_withdrawl=By.xpath("//*[@ng-click='withdrawl()']");
    By click_amount=By.xpath("//*[@ng-model='amount']");
    By balance=By.xpath("//div[@class='center']/strong[2]");
    By withdraw=By.xpath("//button[@class='btn btn-default']");
    int amount;
    excel_data xls1;
    public withdraw_amount(WebDriver driver){
        this.driver=driver;
    }


    public void get_amount_fromexcel(int row){
        try {
            xls1 = new excel_data("C:\\Users\\naratreddy\\IdeaProjects\\maindata.xlsx");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        amount=xls1.getData1(2,row,0);
    }
    public void select_withdrawl(){
        driver.findElement(click_withdrawl).click();
    }

    public void withdraw() throws InterruptedException{
        Thread.sleep(2000);
        WebElement e3 = driver.findElement(click_amount);
        e3.sendKeys(Integer.toString(amount));
        Thread.sleep(3000);
        WebElement e2= driver.findElement(balance);
        String s1=e2.getText();
        driver.findElement(withdraw).click();
        int initialbalance;
        initialbalance=Integer.parseInt(s1);
        if(amount<=0)
        {
            WebDriverWait wt = new WebDriverWait(driver, 2);
            wt.until(ExpectedConditions.elementToBeClickable(withdraw));
            System.out.println("amount should be greater than 0");
        }
        else if(amount>initialbalance){
            WebDriverWait wt = new WebDriverWait(driver, 2);
            wt.until(ExpectedConditions.elementToBeClickable(withdraw));
            System.out.println("Amount should not be greater than balance");
        }
        else {
            int balance_amount,finalbalance;
            WebElement e4= driver.findElement(balance);
            String s2=e4.getText();
            balance_amount=Integer.parseInt(s2);
            WebElement e5= driver.findElement(balance);
            String s3=e5.getText();
            finalbalance=Integer.parseInt(s3);
            if(finalbalance==(balance_amount-amount))
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
