package com.custom.reports;

import com.custom.reports.reportContent.*;

public class ReportBuilder implements Builder {
    private ReportCover reportCover;
    private StatisticalCharts statisticalCharts;
    private TableRecentMovements tableRecentMovements;
    private TrendAnalysis trendAnalysis;
    private Footer footer;

    public ReportCover getReportCover() {
        return reportCover;
    }

    @Override
    public ReportCover setReportCover(ReportCover reportCover) {
        this.reportCover = reportCover;
        return reportCover;
    }

    public StatisticalCharts getStatisticalCharts() {
        return statisticalCharts;
    }

    @Override
    public StatisticalCharts setStatisticalCharts(StatisticalCharts statisticalCharts) {
        this.statisticalCharts = statisticalCharts;
        return statisticalCharts;
    }

    public TableRecentMovements getTableRecentMovements() {
        return tableRecentMovements;
    }

    @Override
    public TableRecentMovements setTableRecentMovements(TableRecentMovements tableRecentMovements) {
        this.tableRecentMovements = tableRecentMovements;
        return tableRecentMovements;
    }

    public TrendAnalysis getTrendAnalysis() {
        return trendAnalysis;
    }

    @Override
    public TrendAnalysis setTrendAnalysis(TrendAnalysis trendAnalysis) {
        this.trendAnalysis = trendAnalysis;
        return trendAnalysis;
    }

    public Footer getFooter() {
        return footer;
    }

    @Override
    public Footer setFooter(Footer footer) {
        this.footer = footer;
        return footer;
    }

    public Report getReport() {
        return new Report(reportCover, statisticalCharts, tableRecentMovements, trendAnalysis, footer);
    }

    public void print(Report report) {
        ReportXML reportXML = new ReportXML();
        reportXML.reportXML(report);
    }
}
