package com.p2.custom.reports.report;

import com.p2.custom.reports.dto.StatisticalChartsDTO;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class BuilderReportPDF {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void reportPDF(Report report) {
        printHeader(report);
        printStatisticalCharts(report);
        printMovements(report);
        printTrends(report);
        printFooter(report);
    }

    private void printHeader(Report report) {
        saltoLinea();
        if (report.getReportCover() == null) return;
        println(report.getReportCover().getReportTitle());
        println("Fecha: " + report.getReportCover().getDateTime().format(DATE_FORMAT));
    }

    private void printStatisticalCharts(Report report) {
        var stats = report.getStatisticalCharts();

        if (stats == null) return;

        var investments = stats.getInvestment();
        var savings = stats.getSavings();

        if (investments.isEmpty() && savings.isEmpty()) return;

        saltoLinea();
        println("------- " + stats.getTitle() + " -------");
        printChartSection("Ahorro", savings);
        printChartSection("Inversión", investments);
    }

    private void printChartSection(String title, List<StatisticalChartsDTO> items) {
        if (items.isEmpty()) return;
        saltoLinea();
        println(title);
        items.forEach(item -> println(item.getLabel() + " " + item.getData()));
    }

    private void printMovements(Report report) {
        var movements = report.getMovements();
        if (movements == null || movements.isEmpty()) return;

        saltoLinea();
        println("------- " + "Movimientos" + " -------");
        movements.forEach(m -> {
            saltoLinea();
            println("Fecha: " + m.getFecha());
            println("Tipo: " + m.getTipo());
            println("Descripción: " + m.getDescripcion());
            println("Monto: " + m.getMonto());
            println("Saldo después: " + m.getSaldoDespues());
        });
    }

    private void printTrends(Report report) {
        var trends = report.getTrendAnalysis();
        if (trends == null || trends.isEmpty()) return;

        saltoLinea();
        println("------- " + "Análisis de tendencias" + " -------");
        trends.forEach(t -> {
            saltoLinea();
            println("Tipo: " + t.getType());
            println("Descripción: " + t.getDescripcion());
        });
    }

    private void printFooter(Report report) {
        var footer = report.getFooter();
        if (footer == null) return;
        saltoLinea();
        println(footer.getCompanyName());
        println(footer.getCompanyAddress());
        println(footer.getCompanyEmail());
        println(footer.getCompanyPhone());
        saltoLinea();
    }

    private void println(String text) {
        System.out.println(text);
    }

    private void saltoLinea() {
        System.out.println();
    }
}
