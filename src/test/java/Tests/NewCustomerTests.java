package Tests;

import com.Bank.Pages.HomePage;
import com.Bank.Pages.LoginPage;
import com.Bank.Pages.NewCustomerPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class NewCustomerTests extends TestBase{

HomePage homePage;
LoginPage loginPage;
NewCustomerPage newCustomerPage;
    String userId = "mngr572310";
    String password = "172003";
    Faker fakeData = new Faker();
    String name = fakeData.name().firstName();
    String Dob = String.valueOf(fakeData.date().birthday());
            //"01/07/2003";
    String address= fakeData.address().streetAddress();
    String city= fakeData.nation().capitalCity();
    String state= fakeData.nation().nationality();
    String Pin= fakeData.number().digits(6);
    String mobile= fakeData.number().digits(11);
    String email = fakeData.internet().emailAddress();
    String pass = fakeData.number().digits(6);



@Test
public void AddNewCustomer() throws InterruptedException {
      loginPage = new LoginPage(driver);
      loginPage.loginForm(userId,password);
      homePage=new HomePage(driver);
      homePage.OpenNewCustomerPage();
      //homePage.SkipContent();
      driver.get("https://www.demo.guru99.com/V4/manager/addcustomerpage.php");
      newCustomerPage=new NewCustomerPage(driver);
      newCustomerPage.addNewCustomer(name,address,city,state,Pin,mobile,email,pass);
      Assert.assertTrue(newCustomerPage.NewCustomerAddedSuccessfully.getText().contains("Successfully!"));
      newCustomerPage.CusID = newCustomerPage.cusId.getText();
      System.out.println(newCustomerPage.CusID);
}

}
