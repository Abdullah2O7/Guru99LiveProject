package Tests;

import com.Bank.Pages.ChangePassword;
import com.Bank.Pages.EditAccountPage;
import com.Bank.Pages.HomePage;
import com.Bank.Pages.LoginPage;
import org.testng.annotations.Test;

public class ChangePasswordTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    ChangePassword changePassword;

    String userId = "mngr572310";
    String oldPassword = "EhYpyrE";
    String newPassword = "172003";

    @Test(priority = 1)
    public void login()
    {
        loginPage = new LoginPage(driver);
        loginPage.loginForm(userId,oldPassword);


    }
    @Test(priority = 2)
    public void OpenChangePasswordPage()
    {
        homePage = new HomePage(driver);
        homePage.OpenChangePasswordPage();
        driver.get("https://www.demo.guru99.com/V4/manager/PasswordInput.php");
    }
    @Test(priority = 3)
    public void changePassword()
    {
        changePassword = new ChangePassword(driver);
        changePassword.changePasswordForm(oldPassword,newPassword);
    }
}
