package com.qa.studymate.pages;

import com.qa.studymate.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static com.qa.studymate.utilities.Driver.driver;

public class LoginPage {


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//label[@data-shrink='true']/../div//div")
    public WebElement languageDropdown;

    @FindBy(xpath = "//li[.='Русский']")
    public WebElement rusLanguage;

    @FindBy(xpath = "//li[.='English']")
    public WebElement engLanguage;

    @FindBy(css = "input[name='email']")
    public WebElement loginEmail;

    @FindBy(css = "input[name='password']")
    public WebElement loginPassword;

    @FindBy(css = "button[type=submit]")
    public WebElement loginButton;


    @FindBy(css = "div[class='MuiAlert-message css-1xsto0d']")
    public WebElement invalidCredentialsAlert;


    public void chooseLanguage(String language) {
        languageDropdown.click();
        switch (language.toLowerCase()) {
            case "russian":
                rusLanguage.click();
                break;
            case "english":
                engLanguage.click();
                break;
            default:
                Assert.fail("Unsupported language. Choose english or russian. ");
        }
    }

    public void login(String email, String password) {
        this.loginEmail.sendKeys(email);
        this.loginPassword.sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        BrowserUtils.clickJS(driver, loginButton);

    }


    public String getLoginErrorMessage() {
        List<WebElement> errorMessages = driver.findElements(By.cssSelector("span[class='sc-ipEyDJ jBKvvv']"));
        for (WebElement errorMessage : errorMessages) {
            if (errorMessage.isDisplayed()) {
                String text = errorMessage.getText().trim();
                if (!text.isEmpty()) {
                    return text;
                }
            }
        }
        return null;
    }


//        public String getInvalidCredentialsAlert() {
//        List<WebElement> alert = driver.findElements(By.cssSelector("div[class='MuiAlert-message css-1xsto0d']"));
//        return alert.isEmpty() ? "" : alert.get(0).getText().trim();
//    }
}
