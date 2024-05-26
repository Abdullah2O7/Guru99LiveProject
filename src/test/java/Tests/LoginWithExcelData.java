package Tests;

import com.Bank.Pages.LoginPage;
import com.Bank.ReadData.ExcelLibrary;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithExcelData extends TestBase{

    LoginPage login;
    @Test(priority = 1)
    public void loginWithInvalidCredentials() throws Exception
    {
        ExcelLibrary obj = new ExcelLibrary();
        String invalidUserId = obj.readData("Test", 0, 0);
        String invalidPassword = obj.readData("Test", 0, 1);

        login =new LoginPage(driver);
        login.loginForm(invalidUserId,invalidPassword);
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
    public void validLogin() throws Exception
    {
        ExcelLibrary obj = new ExcelLibrary();
        String validUserId = obj.readData("Test", 1, 0);
        String validPassword = obj.readData("Test", 1, 1);

        login =new LoginPage(driver);
        login.loginForm(validUserId,validPassword);
        Assert.assertTrue(login.successfulLoginMessage.getText().contains("mngr572310"));
    }
}
