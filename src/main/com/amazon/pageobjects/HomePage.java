package com.amazon.pageobjects;

import org.openqa.selenium.By;

public class HomePage {

    //Home Page Elements
    public static By searchBar = By.xpath("//input[@id='twotabsearchtextbox']");
    public static By searchIcon = By.xpath("//input[@value='Go']");

//    //Search Page - Elements
//    public static By firstItem = By.xpath("//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img");
//
//    //Add to Cart Page - Elements
//    public static By price = By.xpath("//span[@id='newBuyBoxPrice']");
//    public static By btnAddtoCart = By.xpath("//input[@id='add-to-cart-button']");
//
//    //Check out Page - Elements
//    public static By checkOutPrice = By.xpath("//*[@id='hlb-subcart']/div[1]/span/span[2]");
//    public static By proceedToCheckout = By.xpath("//a[@id='hlb-ptc-btn-native']");

}
