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

        threadPanel.setLayout(new GridLayout(5, 2));
        threadPanel.setOpaque(false);

        JLabel infected = new JLabel("Initial % Infected");
        JLabel probability = new JLabel("Infection Probability");
        JLabel population = new JLabel("Initial Population Size");
        JLabel recovery = new JLabel("Fatality/Recovery Time");

        JSlider infectedSlider = new JSlider(0, 100);
        infectedSlider.setPaintTicks(true);
        infectedSlider.setPaintLabels(true);
        infectedSlider.setMajorTickSpacing(20);
        infectedSlider.setMinorTickSpacing(5);
        infectedSlider.setChangeListener(this);
        JSlider probabilitySlider = new JSlider(0, 100);
        probabilitySlider.setPaintTicks(true);
        probabilitySlider.setPaintLabels(true);
        probabilitySlider.setMajorTickSpacing(20);
        probabilitySlider.setMinorTickSpacing(5);
        probabilitySlider.setChangeListener(this);
        JSlider populationSlider = new JSlider(0, 200);
        populationSlider.setPaintTicks(true);
        populationSlider.setPaintLabels(true);
        populationSlider.setMajorTickSpacing(40);
        populationSlider.setMinorTickSpacing(10);
        populationSlider.setChangeListener(this);
        JSlider recoverySlider = new JSlider(0, 500);
        recoverySlider.setPaintTicks(true);
        recoverySlider.setPaintLabels(true);
        recoverySlider.setMajorTickSpacing(100);
        recoverySlider.setMinorTickSpacing(25);
        recoverySlider.setChangeListener(this);
        JButton fatalButton = new JButton("Fatal");
        fatalButton.addActionListener(this);

        threadPanel.add(infected);
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

        controlPanel.add(p, BorderLayout.CENTER);
    }

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (source == infectedSlider) {
        } else if (source == probabilitySlider) {
        } else if (source == populationSlider) {
        } else if (source == recoverySlider) {
        }
    }

    public void setModel(Model m) {
        super.setModel(m);
        PlagueSimulation w = (PlagueSimulation) m;
        Iterator<Agent> it = w.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
    }
}
