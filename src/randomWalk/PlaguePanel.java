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

        JLabel infected = new JLabel("Initial % Infected");
        JLabel probability = new JLabel("Infection Probability");
        JLabel population = new JLabel("Initial Population Size");
        JLabel recovery = new JLabel("Fatality/Recovery Time");

        JSlider infectedSlider = new JSlider(0, 100);
        JSlider probabilitySlider = new JSlider(0, 100);
        JSlider populationSlider = new JSlider(0, 200);
        JSlider recoverySlider = new JSlider(0, 500);
        JButton fatalButton = new JButton("Not Fatal");

        fatalButton.addActionListener(this);

        threadPanel.add(infected, 1);
        threadPanel.add(infectedSlider, 1);
        threadPanel.add(probability, 2);
        threadPanel.add(probabilitySlider, 2);
        threadPanel.add(population, 3);
        threadPanel.add(populationSlider, 3);
        threadPanel.add(recovery, 4);
        threadPanel.add(recoverySlider, 4);
        threadPanel.add(fatalButton, 5);

        controlPanel.setLayout(new BorderLayout());

        JPanel p = new JPanel();
        p.setOpaque(false);
        p.add(threadPanel);

        controlPanel.add(p, BorderLayout.SOUTH);
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
