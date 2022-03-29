package tests;

import Pages1.*;


import freemarker.log.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import java.io.IOException;


@Listeners(TestNGListener.class)
public class loginTest extends Base{
    private static Logger log = Logger.getLogger("loginTest");



    @Test(priority = 1)
    public void Total_work_flow() throws InterruptedException, IOException {
        WebDriver driver =initialize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        Thread.sleep(5000);
        Home_Page hg=new Home_Page(driver);
        Bank_Manager_Login bm=new Bank_Manager_Login(driver);
        add_customer ad=new add_customer(driver);
        open_account oa=new open_account(driver);
        customer_login cl=new customer_login(driver);
        screenshots sc=new screenshots(driver);
        transaction tr=new transaction(driver);
        withdraw_amount wa=new withdraw_amount(driver);
        hg.Bank_Manager();
        Thread.sleep(3000);
        bm.Click_Add_customer();
        Thread.sleep(1000);
        ad.get_details();
        ad.add_details();
        ad.alert();
        oa.select_customer();
        oa.select_currency();
        oa.alert();
        oa.click_home();
        hg.Customer();
        cl.select_customer();
        cl.login();
        cl.get_amount_fromexcel(0);
        tr.click_trancactions();
        tr.get_transactions(0);
        sc.takescreenshot("Total_work_flow_Before Deposit Transactions");
        tr.click_back();
        cl.select_deposit();
        cl.depoist();
        sc.takescreenshot("Total_work_flow_Deposit Successful");
        log.info("Total_work_flow_amount added successfully");
        tr.click_trancactions();
        tr.get_transactions(1);
        sc.takescreenshot("Total_work_flow_After Deposit Transactions");
        tr.compare();
        tr.click_back();
        wa.select_withdrawl();
        wa.get_amount_fromexcel(0);
        wa.withdraw();
        sc.takescreenshot("Total_work_flow_Withdraw Successful");
        log.info("amount withdrawn successfully");
        driver.quit();
    }


    @Test(priority = 2)
    public void Transaction_Table_For_withdrawl() throws InterruptedException, IOException {
        WebDriver driver =initialize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        Thread.sleep(5000);
        Home_Page hg=new Home_Page(driver);
        customer_login cl=new customer_login(driver);
        transaction tr=new transaction(driver);
        withdraw_amount wa=new withdraw_amount(driver);
        screenshots sc=new screenshots(driver);
        hg.Customer();
        cl.select_customer();
        cl.login();
        cl.select_deposit();
        cl.get_amount_fromexcel(0);
        cl.depoist();
        tr.click_trancactions();
        tr.get_transactions(0);
        sc.takescreenshot("Transaction_Table_For_withdrawl Before Withdrawl Transactions");
        tr.click_back();
        wa.select_withdrawl();
        wa.get_amount_fromexcel(0);
        wa.withdraw();
        tr.click_trancactions();
        tr.get_transactions(1);
        sc.takescreenshot("Transaction_Table_For_withdrawl After Withdrawl Transactions");
        tr.compare();
        driver.quit();
        log.info("In transaction test case Transaction table updated successfully");
    }

    @Test(priority = 3)
    public void Invalid_withdraw_and_deposit() throws InterruptedException, IOException {
        WebDriver driver =initialize();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        Thread.sleep(5000);
        Home_Page hg=new Home_Page(driver);
        customer_login cl=new customer_login(driver);
        withdraw_amount wa=new withdraw_amount(driver);
        screenshots sc=new screenshots(driver);
        hg.Customer();
        cl.select_customer();
        cl.login();
        cl.select_deposit();
        cl.get_amount_fromexcel(1);
        cl.depoist();
        sc.takescreenshot(" Invalid_withdraw_and_deposit_Deposit");
        log.info("In Invalid_withdraw_and_deposit test case amount should be greater than zero");
        wa.select_withdrawl();
        wa.get_amount_fromexcel(1);
        wa.withdraw();
        sc.takescreenshot(" Invalid_withdraw_and_deposit_Withdraw");
        log.info("In Invalid_withdraw_and_deposit test case amount should be greater than zero");
        driver.quit();
    }

    @Test(priority = 4)
    public void Withdraw_Lessamount() throws InterruptedException, IOException {
        WebDriver driver =initialize();
        screenshots sc=new screenshots(driver);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        Thread.sleep(5000);
        Home_Page hg=new Home_Page(driver);
        customer_login cl=new customer_login(driver);
        withdraw_amount wa=new withdraw_amount(driver);
        hg.Customer();
        cl.select_customer();
        cl.login();
        cl.select_deposit();
        cl.get_amount_fromexcel(2);
        cl.depoist();
        log.info("In Withdraw_Lessamount test case amount is added");
        wa.select_withdrawl();
        wa.get_amount_fromexcel(2);
        wa.withdraw();
        sc.takescreenshot("Withdraw Less amount");
        log.info("In Withdraw_Lessamount test case not able to withdraw amount");
        driver.quit();
    }
}
