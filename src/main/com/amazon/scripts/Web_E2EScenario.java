package com.amazon.scripts;

import com.amazon.libs.ActionEngine;
import com.amazon.pageobjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Web_E2EScenario extends ActionEngine {

    @Test
    public void testScenario() throws Exception {
        driver.get(prop.getUrl());
        sendValue(HomePage.searchBar,"qa testing for beginners");
        clickELE(HomePage.searchIcon);
        clickELE(HomePage.firstItem);
        Assert.assertEquals("$29.00",getElementText(HomePage.price));
        String price = getElementText(HomePage.price);
        clickELE(HomePage.btnAddtoCart);
        Assert.assertEquals(price,getElementText(HomePage.checkOutPrice));
        clickELE(HomePage.proceedToCheckout);
    }
}
