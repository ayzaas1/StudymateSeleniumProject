package com.qa.studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.qa.studymate.utilities.Driver.driver;

public class GroupPage {
    public GroupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[.='Create group']")
    WebElement createGroupButton;

    @FindBy(xpath = "//input[@type='file']")
    WebElement groupImageInput;

    @FindBy(css = "input[name='name']")
    WebElement groupNameInput;

    @FindBy(css = "input[name='dateOfFinish']")
    WebElement groupDateInput;

    @FindBy(xpath = "//textarea[@name='description']")
    WebElement groupDescriptionInput;

    @FindBy(xpath = "//button[.='Create']")
    WebElement groupCreateButton;

    @FindBy(xpath = "//p[.='Group successfully saved']")
    WebElement groupCreatedMessage;

    public void createGroup(String groupImagePath, String groupName, String groupDate, String groupDescription, String expectedMessage) {
        createGroupButton.click();
        groupImageInput.sendKeys(groupImagePath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(groupNameInput));
        groupNameInput.sendKeys(groupName);
        groupDateInput.click();
        groupDateInput.sendKeys(groupDate);
        groupDescriptionInput.click();
        groupDescriptionInput.sendKeys(groupDescription);
        groupCreateButton.click();

        wait.until(ExpectedConditions.visibilityOf(groupCreatedMessage));
        Assert.assertEquals(groupCreatedMessage.getText(), expectedMessage);
    }
}
