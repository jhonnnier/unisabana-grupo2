package com.custom.reports;

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
        ReportBuilder reportBuilder = new ReportBuilder();
        director.buildReport1(reportBuilder);
        Report report = reportBuilder.getReport();
        reportBuilder.print(report);

    }

    private static void buildReport2() {
        Director director = new Director();
        ReportBuilder reportBuilder = new ReportBuilder();
        director.buildReport2(reportBuilder);
        Report report = reportBuilder.getReport();
        reportBuilder.print(report);
    }

    private static void buildReport3() {
        Director director = new Director();
        ReportBuilder reportBuilder = new ReportBuilder();
        director.buildReport3(reportBuilder);
        Report report = reportBuilder.getReport();
        reportBuilder.print(report);
    }
}