package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;

public class MyAccountPage extends Utility {

    // * 3.12	Verify the message “Your Account Has Been Created!”
    By accountCreation = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");

    public String verifyTheMessageYourAccountHasBeenCreated() {
        return getTextFromElement(accountCreation);
    }

    // * 3.13	Click on Continue button
    By continueAccountButton = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");

    public void clickOnContinueAccountButton() {
        clickOnElement(continueAccountButton);
    }

    // * 3.16	Verify the text “Account Logout”
    By accountLogOutText = By.xpath("//a[normalize-space()='Logout']");

    public String verifyTextForAccountLogOut() {
        return getTextFromElement(accountLogOutText);
    }

    // * 3.17	Click on Continue button
    By continueLogOutButton = By.xpath("//a[normalize-space()='Continue']");

    public void clickOnContinueLogOutButton() {
        clickOnElement(continueLogOutButton);
    }

    // * 4.6	Click on Login button
    By loginButton = By.xpath("//input[@value='Login']");

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    // * 4.7	Verify text “My Account”
    By checkTextForMyAccount = By.xpath("//h2[normalize-space()='My Account']");

    public String verifyTheTextMyAccount() {
        return getTextFromElement(checkTextForMyAccount);
    }
}
