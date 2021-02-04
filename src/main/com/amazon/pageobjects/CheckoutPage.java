package com.amazon.pageobjects;

import org.openqa.selenium.By;

public class CheckoutPage {



    //Check out Page - Elements
    public static By checkOutPrice = By.xpath("//*[@id='hlb-subcart']/div[1]/span/span[2]");
    public static By proceedToCheckout = By.xpath("//a[@id='hlb-ptc-btn-native']");

}
