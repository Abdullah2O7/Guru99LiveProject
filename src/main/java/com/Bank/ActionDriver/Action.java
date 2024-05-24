package com.Bank.ActionDriver;

import com.Bank.Pages.pageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {
    public static void scrollByVisibilityOfElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void click(WebDriver driver, WebElement element)
    {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }
    public static void sendText(WebDriver driver,WebElement element, String text)
    {
        Actions actions = new Actions(driver);
        actions.sendKeys(element,text);
    }

    public static boolean findElement(WebDriver driver, WebElement element)
    {
        boolean flag = false;
        try {
            element.isDisplayed();
            flag  = true;
        } catch (Exception e){
            flag = false;
        }finally {
            if(flag) System.out.println("Successfully Found Element");
            else System.out.println("Unable to find Element");
        }
        return flag;
    }
    public static boolean isDisplayed(WebDriver driver, WebElement element)
    {
        boolean flag =false;
        flag = findElement(driver, element);
        if(flag) {
            flag = element.isDisplayed();
            if (flag) {
                System.out.println("The Element is Displayed");
            } else {
                System.out.println("The Element is not Displayed");
            }
        }else{
            System.out.println("Not Displayed");
        }
        return flag;
    }
    public static boolean isSelected(WebDriver driver, WebElement element)
    {
        boolean flag =false;
        flag = findElement(driver, element);
        if(flag) {
            flag = element.isSelected();
            if (flag) {
                System.out.println("The Element is Selected");
            } else {
                System.out.println("The Element is not Selected");
            }
        }else {
            System.out.println("Not Selected");
        }
        return flag;
    }
    public static boolean isEnabled(WebDriver driver, WebElement element)
    {
        boolean flag =false;
        flag = findElement(driver, element);
        if(flag) {
            flag = element.isEnabled();
            if (flag) {
                System.out.println("The Element is Enabled");
            } else {
                System.out.println("The Element is not Enabled");
            }
        }else {
            System.out.println("Not Enabled");
        }
        return flag;
    }
    public static boolean type(WebElement element, String text)
    {
        boolean flag = false;
        try {
            flag = element.isDisplayed();
            element.clear();
            element.sendKeys(text);
        }catch (Exception e){
            System.out.println("Location Not found");
        }
        return flag;
    }
}
