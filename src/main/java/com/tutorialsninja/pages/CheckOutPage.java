package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class CheckOutPage extends Utility {
    // * 2.16	Verify the text “Checkout”
    By checkOutText = By.xpath("//h1[normalize-space()='Checkout']");

    public String verifyCheckOutText() {
        return getTextFromElement(checkOutText);
    }

    // * 2.17	Verify the Text “New Customer”
    By checkNewCustomerText = By.xpath("//h2[normalize-space()='New Customer']");

    public String verifyTextNewCustomer() {
        return getTextFromElement(checkNewCustomerText);
    }

    // * 2.18	Click on “Guest Checkout” radio button
    By guestCheckoutButton = By.xpath("//input[@value='guest']");

    public void clickOnGuestCheckOutButton() {
        clickOnElement(guestCheckoutButton);
    }

    // * 2.19	Click on “Continue” tab
    By continueTabButton = By.cssSelector("#button-account");

    public void clickOnContinueButtonTab() {
        clickOnElement(continueTabButton);
    }

    // * 2.20	Fill the mandatory fields
    By firstName = By.id("input-payment-firstname");

    public void enterFirstNameIntoTheFirstNameField(String name) {
        sendTextToElement(firstName, name);
    }

    By lastName = By.id("input-payment-lastname");

    public void enterLastNameIntoTheLastNameField(String surname) {
        sendTextToElement(lastName, surname);
    }

    By emailAddress = By.id("input-payment-email");

    public void enterEmailIntoTheEmailField(String email) {
        sendTextToElement(emailAddress, email);
    }

    By telephone = By.id("input-payment-telephone");

    public void enterTelephoneIntoTheTelephoneField(String phone) {
        sendTextToElement(telephone, phone);
    }

    By addressField = By.id("input-payment-address-1");

    public void enterAddressIntoTheAddress1Field(String address) {
        sendTextToElement(addressField, address);
    }

    By cityName = By.id("input-payment-city");

    public void enterCityIntoTheCityField(String city) {
        sendTextToElement(cityName, city);
    }

    By zipCode = By.name("postcode");

    public void enterPostcodeIntoThePostCodeField(String postcode) {
        sendTextToElement(zipCode, postcode);
    }

    By countryName = By.id("input-payment-country");

    public void enterCountryIntoTheCountryField(String country) {
        selectVisibleTextFromDropDown(countryName, country);
    }

    By zoneName = By.id("input-payment-zone");

    public void enterZoneIntoTheZoneField(String zone) {
        selectVisibleTextFromDropDown(zoneName, zone);
    }

    // * 2.21	Click on “Continue” Button
    By continueButton = By.xpath("//input[@id='button-guest']");

    public void clickOnContinueButtonForGuest() {
        clickOnElement(continueButton);
    }

    // * 2.22	Add Comments About your order into text area
    By addCommentIn = By.xpath("//textarea[@name='comment']");

    public void addCommentsAboutYourOrderIntoTheTextArea(String comment) {
        sendTextToElement(addCommentIn, comment);
    }

    // * 2.23	Check the Terms & Conditions check box
    By termsAndConditions = By.cssSelector("input[value='1'][name='agree']");

    public void clickOnCheckBoxForTermsAndConditions() {
        clickOnElement(termsAndConditions);
    }

    // * 2.24	Click on “Continue” button
    By continueButtonForPayment = By.xpath("//input[@id='button-payment-method']");

    public void clickOnContinueButtonForPaymentMethod() {
        clickOnElement(continueButtonForPayment);
    }

    // * 2.25	Verify the message “Warning: Payment method required!”
    By checkWarningForPayment = By.xpath("//div[@class ='alert alert-danger alert-dismissible']");

    public String verifyWarningMessageForPaymentMethod() {
        return getTextFromElement(checkWarningForPayment);
    }
}
