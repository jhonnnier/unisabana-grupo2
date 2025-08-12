package com.p2.custom.reports.builders;

import com.p2.custom.reports.components.*;

import java.util.List;

public interface Builder {
    Header setHeader(Header header);

    StatisticalCharts setStatisticalCharts(StatisticalCharts statisticalCharts);

    List<Movement> setMovements(List<Movement> movements);

    List<Trend> setTrends(List<Trend> trendAnalysis);

    Footer setFooter(Footer footer);
}
