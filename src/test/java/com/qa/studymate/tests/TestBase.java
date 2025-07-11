package com.qa.studymate.tests;

import com.qa.studymate.utilities.ConfigReader;
import com.qa.studymate.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver("chrome");
        driver.get(ConfigReader.readProperty("url"));

    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
