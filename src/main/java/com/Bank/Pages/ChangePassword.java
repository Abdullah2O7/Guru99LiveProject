package com.Bank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePassword extends pageBase {
    public ChangePassword(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "oldpassword")
    WebElement oldPasswordField;
    @FindBy(name = "newpassword")
    WebElement newPasswordField;
    @FindBy(name = "confirmpassword")
    WebElement confirmPasswordField;
    @FindBy(xpath = "//input[@name='sub']")
    WebElement submitBtn;

    public void changePasswordForm(String oldPassword, String newPassword)
    {
        sendText(oldPasswordField,oldPassword);
        sendText(newPasswordField,newPassword);
        sendText(confirmPasswordField,newPassword);
        clickBtn(submitBtn);
    }

}
