package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.utils.Constant;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindPatientRecordPageTest extends BaseTest {

    @BeforeClass
    public void FindPatientPageSetup() {
        adminDashBoardPage = loginPage.doLogin(prop.getProperty("userId"), prop.getProperty("password"));
        findPatientRecordPage = adminDashBoardPage.goToFindPatientRecordPage();
    }


    @Test(priority = 1)
    public void verifyPageNameTest(){
        Assert.assertEquals(findPatientRecordPage.verifyPageName(), Constant.PAGE_NAME);
    }

    @Test(priority = 2)
    public void verifySearchFieldEnableTest(){
        Assert.assertTrue(findPatientRecordPage.verifySearchFieldEnable());
    }

    @Test(priority = 3)
    public void verifySearchingFunctionalityTest(){
        Assert.assertEquals(findPatientRecordPage.verifySearchFunctionality(),Constant.NAME);
    }

    @Test(priority = 4)
    public void verifyDirectToPatientPageTest(){
        Assert.assertEquals(findPatientRecordPage.verifyDirectToPatientPage(),patientPage.verifyScheduleApp());
    }
}
