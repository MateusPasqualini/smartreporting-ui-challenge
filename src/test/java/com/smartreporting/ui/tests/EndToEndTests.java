package com.smartreporting.ui.tests;

import com.smartreporting.ui.builder.Computer;
import com.smartreporting.ui.dataprovider.ComputerDataProvider;
import com.smartreporting.ui.pageobjects.AddComputerPage;
import com.smartreporting.ui.pageobjects.EditPage;
import com.smartreporting.ui.pageobjects.GeneratePage;
import com.smartreporting.ui.pageobjects.HomePage;
import com.smartreporting.ui.tests.basetest.BaseTest;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EndToEndTests extends BaseTest {

    @Test(dataProvider = "computerData", dataProviderClass = ComputerDataProvider.class)
    public void mustAddNewComputer(Computer computer) {
        AddComputerPage addComputerPage = GeneratePage
                .homePage()
                .goToHomePage()
                .goToAddComputer()
                .addNewComputer(computer);

        assertThat(addComputerPage.getAlertConfirmationText(), is("Done ! Computer " + computer.getName() + " has been created"));
    }

    @Test(dataProvider = "computerData", dataProviderClass = ComputerDataProvider.class)
    public void mustFilterComputerByName(Computer computer) {
        HomePage homePage = GeneratePage
                .homePage()
                .goToHomePage()
                .filterComputerByName(computer);

        assertThat(homePage.getComputerName(computer), is(computer.getName()));
    }

    @Test(dataProvider = "computerData", dataProviderClass = ComputerDataProvider.class)
    public void mustEditExistingComputer(Computer computer) {
        EditPage editPage = GeneratePage
                .homePage()
                .goToHomePage()
                .filterComputerByName(computer)
                .selectComputer(computer)
                .editComputer(computer);


        assertThat(editPage.getAlertConfirmationText(), is("Done ! Computer " + computer.getName() + " POWER has been updated"));
    }
}
