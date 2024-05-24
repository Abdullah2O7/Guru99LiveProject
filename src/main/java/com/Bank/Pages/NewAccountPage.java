package com.Bank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage extends HomePage {
    public NewAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@name='cusid']")
    WebElement cusIDField;
    @FindBy(xpath = "//input[@name='inideposit']")
    WebElement depositField;
    @FindBy(xpath = "//input[@name='button2']")
    WebElement submitBtn;
    @FindBy(name = "selaccount")
    WebElement accountTypeList;
    @FindBy(xpath = "//p[@class='heading3']")
    public WebElement message;
    @FindBy(xpath = "//*[@id=\"account\"]/tbody/tr[4]/td[2]")
    public WebElement accountId;


    public void addNewAccount(String id,String deposit)
    {
        select = new Select(accountTypeList);
        sendText(cusIDField,id);
        select.selectByIndex(1);
        sendText(depositField,deposit);
        clickBtn(submitBtn);
    }
}
