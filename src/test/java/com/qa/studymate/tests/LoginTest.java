package com.qa.studymate.tests;

import com.qa.studymate.pages.LoginPage;
import com.qa.studymate.tests.testData.LoginTestData;
import com.qa.studymate.utilities.ConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest extends TestBase {


    @Test
    public void loginSuccessfully() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("email"), ConfigReader.readProperty("password"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("admin/groups?size=10&page=1"));
        String expectedUrl = ConfigReader.readProperty("expected_url");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }


    @Test(dataProvider = "language", dataProviderClass = LoginTestData.class)
    public void chooseLanguageAndLoginSuccessfully(String language) {
        LoginPage loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage.chooseLanguage(language);
        loginPage.login(ConfigReader.readProperty("email"), ConfigReader.readProperty("password"));
        wait.until(ExpectedConditions.urlContains("admin"));
        String expectedUrl = ConfigReader.readProperty("expected_url");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(dataProvider = "invalidCredentialMessage", dataProviderClass = LoginTestData.class)
    public void invalidLoginErrorMessages(String language, String email, String password, String expectedErrorMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.chooseLanguage(language);
        loginPage.login(email, password);
        String actualErrorMessage = loginPage.getLoginErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

//    @Test(dataProvider = "invalidCredentialsAlert", dataProviderClass = LoginTestData.class)
//    public void invalidCredentialsAlert(String language, String email, String password, String expectedAlert) {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.chooseLanguage(language);
//        loginPage.loginFunctionality(email, password);
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        String actualAlert = loginPage.getInvalidCredentialsAlert();
//        Assert.assertEquals(actualAlert, expectedAlert);
//    }


}

