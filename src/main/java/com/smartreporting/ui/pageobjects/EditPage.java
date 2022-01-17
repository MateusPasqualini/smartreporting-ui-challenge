package com.smartreporting.ui.pageobjects;

import com.smartreporting.ui.builder.Computer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditPage extends BasePage {
    @FindBy(how = How.CSS, using = "#name")
    private WebElement computerNameField;

    @FindBy(how = How.CSS, using = "#introduced")
    private WebElement introducedDateField;

    @FindBy(how = How.CSS, using = "#discontinued")
    private WebElement discontinuedDateField;

    @FindBy(how = How.CSS, using = "#company")
    private WebElement companyDropDown;

    @FindBy(how = How.CSS, using = ".btn.primary")
    private WebElement saveButton;

    @FindBy(how = How.CSS, using = ".alert-message.warning")
    private WebElement successfulAddAlert;

    public EditPage(WebDriver driver) {
        super(driver);
    }

    public EditPage editComputer(Computer computer) {
        waitForVisibilityOf(computerNameField).clear();
        waitForVisibilityOf(computerNameField).sendKeys(computer.getName() + " POWER");
        waitForVisibilityOf(introducedDateField).clear();
        waitForVisibilityOf(introducedDateField).sendKeys(computer.getIntroducedDate());
        waitForVisibilityOf(discontinuedDateField).sendKeys(computer.getDiscontinuedDate());
        selectFromDropdown(companyDropDown).selectByVisibleText(computer.getCompany());
        waitForClickabilityOf(saveButton).click();
        return this;
    }

    public String getAlertConfirmationText() {
        return waitForVisibilityOf(successfulAddAlert).getText();
    }
}
