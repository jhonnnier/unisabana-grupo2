package com.p2.builder;

import com.p2.reports.PDFReport;
import com.p2.reports.Report;
import com.p2.sections.*;

public class ReportPDFBuilder implements ReportBuilder {
    private Header header;
    private StatisticalCharts statisticalCharts;
    private Movements movements;
    private Trends trends;
    private Footer footer;

    @Override
    public void setHeader(String logo, String client) {
        header = new Header(logo, client);
    }

    @Override
    public void setStatisticalCharts(String statisticalChartType) {
        statisticalCharts = new StatisticalCharts(statisticalChartType);
    }

    @Override
    public void setMovements(String[] movementsData) {
        movements = new Movements(movementsData);
    }

    @Override
    public void setTrends(String trendsData) {
        trends = new Trends(trendsData);
    }

    @Override
    public void setFooter(String footerData) {
        footer = new Footer(footerData);
    }

    @Override
    public Report getResult() {
        return new PDFReport(header, statisticalCharts, movements, trends, footer);
    }
}
