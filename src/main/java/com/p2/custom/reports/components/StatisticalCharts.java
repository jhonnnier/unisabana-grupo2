package com.p2.custom.reports.components;

import com.p2.custom.reports.dto.StatisticalChartsDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Builder
@AllArgsConstructor
public class StatisticalCharts {
    String title;
    List<StatisticalChartsDTO> investment;
    List<StatisticalChartsDTO> savings;
}
