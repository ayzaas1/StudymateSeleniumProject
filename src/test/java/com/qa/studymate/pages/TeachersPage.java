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

import static com.qa.studymate.utilities.Driver.driver;

public class TeachersPage {

    public TeachersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@href='/admin/teachers']/li")
    WebElement teachersButton;

    @FindBy(xpath = "//button[.='Add teacher']")
    WebElement addTeacherButton;

    @FindBy(xpath = "//input[@name='name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailAddress;

    @FindBy(xpath = "//input[@name='specialization']")
    WebElement specialization;

    @FindBy(xpath = "//div[@role='button']")
    WebElement chooseCoursesButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement javaCheckBox;

    @FindBy(xpath = "//button[.='Add']")
    WebElement addButton;


    public void addTeacherInfo(String name, String lastName, String phoneNumber, String email, String specialization) {
        teachersButton.click();
        addTeacherButton.click();
        this.firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);
        this.phoneNumber.click();
        this.phoneNumber.sendKeys(phoneNumber);
        this.emailAddress.sendKeys(email);
        this.specialization.sendKeys(specialization);
        this.chooseCoursesButton.click();
        this.javaCheckBox.click();
        BrowserUtils.clickJS(driver, addButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/admin/teachers"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/teachers"));

        WebElement table = driver.findElement(By.tagName("table"));
        wait.until(ExpectedConditions.textToBePresentInElement(table, email));
        Assert.assertTrue(table.getText().contains(email));
    }
}

