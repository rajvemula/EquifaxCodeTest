package com.amazon.pageobjects;

import com.amazon.libs.ActionEngine;
import org.openqa.selenium.By;

public class HomePage extends ActionEngine {

    //Home Page Elements
    public static By searchBar = By.xpath("//input[@id='twotabsearchtextbox']");
    public static By searchIcon = By.xpath("//input[@value='Go']");

    /*
     * Input String Search Item
     * This method will enter the element name and Click's search icon
     */
    public void searchItem(String itemName) throws Exception {
        try {
            if (getWebElement(searchBar).isDisplayed() && getWebElement(searchIcon).isDisplayed()) {
                sendValue(searchBar, itemName);
                clickELE(searchIcon);
                System.out.println("Successfully Item is searched in Home Page");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Unable search the item in Home Page");
        }
    }

}
