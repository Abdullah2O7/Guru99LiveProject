package com.Bank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountPage extends pageBase {
    public EditAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "accountno")
    WebElement accountNumField;
    @FindBy(name = "AccSubmit")
    WebElement submitBtn1;

    public void editAccountForm(String accountNum)
    {
        sendText(accountNumField,accountNum);
        clickBtn(submitBtn1);
    }
}
