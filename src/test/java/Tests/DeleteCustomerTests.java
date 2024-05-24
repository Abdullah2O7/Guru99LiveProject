package Tests;

import com.Bank.Pages.DeleteCustomerPage;
import com.Bank.Pages.HomePage;
import com.Bank.Pages.LoginPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteCustomerTests extends TestBase{
    HomePage home;
    LoginPage login;
    DeleteCustomerPage deleteCustomer;

    String userId = "mngr572310";
    String password = "172003";
    String invalidId = "000";
    String id = "";

    @BeforeTest
    public void login()
    {
        login =new LoginPage(driver);
        login.loginForm(userId,password);
    }
    @Test (priority = 1)
    public void OpenDeleteCustomerPage()
    {
        home=new HomePage(driver);
        home.OpenEditCustomerPage();
        driver.get("https://www.demo.guru99.com/V4/manager/DeleteCustomerInput.php");
    }
    @Test(priority = 2)
    public void DeleteCustomerWithInvalidId()
    {
        deleteCustomer = new DeleteCustomerPage(driver);
        deleteCustomer.deleteCustomerForm(invalidId);
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals("Do you really want to delete this Customer?",alertMessage);
        alert.accept();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Alert alert1 = driver.switchTo().alert();
        String unAuthorizedAlertMessage = alert1.getText();
        Assert.assertEquals("You are not authorize to delete this customer!!",unAuthorizedAlertMessage);
        alert1.accept();
    }
    @Test(priority = 3)
    public void DeleteCustomer()
    {
        deleteCustomer.deleteCustomerForm(id);
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals("Do you really want to delete this Customer?",alertMessage);
        alert.accept();
    }

}
