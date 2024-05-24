package com.Bank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCustomerPage extends pageBase {
    public EditCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@name='cusid']")
    public WebElement customerIdField;
    @FindBy(xpath = "//input[@name='AccSubmit']")
    WebElement submitBtn;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement EditFormSubmitBtn;
    @FindBy(xpath = "//input[@name='name']")
    WebElement cus_name;
    @FindBy(xpath = "//textarea[@name='addr']")
    WebElement addressField;
    @FindBy(xpath = "//input[@name='city']")
    WebElement cityField;
    @FindBy(xpath = "//input[@name='telephoneno']")
    WebElement mobileNumField;


    public void LoginToEditCustomerForm(String id) {

        sendText(customerIdField,id);
        clickBtn(submitBtn);
    }
    public void clickEditFormSubmitBtn()
    {
        clickBtn(EditFormSubmitBtn);
    }
    public void EditCustomerForm(String address, String city, String mobileNum)
    {
        addressField.clear();
        sendText(addressField,address);
        cityField.clear();
        sendText(cityField,city);
        mobileNumField.clear();
        sendText(mobileNumField, mobileNum);
        clickBtn(EditFormSubmitBtn);
    }
}
