package com.smartreporting.ui.pageobjects;

import com.smartreporting.ui.builder.Computer;
import com.smartreporting.ui.utils.commons.PropertiesManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    private static final String BASEURL = PropertiesManager.getInstance().getProperty("baseurl");

    @FindBy(how = How.CSS, using = "#add")
    private WebElement addNewComputerButton;

    @FindBy(how = How.CSS, using = "#searchbox")
    private WebElement filterComputerField;

    @FindBy(how = How.CSS, using = "#searchsubmit")
    private WebElement filterComputerButton;

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

    public HomePage filterComputerByName(Computer computer) {
        waitForVisibilityOf(filterComputerField).sendKeys(computer.getName());
        waitForClickabilityOf(filterComputerButton).click();
        return this;
    }

    public EditPage selectComputer(Computer computer) {
        driver.findElement(By.xpath("//*[contains(text(), \"" + computer.getName() + "\")]")).click();
        return GeneratePage.editPage();
    }

    public String getComputerName(Computer computer) {
        return driver.findElement(By.xpath("//*[contains(text(), \"" + computer.getName() + "\")]")).getText();
    }
}
