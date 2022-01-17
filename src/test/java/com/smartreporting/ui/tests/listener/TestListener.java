package com.smartreporting.ui.tests.listener;


import com.smartreporting.ui.tests.basetest.BaseTest;
import com.smartreporting.ui.utils.drivers.TLDriverFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestListener extends TestListenerAdapter {

    private static final Logger logger = Logger.getLogger(TestListener.class.getName());


    @Attachment(value = "generate Screenshot", type = "image")
    private byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) TLDriverFactory.getTLDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        if (driver != null) {
            logger.log(Level.INFO, "Screenhsot Captured");
            saveScreenshotPNG();
        }
    }

}
