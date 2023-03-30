package GUI;

import javax.swing.*;
import java.awt.*;

public class ApplicationGUI {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JMainFrame frame = new JMainFrame();

                frame.setSize(700, 600);
                frame.setResizable(false);

                frame.setTitle("Plot Calculator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
