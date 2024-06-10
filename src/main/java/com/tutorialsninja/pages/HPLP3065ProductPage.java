package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class HPLP3065ProductPage extends Utility {
    //* 2.7	Verify the Text "HP LP3065"
    By checkProductHPLP3065 = By.xpath("//h1[normalize-space()='HP LP3065']");

    public String verifyTextOFHPLP3065() {
        return getTextFromElement(checkProductHPLP3065);
    }

    //* 2.8 Select Delivery Date "2025-11-27"
    By clearTheDate = By.xpath("//input[@id='input-option225']");

    public void clearTheDate() {
        clearTextField(clearTheDate);
    }

    By datePicker = By.xpath("//input[@id='input-option225']");

    public void datePickerForDelivery(String date) {
        sendTextToElement(datePicker, date);
    }

    public void selectDeliveryDate(String year, String month, String day) throws InterruptedException {
        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));
        clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@colspan='5']"));

        while (true) {
            String y = getTextFromElement(By.xpath("//div[@class='datepicker-months'] //th[@class='picker-switch']"));
            if (y.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-months']//th[@class='next'][contains(text(),'›')]"));
            }
        }
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[normalize-space()='" + month + "']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//td[@class = 'day' and text() = '" + day + "']"));
    }

    //* 2.9.Enter Qty "1” using Select class.
    By clearTheQtyBox = By.className("form-control");

    public void clearTheQtyBox() {
        clearTextField(clearTheQtyBox);
    }

    By enterQuantity = By.className("form-control");

    public void enterQuantityIntoTheBox(String qty) {
        sendTextToElement(enterQuantity, qty);
    }

    //* 2.10	Click on “Add to Cart” button
    By addToCart = By.id("button-cart");

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }

    //* 2.11	Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
    By successMessage = By.xpath("//body/div[@id='product-product']/div[1]");

    public String verifySuccessMessageForAddedProduct() {
        return getTextFromElement(successMessage);
    }

    //* 2.12	Click on link “shopping cart” display into success message
    By shoppingCartLink = (By.xpath("//a[normalize-space()='shopping cart']"));

    public void clickOnShoppingCartLinkIntoSuccessMessage() {
        clickOnElement(shoppingCartLink);
    }
}
