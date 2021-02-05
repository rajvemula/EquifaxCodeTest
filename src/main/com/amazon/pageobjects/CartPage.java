package com.amazon.pageobjects;

import com.amazon.libs.ActionEngine;
import org.openqa.selenium.By;

public class CartPage extends ActionEngine {

    //Add to Cart Page - Elements
    public static By price = By.xpath("//span[@id='newBuyBoxPrice']");
    public static By btnAddtoCart = By.xpath("//input[@id='add-to-cart-button']");

    /*
     *
     * This method will add the Item to the Cart
     */

    public void addtoCart() throws Exception {
        try{
        if(getWebElement(btnAddtoCart).isDisplayed()){
            clickELE(btnAddtoCart);
            System.out.println("Successfully clicked on Add to cart in Cart Page");
        }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Unsuccessful to click on Add to cart in Cart Page");
        }
    }
}
