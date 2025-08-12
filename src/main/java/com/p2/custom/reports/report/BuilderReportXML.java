package com.p2.custom.reports.report;

import com.p2.custom.reports.components.RecentMovements;
import com.p2.custom.reports.components.TrendAnalysis;
import com.p2.custom.reports.dto.StatisticalChartsDTO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BuilderReportXML {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void reportXML(Report report) {
        try {
            Document doc = createDocument();
            Element root = doc.createElement("report");
            doc.appendChild(root);

            addHeader(doc, root, report);
            addStatisticalCharts(doc, root, report.getStatisticalCharts() != null ? report.getStatisticalCharts().getInvestment() : null,
                    report.getStatisticalCharts() != null ? report.getStatisticalCharts().getSavings() : null);
            addRecentMovements(doc, root, report.getRecentMovements());
            addTendencies(doc, root, report.getTrendAnalysis());
            addFooter(doc, root, report);

            printDocument(doc);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private Document createDocument() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        return db.newDocument();
    }

    private void printDocument(Document doc) throws TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(new DOMSource(doc), new StreamResult(System.out));
    }

    private void addHeader(Document doc, Element parent, Report report) {
        if (report.getReportCover() == null) return;

        Element header = doc.createElement("header");
        parent.appendChild(header);

        appendTextElement(doc, header, "reportName", report.getReportCover().getReportTitle());
        appendTextElement(doc, header, "time", report.getReportCover().getDateTime().format(DATE_FORMAT));
    }

    private void addStatisticalCharts(Document doc, Element parent, List<StatisticalChartsDTO> investments, List<StatisticalChartsDTO> savings) {
        if ((investments == null || investments.isEmpty()) &&
                (savings == null || savings.isEmpty())) return;

        Element charts = doc.createElement("StatisticalCharts");
        parent.appendChild(charts);

        addChartCategory(doc, charts, "investment", investments);
        addChartCategory(doc, charts, "savings", savings);
    }

    private void addChartCategory(Document doc, Element parent, String categoryName, List<StatisticalChartsDTO> dataList) {
        if (dataList == null || dataList.isEmpty()) return;

        Element categoryElement = doc.createElement(categoryName);
        parent.appendChild(categoryElement);

        for (StatisticalChartsDTO chart : dataList) {
            Element monthElement = doc.createElement("month");
            monthElement.setAttribute("name", chart.getLabel());
            monthElement.setTextContent(String.valueOf(chart.getData()));
            categoryElement.appendChild(monthElement);
        }
    }

    private void addRecentMovements(Document doc, Element parent, List<RecentMovements> movements) {
        if (movements == null || movements.isEmpty()) return;

        Element recentMovements = doc.createElement("movements");
        parent.appendChild(recentMovements);

        for (RecentMovements movement : movements) {
            Element movementElement = doc.createElement("movement");
            recentMovements.appendChild(movementElement);

            appendTextElement(doc, movementElement, "fecha", movement.getFecha());
            appendTextElement(doc, movementElement, "descripcion", movement.getDescripcion());
            appendTextElement(doc, movementElement, "monto", String.valueOf(movement.getMonto()));
            appendTextElement(doc, movementElement, "saldoDespues", String.valueOf(movement.getSaldoDespues()));
        }
    }

    private void addTendencies(Document doc, Element parent, List<TrendAnalysis> tendencies) {
        if (tendencies == null || tendencies.isEmpty()) return;

        Element tendenciesElement = doc.createElement("tendencies");
        parent.appendChild(tendenciesElement);

        for (TrendAnalysis trend : tendencies) {
            Element trendElement = doc.createElement("trend");
            tendenciesElement.appendChild(trendElement);

            appendTextElement(doc, trendElement, "type", trend.getType());
            appendTextElement(doc, trendElement, "description", trend.getDescripcion());
        }
    }

    private void addFooter(Document doc, Element parent, Report report) {
        if (report.getFooter() == null) return;

        Element footer = doc.createElement("footer");
        parent.appendChild(footer);

        appendTextElement(doc, footer, "companyName", report.getFooter().getCompanyName());
        appendTextElement(doc, footer, "companyAddress", report.getFooter().getCompanyAddress());
        appendTextElement(doc, footer, "companyEmail", report.getFooter().getCompanyEmail());
        appendTextElement(doc, footer, "companyPhone", report.getFooter().getCompanyPhone());
    }

    private void appendTextElement(Document doc, Element parent, String name, String text) {
        Element element = doc.createElement(name);
        element.setTextContent(text != null ? text : "");
        parent.appendChild(element);
    }
}
