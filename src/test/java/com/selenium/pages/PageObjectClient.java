package com.selenium.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by sudha on 08/10/2018.
 */
public class PageObjectClient extends PageObject{

    private final Logger logger = LoggerFactory.getLogger(PageObjectClient.class);

    protected void sendText(WebElement element, String text) {
        try {
            element(element).clear();
            logger.info("Cleaned up webelement " + element.getTagName());
            element(element).sendKeys(text);
            logger.info("Clicked webelement " + element.getTagName());
        } catch (Exception e) {
            logger.error("Error while sending text to webelement");
            throw e;
        }
    }

    protected void clickButton(WebElement button) {
        element(button).click();
    }

    protected void isElementInitialized(WebElement element) {
        element(element).isDisplayed();
    }

    protected String getTextFromElement(WebElement element) {
        return element(element).getText();
    }

    protected boolean isElementVisible(WebElement element) {
        return element(element).isVisible();
    }

    protected void waitForElement(WebElement element) {
        try {
            element(element).waitUntilVisible();
            logger.info("Webelement " + element.getTagName() + " successful founded");
        } catch (Exception e) {
            logger.error("Webelement not found in 5 second");
            throw e;
        }
    }

    protected void waitForElement(WebElement element, int second) {
        element(element).withTimeoutOf(second, TimeUnit.SECONDS).waitUntilVisible();
    }

    protected void openDropDownAndSelectOption(WebElement element, String option) {
        element(element).click();
        element.findElement(By.linkText(option)).click();
    }

    public void getElementAttribute(WebElement element , String attribute){
        element(element).getAttribute(attribute);

    }

    public void mouseOverClick(WebElement element){
        Actions act = new Actions(getDriver());
        act.moveToElement(element).click().build().perform();

    }
}
