package com.amazon.scripts;

import com.amazon.libs.ActionEngine;
import com.amazon.pageobjects.CartPage;
import com.amazon.pageobjects.CheckoutPage;
import com.amazon.pageobjects.HomePage;
import com.amazon.pageobjects.ProductListPage;
import com.amazon.utilities.PropertyFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Web_E2EScenario extends ActionEngine {
    HomePage homePage = new HomePage();
    ProductListPage productListPage = new ProductListPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void testScenario() throws Exception {
        homePage.searchItem(prop.getSearchTerm().toString());
        productListPage.clickOnFirstItem();
        Assert.assertEquals("$29.00",getElementText(CartPage.price));
        String price = getElementText(CartPage.price);
        cartPage.addtoCart();
        Assert.assertEquals(price,getElementText(checkoutPage.checkOutPrice));
        checkoutPage.checkOutItem();
    }
}
