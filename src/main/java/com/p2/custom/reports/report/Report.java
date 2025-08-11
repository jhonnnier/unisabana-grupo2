package com.p2.custom.reports.report;

import com.p2.custom.reports.components.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Report {
    private Header reportCover;
    private StatisticalCharts statisticalCharts;
    private TableRecentMovements tableRecentMovements;
    private TrendAnalysis trendAnalysis;
    private Footer footer;

    public Report(Header reportCover, StatisticalCharts statisticalCharts, TableRecentMovements tableRecentMovements, TrendAnalysis trendAnalysis, Footer footer) {
        this.reportCover = reportCover;

        if (statisticalCharts != null) {
            this.statisticalCharts = statisticalCharts;
        }

        if (tableRecentMovements != null) {
            this.tableRecentMovements = tableRecentMovements;
        }
        
        if (trendAnalysis != null) {
            this.trendAnalysis = trendAnalysis;
        }

        this.footer = footer;
    }
}
