package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
Create the class LaptopsAndNotebooksTest
Write the following test
1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
1.1 Mouse hover on Laptops & Notebooks Tab.and click
1.2 Click on “Show All Laptops & Notebooks”
1.3 Select Sort By "Price (High > Low)"
1.4 Verify the Product price will arrange in High to Low order.
2. Test name verifyThatUserPlaceOrderSuccessfully()
2.1 Mouse hover on Laptops & Notebooks Tab and click
2.2 Click on “Show All Laptops & Notebooks”
2.3 Select Sort By "Price (High > Low)"
2.4 Select Product “MacBook”
2.5 Verify the text “MacBook”
2.6 Click on ‘Add To Cart’ button
2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
2.8 Click on link “shopping cart” display into success message
2.9 Verify the text "Shopping Cart"
2.10 Verify the Product name "MacBook"
2.11 Change Quantity "2"
2.12 Click on “Update” Tab
2.13 Verify the message “Success: You have modified your shopping cart!”
2.14 Verify the Total £737.45
2.15 Click on “Checkout” button
2.16 Verify the text “Checkout”
2.17 Verify the Text “New Customer”
2.18 Click on “Guest Checkout” radio button
2.19 Click on “Continue” tab
2.20 Fill the mandatory fields
2.21 Click on “Continue” Button
2.22 Add Comments About your order into text area
2.23 Check the Terms & Conditions check box
2.24 Click on “Continue” button
2.25 Verify the message “Warning: Payment method required!”
 */
public class LaptopsAndNotebooksTest extends TestBase {

    HomePage homePage = new HomePage();
    LaptopsAndNoteBooksPage laptopsAndNoteBooksPage =new LaptopsAndNoteBooksPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    MacBookPage macBookPage = new MacBookPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    //* 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {

        // * 1.1	Mouse hover on Laptops & Notebooks Tab.and click

        homePage.mouseHoverOnLaptopsAndNotebooksMenu();

        // * 1.2	Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        // * 1.3	Select Sort By "Price (High > Low)"
        laptopsAndNoteBooksPage.selectSortByPriceHighToLow("Price (High > Low)");

