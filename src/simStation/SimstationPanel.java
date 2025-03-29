package simStation;

import java.awt.*;
import javax.swing.*;
import mvc.*;

public class SimstationPanel extends AppPanel {
    private JButton start;
    private JButton pause;
    private JButton resume;
    private JButton stop;
    private JButton stats;

    public SimstationPanel(AppFactory factory) {
        super(factory);
        start = new JButton("Start");
        pause = new JButton("Pause");
        resume = new JButton("Resume");
        stop = new JButton("Stop");
        stats = new JButton("Stats");
    }

    public static void main(String[] args) {
        AppFactory factory = new SimstationFactory();
        AppPanel panel = new SimstationPanel(factory);
        panel.display();
    }
}
