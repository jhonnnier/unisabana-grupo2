package com.p2.reports;

import com.p2.sections.*;

public abstract class Report {
    private final Header header;
    private final StatisticalCharts statisticalCharts;
    private final Movements movements;
    private final Trends trends;
    private final Footer footer;

    Report(Header header,
           StatisticalCharts statisticalCharts,
           Movements movements,
           Trends trends,
           Footer footer) {
        this.header = header;
        this.statisticalCharts = statisticalCharts;
        this.movements = movements;
        this.trends = trends;
        this.footer = footer;
    }

    public void show() {
        if (header != null) header.mostrar();
        if (statisticalCharts != null) statisticalCharts.mostrar();
        if (movements != null) movements.mostrar();
        if (trends != null) trends.mostrar();
        if (footer != null) footer.mostrar();
    }
}
