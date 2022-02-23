package com.openmrs.pages;

import com.openmrs.base.BasePage;
import com.openmrs.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashBoardPage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    public AdminDashBoardPage(WebDriver driver){
        this.driver =driver;
        elementUtil=new ElementUtil(driver);
    }

    private By logoutBtn=By.xpath("//a[contains(text(),'Logout')]");
    private By FindPatientIcon=By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension");
    private By activeVisitIcon=By.className("icon-calendar");
    private By captureVitalIcon=By.id("referenceapplication-vitals-referenceapplication-vitals-extension");
    private By appointmentScheduleIcon= By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension");
    private By reportIcon=By.id("reportingui-reports-homepagelink-reportingui-reports-homepagelink-extension");
    private By dataManagementIcon =By.id("coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension");
    private By configureMetadataIcon =By.id("org-openmrs-module-adminui-configuremetadata-homepageLink-org-openmrs-module-adminui-configuremetadata-homepageLink-extension");
    private By systemAdministrationIcon = By.id("coreapps-systemadministration-homepageLink-coreapps-systemadministration-homepageLink-extension");
    private By registrationDesk =By.id("selected-location");
    private By adminlink =By.xpath("//div[@id='navbarSupportedContent']//li[text()[contains(.,'admin')]]");
    private By registerPatientLink = By.linkText("Register a patient");
    public boolean verifyAdmin(){
        return elementUtil.doIsDisplayed(adminlink);
    }


    public boolean verifyActiveVisitApp(){
        return elementUtil.doIsDisplayed(activeVisitIcon);

    }

    public boolean verifyRegistraionDesk(){
        return elementUtil.doIsDisplayed(registrationDesk);
    }

    public boolean verifyFindPatienRecordApp(){
        return elementUtil.doIsDisplayed(FindPatientIcon);
    }
    public boolean capturaVitalApp(){
        return elementUtil.doIsDisplayed(captureVitalIcon);
    }

    public boolean verifyAppointmentSchedulingApp(){
        return elementUtil.doIsDisplayed(appointmentScheduleIcon);
    }

    public LoginPage doLogout(){
        elementUtil.doClick(logoutBtn);
        return new LoginPage(driver);
    }

    public boolean verifyLogoutBtn() {return elementUtil.doIsDisplayed(logoutBtn);}

    public RegisterPatientPage goToRegisterPatientPage() {
        elementUtil.doClick(registerPatientLink);
        return new RegisterPatientPage(driver);
    }
     public FindPatientRecordPage goToFindPatientRecordPage(){
        elementUtil.doClick(FindPatientIcon);
        return new FindPatientRecordPage(driver);
     }
    }
