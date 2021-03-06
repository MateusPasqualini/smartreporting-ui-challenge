package com.smartreporting.ui.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;


    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement waitForVisibilityOf(WebElement element) {
        wait.until(webDriver -> element.isDisplayed());
        return element;
    }


    public WebElement waitForClickabilityOf(WebElement element) {
        wait.until(driverLambda -> element.isDisplayed() && element.isEnabled());
        return element;
    }

    public WebElement waitForAvailabilityOfFrame(WebElement element) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        return element;
    }


    public Select selectFromDropdown(WebElement element) {
        return new Select(element);
    }

    public Alert waitForAlertAvailability() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }//*[contains(text(), "")]

    public List<WebElement> waitForClickabilityOf(List<WebElement> elements) {
        elements.forEach(element -> wait.until(driverLambda -> element.isDisplayed() && element.isEnabled()));
        return elements;
    }

    public WebElement waitForClickabilityOf(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
        return driver.findElement(elementBy);
    }

    public WebElement waitForVisibilityOf(By elementBy) {
        wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
        return driver.findElement(elementBy);
    }
}