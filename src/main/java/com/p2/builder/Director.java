package com.p2.builder;

public class Director {
    public void buildFullReport(ReportBuilder builder) {
        builder.setHeader("logo.png", "Banco XYZ");
        builder.setStatisticalCharts("Inversión");
        builder.setMovements(new String[]{"Depósito $1000", "Retiro $500"});
        builder.setTrends("Crecimiento del 5% anual");
        builder.setFooter("asesor@unisabana.com");
    }

    public void buildBasicReport(ReportBuilder builder) {
        builder.setHeader("logo.png", "Banco XYZ");
        builder.setMovements(new String[]{"Depósito $1000"});
        builder.setTrends("Crecimiento del 1% anual");
        builder.setFooter("asesor@bancoxyz.com");
    }
}
