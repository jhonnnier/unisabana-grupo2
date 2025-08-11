package com.custom.reports;

import com.custom.reports.builders.BuilderReport;
import com.custom.reports.director.Director;
import com.custom.reports.report.Report;

public class Main {

    public static void main(String[] args) {
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
        director.buildReport1(reportBuilder);
        Report report = reportBuilder.getReport();
        reportBuilder.builderReportXML(report);

    }

    private static void buildReport2() {
        Director director = new Director();
        BuilderReport reportBuilder = new BuilderReport();
        director.buildReport2(reportBuilder);
        Report report = reportBuilder.getReport();
        reportBuilder.builderReportXML(report);
    }

    private static void buildReport3() {
        Director director = new Director();
        BuilderReport reportBuilder = new BuilderReport();
        director.buildReport3(reportBuilder);
        Report report = reportBuilder.getReport();
        reportBuilder.builderReportXML(report);
    }
}