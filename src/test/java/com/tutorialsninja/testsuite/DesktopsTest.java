package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.HPLP3065ProductPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.ShoppingCartPage;
import com.tutorialsninja.testbase.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Create class “DesktopsTest”
Write the following Test:
1.Test name verifyProductArrangeInAlphaBaticalOrder()
1.1 Mouse hover on Desktops Tab.and click
1.2 Click on “Show All Desktops”
1.3 Select Sort By position "Name: Z to A"
1.4 Verify the Product will arrange in Descending order.
2. Test name verifyProductAddedToShoppingCartSuccessFully()
2.1 Mouse hover on Currency Dropdown and click
2.2 Mouse hover on £Pound Sterling and click
2.3 Mouse hover on Desktops Tab.
2.4 Click on “Show All Desktops”
2.5 Select Sort By position "Name: A to Z"
2.6 Select product “HP LP3065”
2.7 Verify the Text "HP LP3065"
2.8 Select Delivery Date "2023-11-27"
2.9.Enter Qty "1” using Select class.
2.10 Click on “Add to Cart” button
2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
2.12 Click on link “shopping cart” display into success message
2.13 Verify the text "Shopping Cart"
2.14 Verify the Product name "HP LP3065"
2.15 Verify the Delivery Date "2023-11-27"
2.16 Verify the Model "Product21"
2.17 Verify the Todat "£74.73"
 */
public class DesktopsTest extends TestBase {

    HomePage homePage = new HomePage();
    DesktopsPage desktopsPage = new DesktopsPage();
    HPLP3065ProductPage hplp3065ProductPage = new HPLP3065ProductPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @Test

    //1.Test name verifyProductArrangeInAlphabeticalOrder()

    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        // * 1.1    Mouse hover on Desktops Tab.and click
        Thread.sleep(2000);
        homePage.mouseHoverOnDesktopMenu();

        // * 1.2    Click on “Show All Desktops”
        Thread.sleep(2000);
        homePage.selectMenu("Show AllDesktops");

        // * 1.3    Select Sort By position "Name: Z to A"
        List<WebElement> allList = desktopsPage.getAllProductsTitleOnPage();
        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement list : allList) {
            actualList.add(list.getText());
        }
        System.out.println(actualList);

        Collections.reverse(actualList);
        System.out.println(actualList);

        desktopsPage.sortByFilterOption("Name (Z - A)");
        Thread.sleep(2000);
        ArrayList<String> sortedList = new ArrayList<>();
        allList = desktopsPage.getAllProductsTitleOnPage();
        for (WebElement list : allList) {
            sortedList.add(list.getText());
        }
        // * 1.4    Verify the Product will arrange in Descending order.
        Assert.assertEquals(actualList, sortedList);
    }

    @Test

    // * 2. Test name verifyProductAddedToShoppingCartSuccessFully()

    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        // * 2.1    Mouse hover on Currency Dropdown and click

        homePage.mouseHoverAndClickOnCurrencyDroDownMenu();

        // * 2.2    Mouse hover on £Pound Sterling and click

        homePage.selectOnSterlingPoundCurrency();

        // * 2.3    Mouse hover on Desktops Tab.

        homePage.mouseHoverOnDesktopMenu();

        // * 2.4    Click on “Show All Desktops”

        homePage.selectMenu("Show AllDesktops");

        // * 2.5    Select Sort By position "Name: A to Z"
        desktopsPage.sortByFilterOption("Name (A - Z)");


        // * 2.6    Select product “HP LP3065”

        desktopsPage.clickOnHPLP3065Product();

        // * 2.7    Verify the Text "HP LP3065"
        String actualText = hplp3065ProductPage.verifyTextOFHPLP3065();
        String expectedText = "HP LP3065";
        Assert.assertEquals(actualText, expectedText, "Incorrect Product Name displayed!");

        // 2.8 Select Delivery Date "2025-11-27"
        //datePicker();
        hplp3065ProductPage.clearTheDate();

        hplp3065ProductPage.datePickerForDelivery("2024-10-15");

        // * 2.9.Enter Qty "1” using Select class.

        hplp3065ProductPage.clearTheQtyBox();

        hplp3065ProductPage.enterQuantityIntoTheBox("1");

        // * 2.10   Click on “Add to Cart” button

        hplp3065ProductPage.clickOnAddToCart();

        // * 2.11   Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String actualSuccessMessage = hplp3065ProductPage.verifySuccessMessageForAddedProduct();
        String expectedSuccessMessage = "Success: You have added HP LP3065 to your shopping cart!\n×";
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Incorrect Product Name displayed!");


        // * 2.12   Click on link “shopping cart” display into success message
        hplp3065ProductPage.clickOnShoppingCartLinkIntoSuccessMessage();

        // * 2.13   Verify the text "Shopping Cart"

        String actualCartText = shoppingCartPage.verifyTextForShoppingCart();
        String expectedCartText = "Shopping Cart  (1.00kg)";
        Assert.assertEquals(actualCartText, expectedCartText, "Incorrect Shopping Cart Message displayed!");

        // * 2.14   Verify the Product name "HP LP3065"

        String actualProductName = shoppingCartPage.verifyProductNameIsHPLP3065();
        String expectedProductName = "HP LP3065";
        Assert.assertEquals(actualProductName, expectedProductName, "Incorrect Product Name displayed!");

        // * 2.15   Verify the Delivery Date "2023-11-27"

        String actualDeliveryDate = shoppingCartPage.verifyDeliveryDateOfProduct();
        String expectedDeliveryDate = "Delivery Date:2025-11-27";
        Assert.assertEquals(actualDeliveryDate, expectedDeliveryDate, "Incorrect Delivery Date displayed!");

        // * 2.16   Verify the Model "Product21"

        String actualProductModel = shoppingCartPage.verifyModelNumberOfProduct();
        String expectedProductModel = "Product 21";
        Assert.assertEquals(actualProductModel, expectedProductModel, "Incorrect Product Model displayed!");

        // * 2.17   Verify the Total "£74.73"

        String actualTotalPrice = shoppingCartPage.verifyTotalPriceOfProduct();
        String expectedTotalPrice = "£74.73";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Incorrect Product Price displayed!");
    }
}
