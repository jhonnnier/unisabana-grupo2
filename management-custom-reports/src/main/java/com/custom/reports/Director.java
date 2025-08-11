package com.custom.reports;

import com.custom.reports.DTO.StatisticalChartsDTO;
import com.custom.reports.reportContent.Footer;
import com.custom.reports.reportContent.ReportCover;
import com.custom.reports.reportContent.StatisticalCharts;

import java.util.List;

public class Director {

    public void buildReport1(Builder builder) {
        builder.setReportCover(new ReportCover("Reporte detallado # 1"));
        builder.setStatisticalCharts(StatisticalCharts.builder()
                .title("Datos estadisticos")
                .investment(List.of(
                        new StatisticalChartsDTO("Ene", 35),
                        new StatisticalChartsDTO("Feb", 59),
                        new StatisticalChartsDTO("Mar", 80),
                        new StatisticalChartsDTO("Abr", 81),
                        new StatisticalChartsDTO("May", 56),
                        new StatisticalChartsDTO("Jun", 55),
                        new StatisticalChartsDTO("Jul", 40)
                )).savings(List.of(
                        new StatisticalChartsDTO("Ene", 10),
                        new StatisticalChartsDTO("Feb", 5),
                        new StatisticalChartsDTO("Mar", 8),
                        new StatisticalChartsDTO("Abr", 9),
                        new StatisticalChartsDTO("May", 0),
                        new StatisticalChartsDTO("Jun", 55),
                        new StatisticalChartsDTO("Jul", 40)
                ))
                .build()
        );
        builder.setFooter(getFooter());
    }

    public void buildReport2(Builder builder) {
        builder.setReportCover(new ReportCover("Reporte detallado # 2"));
        builder.setStatisticalCharts(StatisticalCharts.builder()
                .title("Datos estadisticos")
                .investment(List.of(
                        new StatisticalChartsDTO("Ene", 5),
                        new StatisticalChartsDTO("Feb", 10),
                        new StatisticalChartsDTO("Mar", 15),
                        new StatisticalChartsDTO("Abr", 20),
                        new StatisticalChartsDTO("May", 25),
                        new StatisticalChartsDTO("Jun", 30),
                        new StatisticalChartsDTO("Jul", 35)
                )).savings(List.of(
                        new StatisticalChartsDTO("Ene", 8),
                        new StatisticalChartsDTO("Feb", 0),
                        new StatisticalChartsDTO("Mar", 7),
                        new StatisticalChartsDTO("Abr", 5),
                        new StatisticalChartsDTO("May", 4),
                        new StatisticalChartsDTO("Jun", 6),
                        new StatisticalChartsDTO("Jul", 2)
                ))
                .build()
        );
        builder.setFooter(getFooter());
    }

    public void buildReport3(Builder builder) {
        builder.setReportCover(new ReportCover("Reporte detallado # 3"));
        builder.setStatisticalCharts(StatisticalCharts.builder()
                .title("Datos estadisticos")
                .investment(List.of(
                        new StatisticalChartsDTO("Ene", 40),
                        new StatisticalChartsDTO("Feb", 43),
                        new StatisticalChartsDTO("Mar", 46),
                        new StatisticalChartsDTO("Abr", 49),
                        new StatisticalChartsDTO("May", 52),
                        new StatisticalChartsDTO("Jun", 55),
                        new StatisticalChartsDTO("Jul", 58)
                )).savings(List.of(
                        new StatisticalChartsDTO("Ene", 15),
                        new StatisticalChartsDTO("Feb", 12),
                        new StatisticalChartsDTO("Mar", 5),
                        new StatisticalChartsDTO("Abr", 9),
                        new StatisticalChartsDTO("May", 10),
                        new StatisticalChartsDTO("Jun", 5),
                        new StatisticalChartsDTO("Jul", 8)
                ))
                .build()
        );
        builder.setFooter(getFooter());
    }

    private static Footer getFooter() {
        return Footer.builder()
                .companyName("Unisabana - Grupo 2")
                .companyEmail("unisabana.grupo.2@gmail.com")
                .companyAddress("Calle siempre viva 1")
                .companyPhone("310-1111111")
                .build();
    }
}
