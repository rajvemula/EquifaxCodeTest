package com.amazon.libs;

import org.openqa.selenium.*;
import org.testng.Assert;

import javax.xml.transform.sax.SAXSource;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ActionEngine extends BrowserFactory {
    /*
     * Input Locator and String Text
     * Sending the value to the input field
     */
    public  void sendValue(By locator, String elementValue) throws Exception {
        try {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(elementValue);
            System.out.println("Successfully sending text: " + elementValue);
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    /*
     * Input Locator
     * Click using on Selenium click
     */
    public  void clickELE(By locator) throws Exception {
        try {
            driver.findElement(locator).click();
            System.out.println("Clicking on " + locator);
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    /*
     * Input Locator
     * Clicking on the Element using Java Script
     */
    public  void clickJSELE(By locator) throws Exception {
        try {
            WebElement ele = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", ele);
            System.out.println("Clicking on " + ele);
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }
    /*
     * Input Locator
     * Return type is Text
     */
    public  String getElementText(By locator) throws Exception {
        String text = null;
        try {
            WebElement ele = driver.findElement(locator);
            text = ele.getText();
            System.out.println("Locator Text is: " + text);
        } catch (NoSuchElementException e) {
            Assert.fail("Text is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
        return text;
    }
    /*
     * Waiting 3*1000
     * Hard waits
     */
    public void sleep() {
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
