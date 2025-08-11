package com.p2.custom.reports.builders;

import com.p2.custom.reports.components.*;
import com.p2.custom.reports.report.BuilderReportXML;
import com.p2.custom.reports.report.Report;
import lombok.Getter;

@Getter
public class BuilderReport implements Builder {
    private Header reportCover;
    private StatisticalCharts statisticalCharts;
    private TableRecentMovements tableRecentMovements;
    private TrendAnalysis trendAnalysis;
    private Footer footer;

    @Override
    public Header setHeader(Header reportCover) {
        this.reportCover = reportCover;
        return reportCover;
    }

    @Override
    public StatisticalCharts setStatisticalCharts(StatisticalCharts statisticalCharts) {
        this.statisticalCharts = statisticalCharts;
        return statisticalCharts;
    }

    @Override
    public TableRecentMovements setTableRecentMovements(TableRecentMovements tableRecentMovements) {
        this.tableRecentMovements = tableRecentMovements;
        return tableRecentMovements;
    }

    @Override
    public TrendAnalysis setTrendAnalysis(TrendAnalysis trendAnalysis) {
        this.trendAnalysis = trendAnalysis;
        return trendAnalysis;
    }

    @Override
    public Footer setFooter(Footer footer) {
        this.footer = footer;
        return footer;
    }

    public Report getReport() {
        return new Report(reportCover, statisticalCharts, tableRecentMovements, trendAnalysis, footer);
    }

    public void builderReportXML(Report report) {
        BuilderReportXML reportXML = new BuilderReportXML();
        reportXML.reportXML(report);
    }
}
