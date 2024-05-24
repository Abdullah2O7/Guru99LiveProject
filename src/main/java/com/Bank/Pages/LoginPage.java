package com.Bank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends pageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@name='uid']")
    WebElement UserIdField;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@name='btnLogin']")
    WebElement loginBtn;
   @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
   public WebElement successfulLoginMessage;

    public void loginForm(String id,String password)
    {
         sendText(UserIdField,id);
         sendText(passwordField,password);
         clickBtn(loginBtn);
    }
}
