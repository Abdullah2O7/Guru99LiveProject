package Tests;


import com.Bank.Pages.EditAccountPage;
import com.Bank.Pages.HomePage;
import com.Bank.Pages.LoginPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditAccountTest extends TestBase{

    HomePage home;
    LoginPage login;
    EditAccountPage editAccount;

    String userId = "mngr572310";
    String password = "172003";
    String accountNumber = "135084";
    String invalidAccountNumber = "00000";

    @BeforeTest
    public void login()
    {
        login =new LoginPage(driver);
        login.loginForm(userId,password);
    }
    @Test(priority = 1)
    public void openEditAccountPage()
    {
        home=new HomePage(driver);
        home.openEditAccountPage();
        driver.get("https://www.demo.guru99.com/V4/manager/editAccount.php");
    }
    @Test(priority = 2)
    public void EditAccountWithInvalidAcc_num()
    {
        editAccount = new EditAccountPage(driver);
        editAccount.editAccountForm(invalidAccountNumber);
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals("Account does not exist",alertMessage);
        alert.accept();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test(priority = 3)
    public void EditAccount()
    {
        editAccount.editAccountForm(accountNumber);
    }

}
