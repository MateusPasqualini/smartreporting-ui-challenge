package com.smartreporting.ui.pageobjects;

import com.smartreporting.ui.utils.commons.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    private static final String BASEURL = PropertiesManager.getInstance().getProperty("baseurl");

    @FindBy(how = How.CSS, using = "#add")
    private WebElement addNewComputerButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage() {
        driver.get(BASEURL);
        return this;
    }

    public AddComputerPage goToAddComputer() {
        waitForClickabilityOf(addNewComputerButton).click();
        return GeneratePage.addComputerPage();
    }
}
