package com.amazon.libs;

import org.openqa.selenium.*;
import org.testng.Assert;


public class ActionEngine extends BrowserFactory {

    /*
     * Input Locator and String Text
     * Sending the value to the input field
     */
    public void sendValue(By locator, String elementValue) throws Exception {
        try {
            BrowserFactory.driver.findElement(locator).clear();
            BrowserFactory.driver.findElement(locator).sendKeys(elementValue);
            System.out.println("Successfully sending text: " + elementValue);
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    public WebElement getWebElement(By locator) throws Exception {
        WebElement ele = null;
        try {
            ele = BrowserFactory.driver.findElement(locator);
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
        return ele;
    }

    /*
     * Input Locator
     * Click using on Selenium click
     */
    public  void clickELE(By locator) throws Exception {
        try {
            BrowserFactory.driver.findElement(locator).click();
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
            WebElement ele = BrowserFactory.driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.driver;
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
    public String getElementText(By locator) throws Exception {
        String text = null;
        try {
            WebElement ele = BrowserFactory.driver.findElement(locator);
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
