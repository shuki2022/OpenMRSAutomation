package com.openmrs.base;

import com.openmrs.utils.OptionsManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {


    public Properties prop;
    public static String highlight;
    public OptionsManager optionsManager;
    public static ThreadLocal<WebDriver>tlDriver =new ThreadLocal<WebDriver>();


    public WebDriver init_driver(String browser){

       highlight= prop.getProperty("highlight");
       optionsManager=new OptionsManager(prop);
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            if(Boolean.parseBoolean(prop.getProperty("remote"))) {
                //initn remote webdriver
                init_remoteDriver("chrome");
            }else{tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));}

        }else if(browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            if (Boolean.getBoolean(prop.getProperty("remote"))) {
        //init remote webdriver
                init_remoteDriver("firefox");
            } else {

                tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
            }
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return getDriver();
}

private void init_remoteDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            DesiredCapabilities dc =DesiredCapabilities.chrome();
            dc.setCapability(ChromeOptions.CAPABILITY,optionsManager.getChromeOptions());
            try {
                tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")),dc));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else if(browser.equalsIgnoreCase("firefox")){
            DesiredCapabilities dc =DesiredCapabilities.firefox();
            dc.setCapability(FirefoxOptions.FIREFOX_OPTIONS,optionsManager.getFirefoxOptions());
            try {
                tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")),dc));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
}

public static synchronized WebDriver getDriver(){
        return tlDriver.get();
}
public Properties init_prop(){
        prop= new Properties();
    FileInputStream fis =null;
    try {
        fis =new FileInputStream("/Users/gulsir/study-java/OpenMRSAutomation/src/main/java/com/openmrs/config/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
    }
    return prop;
}

public String getScreenshot(){
    File scr=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);

    String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
    File destination =new File(path);
    try {
        FileUtils.copyFile(scr,destination);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return path;
}
}

