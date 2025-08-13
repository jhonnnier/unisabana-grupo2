package com.p2.builder;

import com.p2.reports.Report;

public interface ReportBuilder {
    void setHeader(String logo, String client);

    void setStatisticalCharts(String statisticalChartType);

    void setMovements(String[] movementsData);

    void setTrends(String trendsData);

    void setFooter(String footerData);

    Report getResult();
}
