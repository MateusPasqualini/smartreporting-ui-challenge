package com.smartreporting.ui.factory;

import com.smartreporting.ui.builder.Computer;

public class ComputerDataFactory {
    public Computer createNewComputerData(String name, String introducedDate, String discontinuedDate, String company) {
        return Computer.builder().
                name(name).
                introducedDate(introducedDate).
                discontinuedDate(discontinuedDate).
                company(company).
                build();
    }
}
