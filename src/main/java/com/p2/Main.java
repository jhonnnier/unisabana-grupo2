package com.p2;

import com.p2.builder.*;
import com.p2.reports.Report;
import com.p2.builder.ReportXMLBuilder;
import com.p2.builder.ReportPDFBuilder;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        ReportBuilder pdfBuilder = new ReportPDFBuilder();
        director.buildFullReport(pdfBuilder);
        Report reportPDF = pdfBuilder.getResult();
        System.out.println("\n===== REPORTE PDF =====");
        reportPDF.show();

        ReportBuilder xmlBuilder = new ReportXMLBuilder();
        director.buildBasicReport(xmlBuilder);
        Report reportXML = xmlBuilder.getResult();
        System.out.println("\n===== REPORTE XML =====");
        reportXML.show();
    }
}
