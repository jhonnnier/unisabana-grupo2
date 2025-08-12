package com.p2.custom.reports.builders;

import com.p2.custom.reports.components.*;
import com.p2.custom.reports.report.BuilderReportPDF;
import com.p2.custom.reports.report.BuilderReportXML;
import com.p2.custom.reports.report.Report;
import lombok.Getter;

import java.util.List;

@Getter
public class BuilderReport implements Builder {
    private Header header;
    private StatisticalCharts statisticalCharts;
    private List<Movement> movements;
    private List<Trend> trends;
    private Footer footer;

    @Override
    public Header setHeader(Header header) {
        this.header = header;
        return header;
    }

    @Override
    public StatisticalCharts setStatisticalCharts(StatisticalCharts statisticalCharts) {
        this.statisticalCharts = statisticalCharts;
        return statisticalCharts;
    }

    @Override
    public List<Movement> setMovements(List<Movement> movements) {
        this.movements = movements;
        return this.movements;
    }

    @Override
    public List<Trend> setTrends(List<Trend> trendAnalysis) {
        this.trends = trendAnalysis;
        return trendAnalysis;
    }

    @Override
    public Footer setFooter(Footer footer) {
        this.footer = footer;
        return footer;
    }

    public Report getReport() {
        return new Report(header, statisticalCharts, movements, trends, footer);
    }

    public void builderReportXML(Report report) {
        BuilderReportXML reportXML = new BuilderReportXML();
        reportXML.reportXML(report);
    }

    public void builderReportPDF(Report report) {
        BuilderReportPDF reportPDF = new BuilderReportPDF();
        reportPDF.reportPDF(report);
    }
}
