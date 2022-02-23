package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.Constant;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindPatientRecordPage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    public FindPatientRecordPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private By findPatientRecordIcon = By.className("icon-search");
    private By pageName = By.xpath("//div[@id='content']//h2");
    private By searchBox = By.id("patient-search");
    private By name = By.xpath("//table[@id='patient-search-results-table']/tbody/tr/td[2]");

    //verify page name(find patient Record
    public String verifyPageName() {
        System.out.println(elementUtil.getText(pageName).trim());
        return elementUtil.getText(pageName).trim();
    }

    //verify search field is enable
    public boolean verifySearchFieldEnable() {
        return elementUtil.doIsEnable(searchBox);
    }

    //verify searchFunctionality by searching a patient
    public String verifySearchFunctionality() {
        elementUtil.doSendKeys(searchBox, Constant.NAME);
        return elementUtil.getText(name);
    }

    public PatientPage verifyDirectToPatientPage() {
        elementUtil.doClick(name);
        return new PatientPage(driver);
    }
}
