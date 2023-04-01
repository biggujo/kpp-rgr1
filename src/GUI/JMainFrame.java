package GUI;

import edu.hws.jcm.data.Expression;
import edu.hws.jcm.data.Parser;
import edu.hws.jcm.data.Variable;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JMainFrame extends JFrame {

    private final JPanel panel;
    private final JPanelInput panelInput;
    private final JPanelUtility panelUtility;

    private final JPanelFreeChart panelFreeChart;

    private final Parser parser;
    private Expression function;
    private Expression derivative;
    private final Variable functionVar;
    private final Variable functionParam;

    public JMainFrame() {
        parser = new Parser(Parser.STANDARD_FUNCTIONS);

        functionVar = new Variable("x");
        functionParam = new Variable("a");
        parser.add(functionVar);
        parser.add(functionParam);

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(7, 7, 7, 7));
        panel.setLayout(new BorderLayout(0, 0));
        setContentPane(panel);

        panelInput = new JPanelInput();
        panelUtility = new JPanelUtility();

        panel.add(panelInput.getPanel(), BorderLayout.NORTH);
        panel.add(panelUtility.getPanel(), BorderLayout.SOUTH);

        panelFreeChart = new JPanelFreeChart();
        ChartPanel chartPanel = new ChartPanel(panelFreeChart.getChart());
        panel.add(chartPanel, BorderLayout.CENTER);

        renderChart();

        panelUtility.getButtonPlot().addActionListener(e -> {
            renderChart();
        });
    }

    private void renderChart() {
        function = parser.parse(panelInput.getFunctionText());
        derivative = function.derivative(functionVar);

        XYSeries seriesFunction = panelFreeChart.getSeriesFunction();
        XYSeries seriesDerivative = panelFreeChart.getSeriesDerivative();

        double start = panelInput.getStartXText();
        double end = panelInput.getEndXText();
        double step = panelInput.getStepXText();

        seriesFunction.clear();
        seriesDerivative.clear();

        double a = panelInput.getTextAText();

        for (double x = start; x < end; x += step) {
            seriesFunction.add(x, calcFunction(x, a));
        }

        for (double x = start; x < end; x += step) {
            seriesDerivative.add(x, calcDerivative(x, a));
        }
    }

    private double calcFunction(double x, double a) {
        functionVar.setVal(x);
        functionParam.setVal(a);
        return function.getVal();
    }

    private double calcDerivative(double x, double a) {
        functionVar.setVal(x);
        functionParam.setVal(a);
        return derivative.getVal();
    }
}