        // * 1.4	Verify the Product price will arrange in High to Low order.
        String actualPrice = laptopsAndNoteBooksPage.verifyProductPriceArrangeInHighToLow();
        String expectedPrice = "$2,000.00";
        String expectedMessage = expectedPrice + "\n" +
                "Ex Tax:" + expectedPrice;
        Assert.assertEquals(actualPrice, expectedMessage, "Incorrect price  order!");
    }

    @Test
    // * 2. Test name verifyThatUserPlaceOrderSuccessfully()
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        // 	Mouse hover on Currency Dropdown and click

        homePage.mouseHoverAndClickOnCurrencyDroDownMenu();

        // 	Mouse hover on £Pound Sterling and click

        homePage.selectOnSterlingPoundCurrency();

        // * 2.1	Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverOnLaptopsAndNotebooksMenu();

        // * 2.2	Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        // * 2.3	Select Sort By "Price (High > Low)"
        laptopsAndNoteBooksPage.selectSortByPriceHighToLow("Price (High > Low)");

        // * 2.4	Select Product “MacBook”
        laptopsAndNoteBooksPage.selectMacBookProducts();

        // * 2.5	Verify the text “MacBook”
        String actualText = macBookPage.verifyTheTextMacBook();
        String expectedText = "MacBook";
        Assert.assertEquals(actualText, expectedText, "Incorrect Product Text displayed!");

        // * 2.6	Click on ‘Add To Cart’ button
        macBookPage.clickOnAddToCart();

        // * 2.7	Verify the message “Success: You have added MacBook to your shopping cart!”
        String actualSuccessMessage = macBookPage.verifySuccessMessageForAddingProductToShoppingCart();
        String expectedSuccessMessage = "Success: You have added MacBook to your shopping cart!";
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Invalid Success Message!");

        // * 2.8	Click on link “shopping cart” display into success message
        macBookPage.clickOnLinkToShoppingCartMessage();

        // * 2.9	Verify the text "Shopping Cart"

        String actualCartText = shoppingCartPage.verifyTextForShoppingCart();
        String expectedCartText = "Shopping Cart  (0.00kg)";
        Assert.assertEquals(actualCartText, expectedCartText, "Incorrect Shopping Cart Message displayed!");

        // * 2.10	Verify the Product name "MacBook"
        String actualProductName = shoppingCartPage.verifyProductNameIsMacBook();
        String expectedProductName = "MacBook";
        Assert.assertEquals(actualProductName, expectedProductName, "Incorrect product Name displayed!");

        // * 2.11	Change Quantity "2"

        shoppingCartPage.clearTheQtyBox();

        shoppingCartPage.enterQuantityIntoTheBox("2");

        // * 2.12	Click on “Update” Tab
        shoppingCartPage.clickOnUpdateTheQuantityBox();

        // * 2.13	Verify the message “Success: You have modified your shopping cart!”
        String actualUpdatedMessage = shoppingCartPage.verifyUpdatedSuccessMessage();
        String expectedUpdatedMessage = "Success: You have modified your shopping cart!\n×";
        Assert.assertEquals(actualUpdatedMessage, expectedUpdatedMessage, "Incorrect updated message displayed!");

        // * 2.14	Verify the Total £737.45

        String actualTotalPrice = shoppingCartPage.verifyTotalPrice();
        String expectedTotalPrice = "£737.45";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Incorrect total price displayed!");

        // * 2.15	Click on “Checkout” button

        shoppingCartPage.clickOnCheckOutButton();

        // * 2.16	Verify the text “Checkout”

        String actualCheckOutText = checkOutPage.verifyCheckOutText();
        String expectedCheckOutText = "Checkout";
        Assert.assertEquals(actualCheckOutText, expectedCheckOutText, "Incorrect checkout text displayed!");

        // * 2.17	Verify the Text “New Customer”

        String actualNewCustomerText = checkOutPage.verifyTextNewCustomer();
        String expectedNewCustomerText = "New Customer";
        Assert.assertEquals(actualNewCustomerText, expectedNewCustomerText, "Incorrect new customer text displayed!");

        // * 2.18	Click on “Guest Checkout” radio button
        checkOutPage.clickOnGuestCheckOutButton();

        // * 2.19	Click on “Continue” tab
        checkOutPage.clickOnContinueButtonTab();

        // * 2.20	Fill the mandatory fields
        checkOutPage.enterFirstNameIntoTheFirstNameField("Mary");
        checkOutPage.enterLastNameIntoTheLastNameField("John");
        checkOutPage.enterEmailIntoTheEmailField("maryjohn@gmail.com");
        checkOutPage.enterTelephoneIntoTheTelephoneField("9184561234");
        checkOutPage.enterAddressIntoTheAddress1Field("2250 144th street");
        checkOutPage.enterCityIntoTheCityField("Tulsa");
        checkOutPage.enterPostcodeIntoThePostCodeField("71433");
        checkOutPage.enterCountryIntoTheCountryField("United States");
        checkOutPage.enterZoneIntoTheZoneField("Oklahoma");

        // * 2.21	Click on “Continue” Button
        checkOutPage.clickOnContinueButtonForGuest();

        // * 2.22	Add Comments About your order into text area
        checkOutPage.addCommentsAboutYourOrderIntoTheTextArea("Leave it by door please");

        // * 2.23	Check the Terms & Conditions check box
        checkOutPage.clickOnCheckBoxForTermsAndConditions();

        // * 2.24	Click on “Continue” button
        checkOutPage.clickOnContinueButtonForPaymentMethod();

        // * 2.25	Verify the message “Warning: Payment method required!”
        String actualWarningText = checkOutPage.verifyWarningMessageForPaymentMethod();
        String expectedWarningText = "Warning: Payment method required!\n×";
        Assert.assertEquals(actualWarningText, expectedWarningText, "Incorrect warning message displayed!");
    }
}
