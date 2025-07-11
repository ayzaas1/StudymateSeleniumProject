package com.qa.studymate.tests.testData;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.Collections;

public class LoginTestData {

    @DataProvider(name = "language")
    public Object[][] getLanguage() {
        return new Object[][]{
                {"russian"},
                {"english"}
        };
    }


    @DataProvider(name = "invalidCredentialMessage")
    public Object[][] invalidCredentialMessage() {
        return new Object[][]{
                {"english", "", "123456", "Email is required!"},
                {"english", "admin@codewise.com", "", "Password is required!"},
                {"english", "invalidemail", "123456", "Email is not valid!"},
                {"english", "admin@codewise.com", "123", "Password must be at least 6 characters!"},
                {"russian", "", "123456", "Требуется электронный адрес!"},
                {"russian", "admin@codewise.com", "", "Требуется пароль!"},
                {"russian", "invalidemail", "123456", "Не валидный электронный адрес!"},
                {"russian", "admin@codewise.com", "123", "Введите не менее 6 символов!"}
        };
    }

//    @DataProvider(name = "invalidCredentialsAlert")
//    public Object[][] invalidCredentialsAlert() {
//        return new Object[][]{
//                {"english", "admin@codewise.com", "123456", "Invalid email or password"},
//                {"russian", "sample@gmail.com", "codewise_123", "Неверный пароль или эмейл"},
//                {"english", "admin@codewise.com", "123456", "Invalid email or password"},
//                {"russian", "hello@gmail.com", "codewise_123", "Неверный пароль или эмейл"}
//
//
//        };
//    }
}


