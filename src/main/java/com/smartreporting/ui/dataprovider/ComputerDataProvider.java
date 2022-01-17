package com.smartreporting.ui.dataprovider;

import com.smartreporting.ui.factory.ComputerDataFactory;
import org.testng.annotations.DataProvider;

public class ComputerDataProvider {

    @DataProvider
    public static Object[][] computerData() {
        return new Object[][]{
                {new ComputerDataFactory().createNewComputerData("Macintosh 128K", "1984-01-24", "1985-10-01", "Apple Inc.")}
        };
    }
}
