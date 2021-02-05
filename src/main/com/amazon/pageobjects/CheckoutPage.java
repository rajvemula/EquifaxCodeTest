package com.amazon.pageobjects;

import com.amazon.libs.ActionEngine;
import org.openqa.selenium.By;

public class CheckoutPage extends ActionEngine {

    //Check out Page - Elements
    public static By checkOutPrice = By.xpath("//*[@id='hlb-subcart']/div[1]/span/span[2]");
    public static By proceedToCheckout = By.xpath("//a[@id='hlb-ptc-btn-native']");

    public void checkOutItem() throws Exception {
        try {
            if (getWebElement(proceedToCheckout).isDisplayed()) {
                clickELE(proceedToCheckout);
                System.out.println("Successfully clicked on checkout in Checkout Page");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Unsuccessful click on checkout in Checkout Page");
        }

    }

}
