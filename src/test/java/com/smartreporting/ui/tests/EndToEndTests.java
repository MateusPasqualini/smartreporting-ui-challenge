package com.smartreporting.ui.tests;

import com.smartreporting.ui.pageobjects.GeneratePage;
import com.smartreporting.ui.pageobjects.HomePage;
import com.smartreporting.ui.tests.basetest.BaseTest;
import org.testng.annotations.Test;

public class EndToEndTests extends BaseTest {

    @Test
    public void accessHomePage() {
        HomePage homePage = GeneratePage
                .homePage()
                .goToHomePage();
    }
}
