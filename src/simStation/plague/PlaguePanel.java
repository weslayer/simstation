package simStation.plague;

import mvc.*;
import simStation.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PlaguePanel extends WorldPanel {

    public JPanel threadPanel = new JPanel();

    public PlaguePanel(PlagueFactory factory) {
        super(factory);

        threadPanel.setLayout(new GridLayout(5, 5));
        threadPanel.setOpaque(false);

        p = new JPanel();
        p.setOpaque(false);
        JLabel infected = new JLabel("Initial % Infected");
        p.add(infected);
        threadPanel.add(p, 2);

        JLabel probability = new JLabel("Infection Probability");
        JLabel population = new JLabel("Initial Population Size");
        JLabel recovery = new JLabel("Fatality/Recovery Time");

        JSlider infectedSlider = new JSlider(0, 100);
        JSlider probabilitySlider = new JSlider(0, 100);
        JSlider populationSlider = new JSlider(0, 200);
        JSlider recoverySlider = new JSlider(0, 500);
        JButton fatalButton = new JButton("Not Fatal");

        fatalButton.addActionListener(this);

        threadPanel.add(infectedSlider);
        threadPanel.add(probability);
        threadPanel.add(probabilitySlider);
        threadPanel.add(population);
        threadPanel.add(populationSlider);
        threadPanel.add(recovery);
        threadPanel.add(recoverySlider);
        threadPanel.add(fatalButton);

        controlPanel.setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.setOpaque(false);
        p.add(threadPanel);

        controlPanel.add(p, BorderLayout.NORTH);
    }

    public void setModel(Model m) {
        super.setModel(m);
        World w = (World) m;
        Iterator<Agent> it = w.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
    }
}
