package com.custom.reports.report;

import com.custom.reports.dto.StatisticalChartsDTO;
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
import java.util.List;

public class BuilderReportXML {
    public void reportXML(Report report) {
        try {
            // 1) Crear DocumentBuilder y Document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            // 2) Construir el XML
            // <REPORT>
            Element empresa = doc.createElement("report");
            doc.appendChild(empresa);

            // SECTION - <HEADER>
            Element encabezado = doc.createElement("header");
            empresa.appendChild(encabezado);

            Element tituloReporte = doc.createElement("reportName");
            tituloReporte.setTextContent(report.getReportCover().getReportTitle());
            encabezado.appendChild(tituloReporte);

            // SECTION - <STATISTICAL CHARTS>
            if (report.getStatisticalCharts() != null) {
                Element statisticalCharts = doc.createElement("StatisticalCharts");
                empresa.appendChild(statisticalCharts);

                addChartCategory(doc, statisticalCharts, "investment", report.getStatisticalCharts().getInvestment());
                addChartCategory(doc, statisticalCharts, "savings", report.getStatisticalCharts().getSavings());
            }

            // SECTION - <FOOTER>
            if (report.getFooter() != null) {
                Element footer = doc.createElement("footer");
                empresa.appendChild(footer);

                Element companyName = doc.createElement("companyName");
                companyName.setTextContent(report.getFooter().getCompanyName());
                footer.appendChild(companyName);

                Element companyAddress = doc.createElement("companyAddress");
                companyAddress.setTextContent(report.getFooter().getCompanyAddress());
                footer.appendChild(companyAddress);

                Element companyEmail = doc.createElement("companyEmail");
                companyEmail.setTextContent(report.getFooter().getCompanyEmail());
                footer.appendChild(companyEmail);

                Element companyPhone = doc.createElement("companyPhone");
                companyPhone.setTextContent(report.getFooter().getCompanyPhone());
                footer.appendChild(companyPhone);

            }

            // 3) Transformar el Document a XML y enviarlo a System.out (con indentación)
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            // Opciones de salida (pretty print)
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // propiedad para controlar cantidad de espacios de indentación (funciona en la implementación de Xalan/Apache)
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private void addChartCategory(Document doc, Element parent, String categoryName, List<StatisticalChartsDTO> dataList) {
        Element categoryElement = doc.createElement(categoryName);
        parent.appendChild(categoryElement);

        if (dataList != null && !dataList.isEmpty()) {
            for (StatisticalChartsDTO chart : dataList) {
                Element monthElement = doc.createElement("month");
                monthElement.setAttribute("name", chart.getLabel());
                monthElement.setTextContent(String.valueOf(chart.getData()));
                categoryElement.appendChild(monthElement);
            }
        }
    }
}
