package com.smartreporting.ui.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Computer {
    private String name;
    private String introducedDate;
    private String discontinuedDate;
    private String company;
}
