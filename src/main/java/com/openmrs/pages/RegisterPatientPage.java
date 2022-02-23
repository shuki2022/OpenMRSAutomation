package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPatientPage extends BasePage {

    private WebDriver driver;
    ElementUtil elementUtil;

    public RegisterPatientPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private By givenNameField = By.name("givenName");
    private By middleNameField = By.name("middleName");
    private By familyNameField = By.name("familyName");
    private By unidentifiedPatientCheckBox = By.id("checkbox-unknown-patient");
    private By nextIcon =By.id("next-button");
    private By genderFemale = By.xpath("//option[@value='F']");
    private By genderMale = By.xpath("//option[@value='M']");
    private By next = By.id("next-button");
    private By bday = By.id("birthdateDay-field");
    private By bMonth = By.id("birthdateMonth-field");
    private By bYear = By.id("birthdateYear-field");
    private By address = By.id("address1");
    private By city = By.id("cityVillage");
    private By state =By.id("stateProvince");
    private By phoneNumber = By.name("phoneNumber");
    private By confirmBtn = By.id("submit");
    private By patientIdLink = By.xpath("//em[text()='Patient ID']");

    public PatientPage registerNewPatient(String givenName, String familyName, String gender, String day,
                                   String month, String year, String address, String city,String state,
                                  String PhoneNumber) {

        elementUtil.doSendKeys(givenNameField,givenName);
        elementUtil.doSendKeys(familyNameField,familyName);
        elementUtil.doClick(nextIcon);

        if (gender.equalsIgnoreCase("male")) {
            elementUtil.doClick(genderMale);
        } else {
            elementUtil.doClick(genderFemale);
        }
        elementUtil.doClick(nextIcon);

        elementUtil.doSendKeys(bday,day);
        elementUtil.doSendKeys(bMonth,month);
        elementUtil.doSendKeys(bYear,year);
        elementUtil.doClick(nextIcon);

        elementUtil.doSendKeys(this.address,address);
        elementUtil.doSendKeys(this.city,city);
        elementUtil.doSendKeys(this.state,state);
        elementUtil.doClick(nextIcon);

        elementUtil.doSendKeys(this.phoneNumber,PhoneNumber);
        elementUtil.doClick(nextIcon);

        elementUtil.doClick(nextIcon);

        elementUtil.doClick(confirmBtn);

        return new PatientPage(driver);
    }


}
