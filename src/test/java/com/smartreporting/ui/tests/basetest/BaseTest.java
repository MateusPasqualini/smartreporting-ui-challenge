package com.smartreporting.ui.tests.basetest;

import com.smartreporting.ui.tests.listener.TestListener;
import com.smartreporting.ui.utils.drivers.TLDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest {
    private static final Object lock = new Object();

    @BeforeClass(description = "Downloading and Setting browser drivers")
    @Parameters(value = {"driverClass"})
    public void setupDrivers(String driverClass) {
        if (driverClass.equals("ChromeDriver")) {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        } else if (driverClass.equals("FirefoxDriver")) {
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        }
    }


    @BeforeMethod(description = "Configuring drivers")
    @Parameters(value = {"browser"})
    public void setup(@Optional String browser) {
        synchronized (lock) {
            TLDriverFactory.setTLDriver(browser);
        }
    }

    @AfterMethod(description = "Quitting drivers and removing ThreadLocal variables")
    public void teardown() {
        synchronized (lock) {
            TLDriverFactory.getTLDriver().quit();
            TLDriverFactory.flushTLDriver();
        }
    }

    public WebDriver getDriver() {
        return TLDriverFactory.getTLDriver();
    }

}
