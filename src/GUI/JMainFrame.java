package GUI;

import edu.hws.jcm.data.Expression;
import edu.hws.jcm.data.Parser;
import edu.hws.jcm.data.Variable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JMainFrame extends JFrame {

    private JPanel panel;
    private JPanelInput panelInput;
    private JPanelUtility panelUtility;

    private JFreeChart chart;
    private XYSeries seriesFunction;
    private XYSeries seriesDerivative;

    private Parser parser;
    private Expression function;
    private Expression derivative;
    private Variable functionVar;

    public JMainFrame() {
        parser = new Parser(Parser.STANDARD_FUNCTIONS);

        functionVar = new Variable("x");
        parser.add(functionVar);

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(7, 7, 7, 7));
        panel.setLayout(new BorderLayout(0, 0));
        setContentPane(panel);

        panelInput = new JPanelInput();
        panelUtility = new JPanelUtility();

        panel.add(panelInput.getPanel(), BorderLayout.NORTH);
        panel.add(panelUtility.getPanel(), BorderLayout.SOUTH);

        JFreeChart chart = createChart();
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel, BorderLayout.CENTER);

        panelUtility.getButtonPlot().addActionListener(e -> {
            renderChart();
        });
    }

    private JFreeChart createChart() {
        XYSeriesCollection dataset = new XYSeriesCollection();

        seriesFunction = new XYSeries("Function");
        seriesDerivative = new XYSeries("Derivative");

        dataset.addSeries(seriesFunction);
        dataset.addSeries(seriesDerivative);

        renderChart();

        chart = ChartFactory.createXYLineChart("", "X", "Y", dataset, PlotOrientation.VERTICAL, true, true, false);

        // Customization
        chart.setBackgroundPaint(Color.white);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        return chart;
    }

    private void renderChart() {
        function = parser.parse(panelInput.getFunctionText());
        derivative = function.derivative(functionVar);

        double start = panelInput.getStartXText();
        double end = panelInput.getEndXText();
        double step = panelInput.getStepXText();

        seriesFunction.clear();
        seriesDerivative.clear();

        for (double x = start; x < end; x += step) {
            seriesFunction.add(x, calcFunction(x));
        }

        for (double x = start; x < end; x += step) {
            seriesDerivative.add(x, calcDerivative(x));
        }
    }

    private double calcFunction(double x) {
        functionVar.setVal(x);
        return function.getVal();
    }

    private double calcDerivative(double x) {
        functionVar.setVal(x);
        return derivative.getVal();
    }
}