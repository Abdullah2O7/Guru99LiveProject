package Tests;

import com.Bank.Pages.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class EditCustomerTests extends TestBase{

   HomePage homePage;
   LoginPage loginPage;
   EditCustomerPage editCustomerPage;
   Alert alert;
   NewCustomerPage newCustomerPage;
    String userId = "mngr572310";
    String password = "172003";
    Faker fakeData = new Faker();
    String name = fakeData.name().firstName();
    String Dob = "01/07/2003";
    String address= fakeData.address().streetAddress();
    String city= fakeData.nation().capitalCity();
    String state= fakeData.nation().nationality();
    String Pin= fakeData.number().digits(6);
    String mobile= fakeData.number().digits(11);
    String email = fakeData.internet().emailAddress();
    String pass = fakeData.number().digits(6);
    String id = "621";
    String invalidId = "000";

   /* @Test
    public void AddNewCustomer() throws InterruptedException {
        loginPage =new LoginPage(driver);
        loginPage.loginForm(userId,password);

        homePage=new HomePage(driver);
        homePage.OpenNewCustomerPage();
        driver.get("https://www.demo.guru99.com/V4/manager/addcustomerpage.php");

        newCustomerPage=new NewCustomerPage(driver);
        newCustomerPage.addNewCustomer(name,address,city,state,Pin,mobile,email,pass);
        Assert.assertTrue(newCustomerPage.NewCustomerAddedSuccessfully.getText().contains("Successfully!"));
        id = newCustomerPage.cusId.getText();
        System.out.println(id);
    }*/
    @BeforeTest
    public void login()
    {
        loginPage =new LoginPage(driver);
        loginPage.loginForm(userId,password);
    }

    @Test (priority = 1)
    public void openEditCustomerPage()
    {
        homePage=new HomePage(driver);
        homePage.OpenEditCustomerPage();
        driver.get("https://www.demo.guru99.com/V4/manager/EditCustomer.php");
    }
    @Test ( priority = 2)
    public void tryToEditCusWithInvalidId()
    {
        editCustomerPage=new EditCustomerPage(driver);
        editCustomerPage.LoginToEditCustomerForm(invalidId);
        alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals("You are not authorize to edit this customer!!",alertMessage);
        alert.accept();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test ( priority = 3)
    public void tryToEditCusWithValidId()
    {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.invisibilityOf(editCustomerPage.customerIdField));
       // editCustomerPage=new EditCustomerPage(driver);
        editCustomerPage.LoginToEditCustomerForm(id);
    }
    @Test(priority = 4)
    public void SubmitEditFormWithoutChanges()  {
        editCustomerPage.clickEditFormSubmitBtn();
        alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals("No Changes made to Customer records",alertMessage);
        alert.accept();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
   @Test(priority = 5)
    public void EditCustomer()  {

       editCustomerPage.LoginToEditCustomerForm(id);
       editCustomerPage.EditCustomerForm(address, city,mobile);
       alert = driver.switchTo().alert();
       alert.accept();
   }
}
