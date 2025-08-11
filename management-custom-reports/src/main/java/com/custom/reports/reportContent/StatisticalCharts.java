package com.custom.reports.reportContent;

import com.custom.reports.DTO.StatisticalChartsDTO;
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
