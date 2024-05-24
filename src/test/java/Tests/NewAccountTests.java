package Tests;

import com.Bank.Pages.HomePage;
import com.Bank.Pages.LoginPage;
import com.Bank.Pages.NewAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewAccountTests extends TestBase{
    HomePage home;
    LoginPage login;
    NewAccountPage newAccount;

    String userId = "mngr572310";
    String password = "172003";
    String customerId = "621" ;
    String initialDeposit = "1500";
    String invalidId = "000";

    @BeforeTest
    public void login()
    {
        login =new LoginPage(driver);
        login.loginForm(userId,password);
    }
    @Test(priority = 1)
    public void OpenNewAccountPage()
    {
        home=new HomePage(driver);
        home.OpenEditCustomerPage();
        driver.get("https://www.demo.guru99.com/V4/manager/addAccount.php");
    }
    @Test(priority = 2)
    public void AddNewAccount()
    {
        newAccount = new NewAccountPage(driver);
        newAccount.addNewAccount(customerId,initialDeposit);
        Assert.assertTrue(newAccount.message.getText().contains("Account Generated Successfully!!!"));
        String accountID = newAccount.accountId.getText();
        System.out.println(accountID); // 135084  // 135083
    }
}
