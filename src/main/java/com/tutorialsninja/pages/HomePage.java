package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends Utility {


    // * 1.1	Mouse hover on “Desktops” Tab and click
    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {

        // * 1.2 This method should click on the menu whatever name is passed as parameter.
        WebElement menuList = driver.findElement(By.linkText(menu));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuList).click().build().perform();
    }

    By desktops = By.xpath("//a[normalize-space()='Desktops']");

    public void mouseHoverOnDesktopMenu() {
        mouseHoverToElement(desktops);
    }

    // * 1.3	Verify the text ‘Desktops’
    By desktopsText = By.xpath("//h2[normalize-space()='Desktops']");

    public String verifyTheTextDesktops() {
        return getTextFromElement(desktopsText);
    }



    // * 2.1	Mouse hover on “Laptops & Notebooks” Tab and click
    By laptopsAndNotebooks = By.xpath("//a[normalize-space()='Laptops & Notebooks']");


    public void mouseHoverOnLaptopsAndNotebooksMenu() {
        mouseHoverToElementAndClick(laptopsAndNotebooks);
    }

    // * 2.3	Verify the text ‘Laptops & Notebooks’
    By laptopsAndNotebooksText = By.xpath("//h2[normalize-space()='Laptops & Notebooks']");

    public String verifyTextForLaptopsAndNotebooks() {
        return getTextFromElement(laptopsAndNotebooksText);
    }



    // * 3.1	Mouse hover on “Components” Tab and click
    By components = By.xpath("//a[normalize-space()='Components']");

    public void mouseHoverOnComponentsMenu() {
        mouseHoverToElementAndClick(components);
    }

    // * 3.3	Verify the text ‘Components’
    By componentsText = By.xpath("//h2[contains(text(),'Components')]");

    public String verifyTextForComponents() {
        return getTextFromElement(componentsText);
    }



    // * 2.1	Mouse hover on Currency Dropdown and click
    By currencyDropDownMenu = By.xpath("//span[normalize-space()='Currency']");

    public void mouseHoverAndClickOnCurrencyDroDownMenu() {
        mouseHoverToElementAndClick(currencyDropDownMenu);
    }

    // * 2.2	Mouse hover on £Pound Sterling and click
    By sterlingPoundCurrency = By.xpath("//button[normalize-space()='£Pound Sterling']");

    public void selectOnSterlingPoundCurrency() {
        mouseHoverToElementAndClick(sterlingPoundCurrency);
    }


    // * 1.1	Click on My Account Link.
    By accountLink = By.xpath("//span[normalize-space()='My Account']");

    public void clickOnAccountLink() {
        clickOnElement(accountLink);
    }
}
