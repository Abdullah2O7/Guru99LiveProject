package com.Bank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCustomerPage extends pageBase {
    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }
   @FindBy(xpath = "//input[@name='name']")
    WebElement customerNameBtn;
    @FindBy(xpath = "//input[@id='dob']")
    WebElement dateField;
    @FindBy(xpath = "//textarea[@name='addr']")
    WebElement addressBtn;
    @FindBy(xpath = "//input[@name='city']")
    WebElement cityBtn;
    @FindBy(xpath = "//input[@name='state']")
    WebElement stateBtn;
    @FindBy(xpath = "//input[@name='pinno']")
    WebElement pinBtn;
    @FindBy(xpath = "//input[@name='emailid']")
    WebElement emailBtn;
    @FindBy(xpath = "//input[@name='telephoneno']")
    WebElement mobileNumberBtn;
    @FindBy(name = "password")
    WebElement passwordBtn;
    @FindBy(xpath = "//input[@name='sub']")
    WebElement submitBtn;
    @FindBy(xpath = "//p[@class='heading3']")
    public WebElement NewCustomerAddedSuccessfully;
    @FindBy(xpath = "//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
    public WebElement cusId;

    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[14]/td/a")
    public WebElement continueBtn;


    public String CusID="";
    String dob = "11/12/2001";


    public void addNewCustomer(String name,String address,String city,String state,String pin,String mobile,String email,String password) throws InterruptedException {
          sendText(customerNameBtn,name);

          dateField.click();
          dateField.sendKeys("11");
          dateField.sendKeys("12");
          dateField.sendKeys("1989");

          Thread.sleep(1000);
          sendText(addressBtn,address);
          sendText(cityBtn,city);
          sendText(stateBtn,state);
          sendText(pinBtn,pin);
          sendText(mobileNumberBtn,mobile);
          sendText(emailBtn,email);
          sendText(passwordBtn,password);
          clickBtn(submitBtn);
    }
}
