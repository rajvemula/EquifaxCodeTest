package com.amazon.scripts;

import com.amazon.libs.ActionEngine;
import com.amazon.pageobjects.HomePage;
import com.amazon.pageobjects.AddToCartPage;
import com.amazon.pageobjects.SearchPpage;
import com.amazon.pageobjects.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Web_E2EScenario extends ActionEngine {

    @Test
    public void testScenario() throws Exception {
        driver.get(prop.getUrl());
        sendValue(HomePage.searchBar,"qa testing for beginners");
        clickELE(HomePage.searchIcon);
        clickELE(SearchPage.firstItem);
        Assert.assertEquals("$29.00",getElementText(HomePage.price));
        String price = getElementText(AddToCartPage.price);
        clickELE(AddToCartPage.btnAddtoCart);
        Assert.assertEquals(price,getElementText(CheckoutPage.checkOutPrice));
        clickELE(CheckoutPage.proceedToCheckout);
    }
}
