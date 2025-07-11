package com.qa.studymate.tests;

import com.qa.studymate.pages.LoginPage;
import com.qa.studymate.pages.StudentsPage;
import com.qa.studymate.tests.testData.StudentData;
import com.qa.studymate.utilities.ConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class StudentsTest extends TestBase {


    @Test
    public void addStudentFunctionality() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("email"), ConfigReader.readProperty("password"));
        StudentsPage studentsPage = new StudentsPage(driver);
        studentsPage.addStudentOnline(driver, "salim", "aryanov", "773 111 2222", "kmkmml@gmail.com");
    }


    @Test(dataProvider = "students", dataProviderClass = StudentData.class)
    public void testdlogin(String name, String lastname, String phone, String email) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.readProperty("email"), ConfigReader.readProperty("password"));
        StudentsPage studentsPage = new StudentsPage(driver);
        studentsPage.addStudentOffline(driver,name,lastname,phone,email);




    }
}
