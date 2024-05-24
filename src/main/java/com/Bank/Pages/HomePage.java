package com.Bank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends pageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='addcustomerpage.php']")
    WebElement newCustomerLink;
    @FindBy(linkText = "Edit Customer")
    WebElement editCustomerLink;
    @FindBy(linkText = "Delete Customer")
    WebElement deleteCustomerLink;
    @FindBy(linkText = "New Account")
    WebElement newAccountLink;
    @FindBy(linkText = "Edit Account")
    WebElement editAccountLink;
    @FindBy(xpath = "//div[@id='dismiss-button']")
     WebElement dismissButton;
    @FindBy(linkText = "Fund Transfer")
    WebElement fundTransferLink;
    @FindBy(linkText = "Change Password")
    WebElement changePasswordLink;
   public void OpenNewCustomerPage()
   {
       clickBtn(newCustomerLink);
   }
    public void OpenEditCustomerPage()
    {
        clickBtn(editCustomerLink);
    }
    public void OpenDeleteCustomerPage()
    {
        clickBtn(deleteCustomerLink);
    }
    public void OpenNewAccountPage(){clickBtn(newAccountLink);}
    public void openEditAccountPage(){clickBtn(editAccountLink);}
    public void SkipContent()
    {
        clickBtn(dismissButton);
    }
    public void OpenFundTransferPage()
    {
        clickBtn(fundTransferLink);
    }
    public void OpenChangePasswordPage(){clickBtn(changePasswordLink);}

}
