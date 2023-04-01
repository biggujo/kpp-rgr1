package GUI;

import javax.swing.*;
import java.awt.*;

public class JPanelInput {

    private final JPanel panel;

    private final JLabel labelFunctionName;
    private final JTextField textFieldFunction;

    private final JLabel labelStartX;
    private final JTextField textStartX;

    private final JLabel labelEndX;
    private final JTextField textEndX;

    private final JLabel labelStepX;
    private final JTextField textStepX;

    public JPanelInput() {
        Font plainFont = new Font("Courier New", Font.PLAIN, 14);
        Font boldFont = plainFont.deriveFont(Font.BOLD);

        panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setHgap(10);

        labelFunctionName = new JLabel("f(x) = ");
        labelFunctionName.setFont(boldFont);

        textFieldFunction = new JTextField();
        textFieldFunction.setText("sin(x)/x");
        textFieldFunction.setColumns(20);
        textFieldFunction.setFont(plainFont);

        labelStartX = new JLabel(" Start:");
        labelStartX.setFont(boldFont);

        textStartX = new JTextField();
        textStartX.setText("-6");
        textStartX.setColumns(6);
        textStartX.setFont(plainFont);

        labelEndX = new JLabel(" End:");
        labelEndX.setFont(boldFont);

        textEndX = new JTextField();
        textEndX.setText("6");
        textEndX.setColumns(6);
        textEndX.setFont(plainFont);

        labelStepX = new JLabel(" Step:");
        labelStepX.setFont(boldFont);

        textStepX = new JTextField();
        textStepX.setText("0.01");
        textStepX.setColumns(6);
        textStepX.setFont(plainFont);

        panel.add(labelFunctionName);
        panel.add(textFieldFunction);
        panel.add(labelStartX);
        panel.add(textStartX);
        panel.add(labelEndX);
        panel.add(textEndX);
        panel.add(labelStepX);
        panel.add(textStepX);
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getFunctionText() {
        return textFieldFunction.getText();
    }

    public double getStartXText() {
        return Double.parseDouble(textStartX.getText());
    }

    public double getEndXText() {
        return Double.parseDouble(textEndX.getText());
    }

    public double getStepXText() {
        return Double.parseDouble(textStepX.getText());
    }
}
