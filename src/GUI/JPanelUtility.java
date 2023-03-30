package GUI;

import javax.swing.*;
import java.awt.*;

public class JPanelUtility extends JPanel {
    private final JPanel panel;
    private final JButton buttonPlot;
    private final JButton buttonExit;

    public JPanelUtility() {

        panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setHgap(10);

        buttonExit = new JButton("Exit");
        buttonExit.addActionListener(e -> System.exit(0));

        buttonPlot = new JButton("Plot");

        buttonExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonPlot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        panel.add(buttonPlot);
        panel.add(buttonExit);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getButtonPlot() {
        return buttonPlot;
    }
}
