package Tests;


import com.Bank.Pages.LoginPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Report;

// Login test cases
public class LoginTests extends TestBase{
    LoginPage loginObject;
    String userId = "mngr572310";
    String password = "EhYpyrE";
    String invalidPassword = "invalid";

    @Test(priority = 1)
    public void loginWithInvalidCredentials()
    {

        loginObject =new LoginPage(driver);
        loginObject.loginForm(userId,invalidPassword);
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals("User or Password is not valid", alertMessage);
        alert.accept();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test(priority = 2)
    public void validLogin()
    {
      loginObject =new LoginPage(driver);
      loginObject.loginForm(userId,password);
      Assert.assertTrue(loginObject.successfulLoginMessage.getText().contains("mngr572310"));
    }
}
