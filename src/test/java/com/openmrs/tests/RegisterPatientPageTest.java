package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.pages.PatientPage;
import com.openmrs.utils.ElementUtil;
import com.openmrs.utils.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPatientPageTest extends BaseTest {

    @BeforeClass
    public void registerPatientPageSetup() {
        adminDashBoardPage = loginPage.doLogin(prop.getProperty("userId"), prop.getProperty("password"));
        registerPatientPage = adminDashBoardPage.goToRegisterPatientPage();
    }

    @Test(dataProvider = "getUserData")
    public void registerNewUserTest (String givenName, String familyName, String gender, String day,
                                String month, String year, String address, String city,String state,
                                String phoneNumber) {

        PatientPage patientPage=registerPatientPage.registerNewPatient(givenName,familyName,gender,day,month,year,address,city,state,phoneNumber);

        Assert.assertTrue(patientPage.verifyStartVisit());
    }

    @DataProvider
    public Object[][] getUserData(){
        Object data[][]= ExcelUtil.getTestData("registerForm");
        return data;
    }
}
