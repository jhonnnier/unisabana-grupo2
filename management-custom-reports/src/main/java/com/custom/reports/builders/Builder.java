package com.custom.reports.builders;

import com.custom.reports.components.*;

public interface Builder {
    ReportCover setReportCover(ReportCover reportCover);

    StatisticalCharts setStatisticalCharts(StatisticalCharts statisticalCharts);

    TableRecentMovements setTableRecentMovements(TableRecentMovements tableRecentMovements);

    TrendAnalysis setTrendAnalysis(TrendAnalysis trendAnalysis);

    Footer setFooter(Footer footer);
}
