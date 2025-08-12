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
    private List<RecentMovements> recentMovements;
    private List<TrendAnalysis> trendAnalysis;
    private Footer footer;

    public Report(Header reportCover, StatisticalCharts statisticalCharts, List<RecentMovements> movements, List<TrendAnalysis> trendAnalysis, Footer footer) {
        this.reportCover = reportCover;

        if (statisticalCharts != null) {
            this.statisticalCharts = statisticalCharts;
        }

        if (movements != null) {
            this.recentMovements = movements;
        }

        if (trendAnalysis != null) {
            this.trendAnalysis = trendAnalysis;
        }

        this.footer = footer;
    }
}
