package com.p2.custom.reports.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class StatisticalChartsDTO {
    private String label;
    private int data;
}
