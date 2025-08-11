package com.p2.custom.reports.builders;

import com.p2.custom.reports.components.*;

public interface Builder {
    Header setHeader(Header reportCover);

    StatisticalCharts setStatisticalCharts(StatisticalCharts statisticalCharts);

    TableRecentMovements setTableRecentMovements(TableRecentMovements tableRecentMovements);

    TrendAnalysis setTrendAnalysis(TrendAnalysis trendAnalysis);

    Footer setFooter(Footer footer);
}
