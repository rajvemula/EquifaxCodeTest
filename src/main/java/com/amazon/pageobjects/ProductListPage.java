package com.amazon.pageobjects;

import com.amazon.libs.ActionEngine;
import org.openqa.selenium.By;

public class ProductListPage extends ActionEngine {
    //ProdcutListPage - Elements
    public static By firstItem = By.xpath("//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img");

    /*
     * Input is Locator
     * This method click's on first item
     */
    public void clickOnFirstItem() throws Exception {
        try {
            if (getWebElement(firstItem).isDisplayed()) {
                clickELE(firstItem);
                System.out.println("Successfully clicked on first item in Prodcuct List Page");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Unsuccessful to click on first item in Prodcuct List Page");

        }
    }
}
