package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    private By logo = By.xpath("//div[@class='logo']/a/img");
    private By loginBtn = By.id("loginButton");
    private By userNameField = By.id("username");
    private By passwordField = By.id("password");
    private By cantLoginLink = By.id("cantLogin");
    private By questionMark = By.xpath("//i[@class='icon-question-sign small']");
    private By popupmessage = By.xpath("//div[@id='cannotLoginPopup']//p");
    private By popupokayBtn = By.xpath("//button[@class='confirm']");
    private By warningMessage = By.xpath("//div[@id='error-message']");
    private By locationLinks = By.xpath("//ul[@id='sessionLocation']/li");
    private By loginlocation = By.xpath("//ul[@id='sessionLocation']/li[@id='Registration Desk']");
    private By warningMessagewithout = By.id("sessionLocationError");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);

    }


    // verify application logo
    public boolean verifyLogo() {
        // return driver.findElement(logo).isDisplayed();
        return elementUtil.doIsDisplayed(logo);
    }

    //verify page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    //verify locations. All six locations should be available on the home page
    public List<WebElement> verifyLocations() {
        return elementUtil.getElements(locationLinks);
    }

    //verify Login button status (enabled by default)
    public boolean verifyLoginLinkBtnStatus() {
        return driver.findElement(loginBtn).isDisplayed();
    }

    //Can’t log in link status (available on the page)
    public boolean verifyCantLoginLinkStatus() {
        return driver.findElement(cantLoginLink).isDisplayed();
    }

    //verify message on popup window when click on Can’t log in? link
    public boolean verifyPopUp() {
        elementUtil.doClick(cantLoginLink);
        boolean result = elementUtil.doIsDisplayed(popupmessage);
        elementUtil.doClick(popupokayBtn);
        return result;
    }
    //verify the message when click on login button without credential and select any location (You must choose a location!)

    public boolean verifyWarningMessage() {
        elementUtil.doClick(loginBtn);
        return elementUtil.doIsDisplayed(warningMessagewithout);
    }
    //verify error message try to login without credential, only location is selected (Invalid username/password. Please try again.)

    public boolean verifyWarningWithLocation() {
        elementUtil.doClick(loginlocation);
        elementUtil.doClick(loginBtn);
        return elementUtil.doIsDisplayed(warningMessage);
    }

    //verify login functionality
    public AdminDashBoardPage doLogin(String userId, String password) {
        elementUtil.doSendKeys(userNameField, userId);
        elementUtil.doSendKeys(passwordField, password);
        elementUtil.doClick(loginlocation);
        elementUtil.doClick(loginBtn);
        return new AdminDashBoardPage(driver);
    }


}
