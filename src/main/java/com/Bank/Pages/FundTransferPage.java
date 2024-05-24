package com.Bank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FundTransferPage extends pageBase {
    public FundTransferPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "payersaccount")
    WebElement payersAccountField;
    @FindBy(name = "payeeaccount")
    WebElement payeeAccountField;
    @FindBy(name = "ammount")
    WebElement amountField;
    @FindBy(name = "desc")
    WebElement descField;

    @FindBy(id = "message10")
    public WebElement payerAccRequiredMessage;
    @FindBy(id = "message11")
    public WebElement payeeAccRequiredMessage;
    @FindBy(id = "message1")
    public WebElement amountRequiredMessage;
    @FindBy(id = "message17")
    public WebElement descRequiredMessage;
    @FindBy(name = "AccSubmit")
    WebElement submitBtn;

    @FindBy(xpath = "(//p[@class='heading3'])[1]")
    public WebElement pageDetailsTitle;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]")
    public WebElement fromAccountNumber;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")
    public WebElement toAccountNumber;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]")
    public WebElement amount;
    @FindBy(xpath = "/html/body/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]")
    public WebElement description;
    @FindBy(linkText = "Continue")
    WebElement continueLink;


    public void RequiredFields()
    {
        clickBtn(payersAccountField);
        clickBtn(payeeAccountField);
        clickBtn(amountField);
        clickBtn(descField);
        clickBtn(payersAccountField);
    }

    public void fundTransferForm(String payerNumber, String payeeNumber, String amount, String description)
    {
        sendText(payersAccountField,payerNumber);
        sendText(payeeAccountField,payeeNumber);
        sendText(amountField, amount);
        sendText(descField, description);
        clickBtn(submitBtn);

    }
    public void clickOnContinueLink()
    {
        clickBtn(continueLink);
    }
}
