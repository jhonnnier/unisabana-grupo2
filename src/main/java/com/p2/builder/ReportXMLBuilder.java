package com.p2.builder;

import com.p2.reports.Report;
import com.p2.reports.XMLReport;
import com.p2.sections.*;

public class ReportXMLBuilder implements ReportBuilder {
    private Header header;
    private StatisticalCharts statisticalCharts;
    private Movements movements;
    private Trends trends;
    private Footer footer;

    @Override
    public void setHeader(String logo, String cliente) {
        header = new Header(logo + ".xml", cliente);
    }

    @Override
    public void setStatisticalCharts(String statisticalChartType) {
        statisticalCharts = new StatisticalCharts(statisticalChartType + " [XML]");
    }

    @Override
    public void setMovements(String[] movementsData) {
        movements = new Movements(movementsData);
    }

    @Override
    public void setTrends(String trendsData) {
        trends = new Trends(trendsData + " [XML]");
    }

    @Override
    public void setFooter(String footerData) {
        footer = new Footer(footerData + " [XML]");
    }

    @Override
    public Report getResult() {
        return new XMLReport(header, statisticalCharts, movements, trends, footer);
    }
}
