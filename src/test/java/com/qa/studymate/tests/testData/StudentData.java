package com.qa.studymate.tests.testData;

import org.testng.annotations.DataProvider;

public class StudentData {

        @DataProvider(name = "students")
        public Object[][] getStudentsData() {
            return new Object[][]{
                    {"Salim", "Aryanov", "7737777777", "salim@gmail.com"},
                    {"Michael", "Jackson", "7737777777", "mJackson@gmail.com"}
            };

        }
    }

