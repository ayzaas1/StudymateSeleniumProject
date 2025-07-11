package com.qa.studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class StudentsPage {

    public StudentsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//li[contains(text(),'Students')]")
    WebElement studentsSection;


    @FindBy(xpath = "//button[.='Add student'] ")
    WebElement addStudentButton;

    @FindBy(xpath = "//input[@name='name']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailInput;

    @FindBy(id = "mui-component-select-groupId")
    WebElement groupField;

    @FindBy(xpath = "//li[contains(text(),'Batch 9')]")
    WebElement Batch9;

    @FindBy(id = "mui-component-select-studyFormat")
    WebElement studyFormatField;

    @FindBy(xpath = "//li[.='ONLINE']")
    WebElement onlineFormat;

    @FindBy(xpath = "//li[.='OFFLINE']")
    WebElement offlineFormat;

    @FindBy(xpath = "//button[.='Add']")
    WebElement addStudentButtonF;

    @FindBy(linkText = "New student successfully saved")
    WebElement studentSavedMessage;

    @FindBy(xpath = "//tbody/tr[1]/td[7]/div/button")
    WebElement editButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/ul/li[3]")
    WebElement deleteDivision;

    @FindBy(xpath = "//button[.='Delete']")
    WebElement deleteButton;

    @FindBy(linkText = "Student successfully deleted")
    WebElement studentDeletedMessage;

    @FindBy(xpath = "//tbody")
    WebElement table;

    public void addStudentOnline(WebDriver driver, String name, String lastName, String phone, String email) {
        studentsSection.click();
        addStudentButton.click();
        nameInput.sendKeys(name);
        lastNameInput.sendKeys(lastName);
        phoneNumberInput.click();
        phoneNumberInput.sendKeys(phone);
        emailInput.sendKeys(email);
        groupField.click();
        Batch9.click();
        studyFormatField.click();
        onlineFormat.click();
        addStudentButtonF.click();


    }

    public void addStudentOffline(WebDriver driver, String name, String lastName, String phone, String email) throws InterruptedException {
        studentsSection.click();
        addStudentButton.click();
        nameInput.sendKeys(name);
        lastNameInput.sendKeys(lastName);
        phoneNumberInput.click();
        phoneNumberInput.sendKeys(phone);
        emailInput.sendKeys(email);
        groupField.click();
        Batch9.click();
        studyFormatField.click();
        offlineFormat.click();
        addStudentButtonF.click();
        System.out.println(table.getText());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(table, email));
        Assert.assertTrue(table.getText().contains(email));
    }


}

