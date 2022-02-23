package com.openmrs.pages;

import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientPage {

    private WebDriver driver;
    ElementUtil elementUtil;

    public PatientPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    //private By patientIdLink = By.xpath("//em[text()='Patient ID']");
    private By scheduleApp =By.xpath("//ul[@class='float-left']//li[4]/a");
    private By requestAppointment=By.xpath("//ul[@class='float-left']//li[4]/a");
    private By startVisit=By.xpath("//li[@class='float-left']/a[@id='org.openmrs.module.coreapps.createVisit']");

    public String verifyScheduleApp (){

        return elementUtil.getText(scheduleApp);
    }
    public boolean verifyStartVisit(){
        return elementUtil.doIsDisplayed(startVisit);
    }






}
