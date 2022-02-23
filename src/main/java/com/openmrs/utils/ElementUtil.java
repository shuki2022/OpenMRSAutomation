package com.openmrs.utils;

import com.openmrs.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementUtil {
    private WebDriver driver;
    private JavaScriptUtil javaScriptUtil;

    public ElementUtil(WebDriver driver){
        this.driver=driver;
        javaScriptUtil=new JavaScriptUtil(this.driver);
    }

    public WebElement getElement(By locator){
        WebElement element =driver.findElement(locator);
        if(BasePage.highlight.equalsIgnoreCase("true")) {
            javaScriptUtil.flash(element);
        }
        return element;
    }

    public List<WebElement> getElements(By locator){
        return driver.findElements(locator);

        }

     public void doClick(By locator){
        getElement(locator).click();
     }

     public void doSendKeys(By locator, String value){
        getElement(locator).sendKeys(value);
     }

     public boolean doIsDisplayed(By locator){
        return getElement(locator).isDisplayed();
     }
     public boolean doIsEnable(By locator){return getElement(locator).isEnabled();}
     public String getText(By locator){
        return getElement(locator).getText();
     }
     public void waitFor(long milliseconds){
         try {
             Thread.sleep(milliseconds);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }

}
