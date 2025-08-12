package com.p2.custom.reports.builders;

import com.p2.custom.reports.components.*;

import java.util.List;

public interface Builder {
    Header setHeader(Header reportCover);

    StatisticalCharts setStatisticalCharts(StatisticalCharts statisticalCharts);

    List<RecentMovements> setRecentMovements(List<RecentMovements> recentMovements);

    List<TrendAnalysis> setTrendAnalysis(List<TrendAnalysis> trendAnalysis);

    Footer setFooter(Footer footer);
}
