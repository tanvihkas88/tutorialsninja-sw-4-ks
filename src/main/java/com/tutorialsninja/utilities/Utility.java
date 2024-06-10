package com.tutorialsninja.utilities;

import com.google.common.base.Function;
import com.tutorialsninja.browserfactory.ManageBrowser;
import dev.failsafe.internal.util.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Utility extends ManageBrowser {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement elementLink = driver.findElement(by);
        elementLink.click();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will find the list of WebElements
     */
    public List<WebElement> findElementsList(By by) {
        return driver.findElements(by);
    }

    /**
     * This method will find one WebElement
     */

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }
    /**
     * This method will verify the actual and expected result
     */
//    public void assertEquals(By by, String expected, String message){
//        String actual = getTextFromElement(by);
//        Assert.assertEquals(actual, expected, "");
//    }

    /**
     * This method will verify text
     */
    public void verifyText(By by, String expectedText, String displayedMessage) {
        Assert.state(Boolean.parseBoolean(String.valueOf(by)), expectedText, displayedMessage);
    }

    public boolean isTextDisplayed(By by, String expectedText) {
        boolean actualText = (driver.findElement(by).getText()).contains(expectedText); // Find and get actual text on page and check whether it contains expected text or not?
        assert actualText : expectedText + "Text is not found";
        return true;
    }

    /**
     * This method will print List of element in Console
     */

    public void listOfProductsElement(By by, String text) {
        List<WebElement> listOfMenuElements = driver.findElements(by);
        for (WebElement element : listOfMenuElements) {
            System.out.println(element.getText());

            if (element.getText().trim().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
    }

    /**
     * This method will get the arraylist of our choice form dropdown menu list
     */

    public void getArrayListOfProductsInChoice(By by) {
        List<WebElement> products = findElementsList(by);

        ArrayList<String> actualSortByProduct = new ArrayList<>();
        for (WebElement element : products) {
            String[] array = element.getText().split("Ex Tax:");
            actualSortByProduct.add(String.valueOf(Double.valueOf(array[0].substring(1).replaceAll(",", ""))));
        }

        System.out.println("Before sorting: " + actualSortByProduct);
        Collections.sort(actualSortByProduct, Collections.reverseOrder());
        System.out.println("After sorting: " + actualSortByProduct);

        ArrayList<String> afterSortByProduct = new ArrayList<>(actualSortByProduct);

        System.out.println("Expected result: " + afterSortByProduct);

    }

    /**
     * This method will verify the ArrayList products and print the result
     */
    public String verifyTheProductArrangementInArrayList(By by) {
        System.out.println("Product List after sortBy: " + getTextFromElement(by));
        return getTextFromElement(by);
    }


//************************* Alert Methods *****************************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will accept alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss alert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get text from alert
     */
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * This method will send text from alert
     */
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

//*************************** Select Class Methods ***************************************//

    /**
     * This method will select the option by visible text
     */
    public void selectVisibleTextFromDropDown(By by, String text) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by value
     */
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    /**
     * This method will select the option by index
     */
    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
    }

    /**
     * This method will select the option by contains text
     */
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }
//*************************** Window Handle Methods ***************************************//

    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to rifgt window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }

    //*************************** Action Methods ***************************************//

    /**
     * This method will use to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This method will use to hover mouse on element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    //************************** Waits Methods *********************************************//

    /**
     * This method will use to wait until visibilityOfElementLocated
     */
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * This method is for fluentWait
     */
    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    //************************** ScreenShot Methods *********************************************//
    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }
    //************************** ArrayList Methods *********************************************//

    /**
     * This method will get arrayList from web elements
     */
    public ArrayList<String> getArrayListFromWebElements(List<WebElement> listOfElements) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (WebElement element : listOfElements) {
            arrayList.add(element.getText());
        }
        return arrayList;
    }

    /**
     * This method will clear the text field
     */
    public void clearTextField(By by) {
        driver.findElement(by).clear();
    }

    /**
     * This method will get currentUrl
     */

    public String getCurrentUrlForVerification() {
        return driver.getCurrentUrl();
    }
//**************************************** Date Picker Method   ********************************************************

    /**
     * This method will select the date from calendar
     */
    public void datePicker() {
        String year = "2025";
        String month = "November";
        String date = "27";
        clickOnElement(By.xpath("//span[@class = 'input-group-btn']//button[@class = 'btn btn-default']")); // open the calendar
        while (true) {
            //inspect April 2021
            String monthYear = getTextFromElement(By.xpath("//div[@class = 'datepicker-days']//th[@class = 'picker-switch']"));
            System.out.println(monthYear);
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker-days']//th[@class = 'next']"));
            }
        }
        // Select the date
        List<WebElement> allDates = driver.findElements(By.xpath("//tbody/tr/td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
    }

    public void selectDeliveryDate(String day, String month, String year) throws InterruptedException {
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
        clickOnElement(By.xpath("//span[normalize-space()='" + month + "']"));
        clickOnElement(By.xpath("//td[@class = 'day' and text() = '" + day + "']"));
    }
}
