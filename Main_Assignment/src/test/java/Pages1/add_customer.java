package Pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
public class add_customer {
    WebDriver driver;
    By first_name=By.xpath("//*[@placeholder='First Name']");
    By last_name=By.xpath("//*[@placeholder='Last Name']");
    By pincode=By.xpath("//*[@placeholder='Post Code']");
    By click_Add_customer=By.xpath("//*[@type='submit']");
    public add_customer(WebDriver driver){
        this.driver=driver;
    }
    String firstname="";
    String lastname="";
    int zip=0;
    excel_data xls1;
    public void get_details(){
        try {
            xls1 = new excel_data("C:\\Users\\naratreddy\\IdeaProjects\\maindata.xlsx");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        firstname=xls1.getData(0,0,0);
        lastname=xls1.getData(0,0,1);
        zip= xls1.getData1(0,0,2);
    }
    public void add_details() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(first_name).sendKeys(firstname);
        driver.findElement(last_name).sendKeys(lastname);
        driver.findElement(pincode).sendKeys(Integer.toString(zip));
        Thread.sleep(2000);
        driver.findElement(click_Add_customer).click();
        Thread.sleep(2000);
    }
    public void alert() throws InterruptedException, IOException {

        Thread.sleep(3000);
        driver.switchTo().alert().accept();

    }
}
