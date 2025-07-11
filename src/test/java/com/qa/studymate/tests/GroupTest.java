package com.qa.studymate.tests;

import com.qa.studymate.pages.GroupPage;
import com.qa.studymate.pages.LoginPage;
import com.qa.studymate.utilities.ConfigReader;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.qa.studymate.utilities.Driver.driver;

public class GroupTest extends TestBase {

    @Parameters(value = {"groupImagePath", "groupName", "groupDate", "groupDescription", "expectedMessage"})
    @Test
    public void addGroupFunctionality(String groupImagePath, String groupName, String groupDate, String groupDescription, String expectedMessage) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("email"), ConfigReader.readProperty("password"));
        GroupPage groupPage = new GroupPage(driver);
        groupPage.createGroup(groupImagePath, groupName, groupDate, groupDescription, expectedMessage);

    }
}
