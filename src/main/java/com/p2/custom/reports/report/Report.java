package com.p2.custom.reports.report;

import com.p2.custom.reports.components.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Report {
    private Header reportCover;
    private StatisticalCharts statisticalCharts;
    private List<Movement> movements;
    private List<Trend> trendAnalysis;
    private Footer footer;

    public Report(Header reportCover, StatisticalCharts statisticalCharts, List<Movement> movements, List<Trend> trendAnalysis, Footer footer) {
        this.reportCover = reportCover;

        if (statisticalCharts != null) {
            this.statisticalCharts = statisticalCharts;
        }

        if (movements != null) {
            this.movements = movements;
        }

        if (trendAnalysis != null) {
            this.trendAnalysis = trendAnalysis;
        }

        this.footer = footer;
    }
}
