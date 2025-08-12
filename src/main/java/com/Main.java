package com;

import com.p2.custom.reports.builders.BuilderReport;
import com.p2.custom.reports.director.Director;
import com.p2.custom.reports.report.Report;

public class Main {

    public static void main(String[] args) {
        customReports();
    }

    private static void customReports() {
        System.out.println("---------------------------------------------------------------");
        buildReport1();
        System.out.println("---------------------------------------------------------------");
        buildReport2();
        System.out.println("---------------------------------------------------------------");
        buildReport3();
        System.out.println("---------------------------------------------------------------");
    }

    private static void buildReport1() {
        Director director = new Director();
        BuilderReport reportBuilder = new BuilderReport();
        director.buildReport(reportBuilder, 1);
        Report report = reportBuilder.getReport();
//        reportBuilder.builderReportXML(report);
        reportBuilder.builderReportPDF(report);
    }

    private static void buildReport2() {
        Director director = new Director();
        BuilderReport reportBuilder = new BuilderReport();
        director.buildReport(reportBuilder, 4);
        Report report = reportBuilder.getReport();
//        reportBuilder.builderReportXML(report);
        reportBuilder.builderReportPDF(report);
    }

    private static void buildReport3() {
        Director director = new Director();
        BuilderReport reportBuilder = new BuilderReport();
        director.buildReport(reportBuilder, 3);
        Report report = reportBuilder.getReport();
//        reportBuilder.builderReportXML(report);
        reportBuilder.builderReportPDF(report);
    }
}