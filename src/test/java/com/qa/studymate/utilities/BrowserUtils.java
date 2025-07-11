package com.qa.studymate.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.Set;


public class BrowserUtils {

    public static void selectBy(WebElement location, String attributeValue, String method) {//make ot dynamic with parameters


        Select select = new Select(location);
        method = method.toLowerCase();

        switch (method) {//is a way to put a specific condition, but we need to break it because no if condition

            case "text"://case - condition
                select.selectByVisibleText(attributeValue);
                break;//breaking line to not go further
            case "value":
                select.selectByValue(attributeValue);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(attributeValue));
                break;

            default:
                Assert.fail("The methodName provided is not one of the text, value, index");//It makes the execution fail no matter what
        }
    }


    public static void clickJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }


    public static void scrollWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public static void sendKeysJS(WebDriver driver, WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", element, text);
    }


    public static void switchWindow(WebDriver driver, String title) {
        Set<String> pageIDs = driver.getWindowHandles();
        for (String id: pageIDs){
            driver.switchTo().window(id);//no matter what switches
            if (driver.getTitle().contains(title)){
                break;
            }
        }

    }
}
