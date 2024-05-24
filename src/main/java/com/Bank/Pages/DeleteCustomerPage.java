package com.Bank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCustomerPage extends pageBase {
    public DeleteCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@name='cusid']")
    WebElement customerIdField;
    @FindBy(xpath = "//input[@name='AccSubmit']")
    WebElement submitBtn;

    public void deleteCustomerForm(String id)
    {
        sendText(customerIdField,id);
        clickBtn(submitBtn);
    }
}
