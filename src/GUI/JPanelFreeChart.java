package GUI;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

import java.awt.*;

public class JPanelFreeChart {
    private final JFreeChart chart;
    private final XYSeries seriesFunction;
    private final XYSeries seriesDerivative;

    public JPanelFreeChart() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        seriesFunction = new XYSeries("Function");
        seriesDerivative = new XYSeries("Derivative");

        dataset.addSeries(seriesFunction);
        dataset.addSeries(seriesDerivative);

        chart = ChartFactory.createXYLineChart("", "X", "Y", dataset, PlotOrientation.VERTICAL, true, true, false);

        // Customization
        chart.setBackgroundPaint(Color.white);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
    }

    public JFreeChart getChart() {
        return chart;
    }

    public XYSeries getSeriesFunction() {
        return seriesFunction;
    }

    public XYSeries getSeriesDerivative() {
        return seriesDerivative;
    }
}
