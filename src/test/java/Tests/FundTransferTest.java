package Tests;


import com.Bank.Pages.FundTransferPage;
import com.Bank.Pages.HomePage;
import com.Bank.Pages.LoginPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Report;

public class FundTransferTest extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    FundTransferPage fundTransferPage;

    String userId = "mngr572310";
    String password = "172003";
    String payerAccountNumber = "135084";
    String payeeAccountNumber = "135083";
    String amount = "50";
    String highAmount = "9000000";
    String description = "Fund Transfer Test";

    @Test(priority = 1)
    public void openFundTransferPage()
    {
        loginPage = new LoginPage(driver);
        loginPage.loginForm(userId,password);

        homePage = new HomePage(driver);
        homePage.OpenFundTransferPage();
        driver.get("https://www.demo.guru99.com/V4/manager/FundTransInput.php");
    }
    @Test(priority = 2)
    public void VerifyThatAllFieldsAreRequired()
    {
        fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.RequiredFields();
        Assert.assertEquals(fundTransferPage.payerAccRequiredMessage.getText(), "Payers Account Number must not be blank");
        Assert.assertEquals(fundTransferPage.payeeAccRequiredMessage.getText(), "Payees Account Number must not be blank");
        Assert.assertEquals(fundTransferPage.amountRequiredMessage.getText(), "Amount field must not be blank");
        Assert.assertEquals(fundTransferPage.descRequiredMessage.getText(), "Description can not be blank");
    }
    @Test(priority = 3)
    public void FundTransferWithHighAmount()
    {
        fundTransferPage.fundTransferForm(payerAccountNumber,payeeAccountNumber,highAmount,description);
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals("Transfer Failed. Account Balance low!!",alertMessage);
        alert.accept();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test(priority = 4)
    public void FundTransferFunctionality()
    {
        //fundTransferPage = new FundTransferPage(driver);
        fundTransferPage.fundTransferForm(payerAccountNumber,payeeAccountNumber,amount,description);
    }
//    @Test(priority = 5)
//    public void VerifyFundTransferDetails()
//    {
//        Assert.assertEquals(payerAccountNumber, fundTransferPage.fromAccountNumber);
//        Assert.assertEquals(payeeAccountNumber, fundTransferPage.toAccountNumber);
//        Assert.assertEquals(amount, fundTransferPage.amount);
//        Assert.assertEquals(description, fundTransferPage.description);
//        fundTransferPage.clickOnContinueLink();
//
//    }
}
