package com.Bank.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;


public class pageBase {
    protected WebDriver driver;
    public Select select;
    public Actions action;

    public pageBase(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public static void clickBtn(WebElement element){
        element.click();
    }
    public static void sendText(WebElement element,String text)
    {
        element.sendKeys(text);
    }
    public static void sendDate(WebElement element, Date date)
    {

    }
}
