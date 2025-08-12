package com.p2.custom.reports.director;

import com.p2.custom.reports.builders.Builder;
import com.p2.custom.reports.components.*;
import com.p2.custom.reports.dto.StatisticalChartsDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Director {

    public void makeReport(Builder builder, int reportNumber) {

        if (!DEFAULT_TREND_ANALYSIS.containsKey(reportNumber) || !DEFAULT_RECENT_MOVEMENTS.containsKey(reportNumber)) {
            System.out.println("❌ No se encontró información para el reporte número: " + reportNumber);
            return;
        }
        
        builder.setHeader(new Header("Reporte detallado # " + reportNumber, LocalDateTime.now()));
        builder.setStatisticalCharts(
                StatisticalCharts.builder()
                        .title("Datos estadísticos")
                        .investment(INVESTMENTS.get(reportNumber))
                        .savings(SAVINGS.get(reportNumber))
                        .build()
        );
        builder.setMovements(DEFAULT_RECENT_MOVEMENTS.get(reportNumber));
        builder.setTrends(DEFAULT_TREND_ANALYSIS.get(reportNumber));
        builder.setFooter(DEFAULT_FOOTER);
    }

    private static final Map<Integer, List<StatisticalChartsDTO>> SAVINGS = Map.of(
            1, List.of(
                    new StatisticalChartsDTO("Ene", 10), new StatisticalChartsDTO("Feb", 5),
                    new StatisticalChartsDTO("Mar", 8), new StatisticalChartsDTO("Abr", 9),
                    new StatisticalChartsDTO("May", 0), new StatisticalChartsDTO("Jun", 55),
                    new StatisticalChartsDTO("Jul", 40)
            ),
            2, List.of(
                    new StatisticalChartsDTO("Ene", 8), new StatisticalChartsDTO("Feb", 0),
                    new StatisticalChartsDTO("Mar", 7), new StatisticalChartsDTO("Abr", 5),
                    new StatisticalChartsDTO("May", 4), new StatisticalChartsDTO("Jun", 6),
                    new StatisticalChartsDTO("Jul", 2)
            ),
            3, List.of(
                    new StatisticalChartsDTO("Ene", 15), new StatisticalChartsDTO("Feb", 12),
                    new StatisticalChartsDTO("Mar", 5), new StatisticalChartsDTO("Abr", 9),
                    new StatisticalChartsDTO("May", 10), new StatisticalChartsDTO("Jun", 5),
                    new StatisticalChartsDTO("Jul", 8)
            )
    );

    private static final Map<Integer, List<StatisticalChartsDTO>> INVESTMENTS = Map.of(
            1, List.of(
                    new StatisticalChartsDTO("Ene", 35), new StatisticalChartsDTO("Feb", 59),
                    new StatisticalChartsDTO("Mar", 80), new StatisticalChartsDTO("Abr", 81),
                    new StatisticalChartsDTO("May", 56), new StatisticalChartsDTO("Jun", 55),
                    new StatisticalChartsDTO("Jul", 40)
            ),
            2, List.of(
                    new StatisticalChartsDTO("Ene", 5), new StatisticalChartsDTO("Feb", 10),
                    new StatisticalChartsDTO("Mar", 15), new StatisticalChartsDTO("Abr", 20),
                    new StatisticalChartsDTO("May", 25), new StatisticalChartsDTO("Jun", 30),
                    new StatisticalChartsDTO("Jul", 35)
            ),
            3, List.of(
                    new StatisticalChartsDTO("Ene", 40), new StatisticalChartsDTO("Feb", 43),
                    new StatisticalChartsDTO("Mar", 46), new StatisticalChartsDTO("Abr", 49),
                    new StatisticalChartsDTO("May", 52), new StatisticalChartsDTO("Jun", 55),
                    new StatisticalChartsDTO("Jul", 58)
            )
    );

    private static final Map<Integer, List<Movement>> DEFAULT_RECENT_MOVEMENTS = Map.of(
            1,
            List.of(
                    new Movement("2025-08-15", "Pago venta de vehículo", "Depósito", 25_000_000, 30_000_000),
                    new Movement("2025-08-13", "Compra electrodoméstico", "Compra", -3_200_000, 5_000_000),
                    new Movement("2025-08-10", "Transferencia a cuenta de ahorros", "Transferencia", -1_000_000, 8_200_000),
                    new Movement("2025-08-09", "Ingreso por servicios profesionales", "Depósito", 2_500_000, 9_200_000),
                    new Movement("2025-08-07", "Pago tarjeta de crédito", "Pago", -1_500_000, 6_700_000),
                    new Movement("2025-08-06", "Depósito en ventanilla", "Depósito", 800_000, 8_200_000)
            ),
            2,
            List.of(
                    new Movement("2025-08-14", "Cobro alquiler mensual", "Depósito", 1_200_000, 1_800_000),
                    new Movement("2025-08-12", "Compra en tienda online", "Compra", -350_000, 600_000),
                    new Movement("2025-08-11", "Retiro cajero", "Retiro", -200_000, 950_000),
                    new Movement("2025-08-09", "Pago plan de telefonía", "Pago", -150_000, 1_150_000),
                    new Movement("2025-08-08", "Recarga tarjeta de transporte", "Pago", -60_000, 1_310_000),
                    new Movement("2025-08-05", "Ingreso por freelance", "Depósito", 500_000, 1_810_000)
            ),
            3,
            List.of(
                    new Movement("2025-08-16", "Pago dividendos", "Depósito", 3_000_000, 4_200_000),
                    new Movement("2025-08-15", "Compra en restaurante", "Compra", -180_000, 1_200_000),
                    new Movement("2025-08-14", "Transferencia internacional", "Depósito", 5_500_000, 6_700_000),
                    new Movement("2025-08-13", "Pago de seguro", "Pago", -450_000, 1_150_000),
                    new Movement("2025-08-12", "Retiro en ventanilla", "Retiro", -300_000, 1_450_000),
                    new Movement("2025-08-10", "Compra en supermercado", "Compra", -250_000, 1_750_000)
            )
    );

    private static final Map<Integer, List<Trend>> DEFAULT_TREND_ANALYSIS = Map.of(
            1,
            List.of(
                    new Trend("Mensual", "Ingreso alto por venta de vehículo en agosto"),
                    new Trend("Semanal", "Gasto promedio de $3,000,000 en artículos del hogar"),
                    new Trend("Variable", "Transferencias internas a cuentas de ahorro para inversión"),
                    new Trend("Ocasional", "Pagos puntuales de tarjetas de crédito"),
                    new Trend("Extraordinario", "Depósitos grandes por trabajos esporádicos")
            ),
            2,
            List.of(
                    new Trend("Mensual", "Ingreso fijo por cobro de arriendo"),
                    new Trend("Semanal", "Compras frecuentes en línea de bajo monto"),
                    new Trend("Quincenal", "Recarga recurrente de transporte público"),
                    new Trend("Variable", "Pequeños retiros de efectivo"),
                    new Trend("Ocasional", "Ingresos por proyectos freelance")
            ),
            3,
            List.of(
                    new Trend("Mensual", "Ingresos por dividendos de acciones"),
                    new Trend("Semanal", "Gastos moderados en restaurantes"),
                    new Trend("Variable", "Transferencias internacionales esporádicas"),
                    new Trend("Ocasional", "Pagos de seguros y primas"),
                    new Trend("Extraordinario", "Depósitos altos por rendimientos financieros")
            )
    );


    private static final Footer DEFAULT_FOOTER = Footer.builder()
            .companyName("Unisabana - Grupo 2")
            .companyEmail("unisabana.grupo.2@gmail.com")
            .companyAddress("Calle siempre viva 1")
            .companyPhone("310-1111111")
            .build();
}
