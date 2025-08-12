package com.p2.custom.reports.components;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class RecentMovements {
    String fecha;
    String descripcion;
    String tipo;
    double monto;
    double saldoDespues;
}
