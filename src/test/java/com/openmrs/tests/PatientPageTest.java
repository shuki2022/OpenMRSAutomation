package com.openmrs.tests;

import com.openmrs.base.BaseTest;
import com.openmrs.utils.Constant;
import org.apache.hc.core5.reactor.Command;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PatientPageTest extends BaseTest {

    @BeforeClass
    public void PatientPageSetup() {
            adminDashBoardPage = loginPage.doLogin(prop.getProperty("userId"), prop.getProperty("password"));
            findPatientRecordPage=adminDashBoardPage.goToFindPatientRecordPage();
            patientPage = findPatientRecordPage.verifyDirectToPatientPage();
    }

    @Test(priority =1)
    public void verifyLinkOnActionColumn(){
    Assert.assertEquals(patientPage.verifyScheduleApp(), Constant.APPONPATIENTPAGE);
}

   @Test(priority = 2)
   public void verifyLinkOnActionColumn2(){
    Assert.assertTrue(patientPage.verifyStartVisit());
}
}
