package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

import java.util.UUID;

public class RegisterPage extends Utility {
    // * 1.3	Verify the text “Register Account”.
    By registerAccount = By.xpath("//h1[normalize-space()='Register Account']");

    public String verifyRegisterAccountText() {
        return getTextFromElement(registerAccount);
    }

    // * 2.3	Verify the text “Returning Customer”.
    By returningCustomerText = By.xpath("//h2[normalize-space()='Returning Customer']");

    public String verifyTextReturningCustomerOnLoginPage() {
        return getTextFromElement(returningCustomerText);
    }

    // * 3.3	Enter First Name
    By firstName = By.id("input-firstname");

    public void enterFirstName(String name) {
        sendTextToElement(firstName, name);
    }

    // * 3.4	Enter Last Name
    By lastName = By.id("input-lastname");

    public void enterLastName(String surname) {
        sendTextToElement(lastName, surname);
    }

    // * 3.5	Enter Email
    final String randomEmail = randomEmail();
    By email = By.id("input-email");

    public void enterEmail(String emailAddress) {
        sendTextToElement(email, emailAddress);
    }

    public static String randomEmail() {

        return "random-" + UUID.randomUUID().toString() + "@gmail.com";
    }

    // * 3.6	Enter Telephone
    By telephoneNumber = By.id("input-telephone");

    public void enterTelephoneNumber(String phone) {
        sendTextToElement(telephoneNumber, phone);
    }

    // * 3.7	Enter Password
    By passwordField = By.id("input-password");

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
    }

    // * 3.8	Enter Password Confirm
    By confirmPasswordField = By.xpath("//input[@id='input-confirm']");

    public void enterConfirmPassword(String confirmPassword) {
        sendTextToElement(confirmPasswordField, confirmPassword);
    }

    // * 3.9	Select Subscribe Yes radio button
    By subscribeRadioButton = By.xpath("//label[normalize-space()='Yes']");

    public void clickOnSubscribeRadioButton() {
        clickOnElement(subscribeRadioButton);
    }

    // * 3.10	Click on Privacy Policy check box
    By privacyCheckBox = By.cssSelector("input[value='1'][name='agree']");

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyCheckBox);
    }

    // * 3.11	Click on Continue button
    By continueButton = By.xpath("//input[@value='Continue']");

    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }

}
