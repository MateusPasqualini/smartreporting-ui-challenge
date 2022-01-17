package com.smartreporting.ui.pageobjects;


import com.smartreporting.ui.utils.drivers.TLDriverFactory;
import org.openqa.selenium.support.PageFactory;

public class GeneratePage {

    private GeneratePage() {
        throw new IllegalStateException("GeneratePage cannot be instantiated");
    }

    private static synchronized <T extends BasePage> T instantiateNewPage(Class<T> tClass) {
        return PageFactory.initElements(TLDriverFactory.getTLDriver(), tClass);
    }

    public static HomePage homePage() {
        return instantiateNewPage(HomePage.class);
    }

}
