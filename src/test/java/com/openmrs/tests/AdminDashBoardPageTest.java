package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.pages.AdminDashBoardPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminDashBoardPageTest extends BaseTest {

    @BeforeClass
    public void adminSetUp() {
        adminDashBoardPage=loginPage.doLogin(prop.getProperty("userId"),prop.getProperty("password"));}

    @Test(priority = 1)
    public void verifyAsAdminTest(){
        Assert.assertTrue(adminDashBoardPage.verifyAdmin());
    }

    @Test(priority = 2)
    public void verifySelectedLocationTest(){
        Assert.assertTrue(adminDashBoardPage.verifyRegistraionDesk());
    }

    @Test(priority = 3)
    public void verifyCaptureVitalAppTest() {
        Assert.assertTrue(adminDashBoardPage.capturaVitalApp());
    }

    @Test(priority =4)
    public void validationLogoutTest(){
        loginPage=adminDashBoardPage.doLogout();
       Assert.assertTrue(loginPage.verifyLoginLinkBtnStatus());
    }
}
