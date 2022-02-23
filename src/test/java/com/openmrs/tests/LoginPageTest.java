package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.pages.AdminDashBoardPage;
import com.openmrs.utils.Constant;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {


    @Test(priority = 1)
    public void verifyLogoTest(){
        Assert.assertTrue(loginPage.verifyLogo());
    }

    @Test(priority = 2)
    public void verifyLoginPageTitle(){
     Assert.assertEquals(loginPage.getPageTitle(), Constant.PAGE_TITLE);
 }

   @Test(priority = 3)
   public void verifyLocation(){
        Assert.assertEquals(loginPage.verifyLocations().size(),Constant.locsize);
   }

    @Test(priority=4)
    public void verifyLoginButtonStatus(){
        Assert.assertTrue(loginPage.verifyLoginLinkBtnStatus());
    }

   @Test(priority = 5)
   public void verifyCantLoginStatus(){
        Assert.assertTrue(loginPage.verifyCantLoginLinkStatus());
    }

    @Test(priority = 6)
    public void verifyPopupTest(){
        Assert.assertTrue(loginPage.verifyPopUp());
    }

    @Test(priority=7)
    public void verifyWarningMessageTest() throws InterruptedException {
        Assert.assertTrue(loginPage.verifyWarningMessage());
    }

    @Test(priority = 8)
    public void verifyWarningMessageTest2(){
        Assert.assertTrue(loginPage.verifyWarningWithLocation());
    }


   @Test(priority=9)
    public void validateUserLoginTest()  {

      // loginPage.doLogin(prop.getProperty("userId"),prop.getProperty("password") );
     //Assert.assertTrue(adminDashBoardPage.verifyLogoutBtn());

       AdminDashBoardPage adminDashBoardPage = loginPage.doLogin(prop.getProperty("userId"), prop.getProperty("password"));

       Assert.assertTrue(adminDashBoardPage.verifyLogoutBtn());
   }
}

