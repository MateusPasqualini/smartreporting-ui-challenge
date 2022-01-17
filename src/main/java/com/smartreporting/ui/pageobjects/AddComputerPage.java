package com.smartreporting.ui.pageobjects;

import com.smartreporting.ui.builder.Computer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddComputerPage extends BasePage {

    @FindBy(how = How.CSS, using = "#name")
    private WebElement computerNameField;

    @FindBy(how = How.CSS, using = "#introduced")
    private WebElement introducedDateField;

    @FindBy(how = How.CSS, using = "#discontinued")
    private WebElement discontinuedDateField;

    @FindBy(how = How.CSS, using = "#company")
    private WebElement companyDropDown;

    @FindBy(how = How.CSS, using = ".btn.primary")
    private WebElement createButton;

    @FindBy(how = How.CSS, using = ".alert-message.warning")
    private WebElement successfulAddAlert;

    public AddComputerPage(WebDriver driver) {
        super(driver);
    }

    public AddComputerPage addNewComputer(Computer computer) {
        waitForVisibilityOf(computerNameField).sendKeys(computer.getName());
        waitForVisibilityOf(introducedDateField).sendKeys(computer.getIntroducedDate());
        waitForVisibilityOf(discontinuedDateField).sendKeys(computer.getDiscontinuedDate());
        selectFromDropdown(companyDropDown).selectByVisibleText(computer.getCompany());
        waitForClickabilityOf(createButton).click();
        return this;
    }

    public String getAlertConfirmationText() {
        return waitForVisibilityOf(successfulAddAlert).getText();
    }


}
