package com.custom.reports;

import com.custom.reports.reportContent.*;

public interface Builder {
    ReportCover setReportCover(ReportCover reportCover);

    StatisticalCharts setStatisticalCharts(StatisticalCharts statisticalCharts);

    TableRecentMovements setTableRecentMovements(TableRecentMovements tableRecentMovements);

    TrendAnalysis setTrendAnalysis(TrendAnalysis trendAnalysis);

    Footer setFooter(Footer footer);
}
