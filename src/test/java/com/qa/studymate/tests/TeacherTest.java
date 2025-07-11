package com.qa.studymate.tests;

import com.qa.studymate.pages.LoginPage;
import com.qa.studymate.pages.TeachersPage;
import com.qa.studymate.utilities.ConfigReader;
import org.testng.annotations.Test;

public class TeacherTest extends TestBase {

    @Test
    public void addTeacherFunctionality() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("email"), ConfigReader.readProperty("password"));
        TeachersPage teachersPage = new TeachersPage(driver);
        teachersPage.addTeacherInfo("Kelly", "Rodrigez", "773 111 2223", "kelly@gmail.com", "Automation");

    }
}
