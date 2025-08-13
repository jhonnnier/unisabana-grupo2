package com.p2.reports;

import com.p2.sections.*;

public class XMLReport extends Report {
    public XMLReport(Header header,
                     StatisticalCharts statisticalCharts,
                     Movements movements,
                     Trends trends,
                     Footer footer) {
        super(header, statisticalCharts, movements, trends, footer);
    }
}