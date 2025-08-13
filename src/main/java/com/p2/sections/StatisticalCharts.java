package com.p2.sections;

public class StatisticalCharts {
    private final String type;

    public StatisticalCharts(String type) {
        this.type = type;
    }

    public void mostrar() {
        System.out.println("[Gráficos] Tipo: " + type);
    }
}
