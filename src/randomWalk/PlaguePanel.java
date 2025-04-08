package simStation.plague;

import mvc.*;
import simStation.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PlaguePanel extends WorldPanel {

    public JPanel threadPanel = new JPanel();
    public JSlider infectedSlider;
    public JSlider probabilitySlider;
    public JSlider populationSlider;
    public JSlider recoverySlider;
    public JButton fatalButton;

    public PlaguePanel(PlagueFactory factory) {
        super(factory);

        threadPanel.setLayout(new GridLayout(5, 2));
        threadPanel.setOpaque(false);

        JLabel infected = new JLabel("Initial % Infected");
        JLabel probability = new JLabel("Infection Probability");
        JLabel population = new JLabel("Initial Population Size");
        JLabel recovery = new JLabel("Fatality/Recovery Time");

        infectedSlider = new JSlider(0, 100);
        infectedSlider.setPaintTicks(true);
        infectedSlider.setPaintLabels(true);
        infectedSlider.setMajorTickSpacing(20);
        infectedSlider.setMinorTickSpacing(5);
        probabilitySlider = new JSlider(0, 100);
        probabilitySlider.setPaintTicks(true);
        probabilitySlider.setPaintLabels(true);
        probabilitySlider.setMajorTickSpacing(20);
        probabilitySlider.setMinorTickSpacing(5);
        populationSlider = new JSlider(0, 200);
        populationSlider.setPaintTicks(true);
        populationSlider.setPaintLabels(true);
        populationSlider.setMajorTickSpacing(40);
        populationSlider.setMinorTickSpacing(10);
        recoverySlider = new JSlider(0, 500);
        recoverySlider.setPaintTicks(true);
        recoverySlider.setPaintLabels(true);
        recoverySlider.setMajorTickSpacing(100);
        recoverySlider.setMinorTickSpacing(25);
        fatalButton = new JButton("Fatal");

        threadPanel.add(infected);
        threadPanel.add(infectedSlider);
        threadPanel.add(probability);
        threadPanel.add(probabilitySlider);
        threadPanel.add(population);
        threadPanel.add(populationSlider);
        threadPanel.add(recovery);
        threadPanel.add(recoverySlider);
        threadPanel.add(fatalButton);

        JPanel p = new JPanel();
        p.setOpaque(false);
        p.add(threadPanel);

        controlPanel.add(p, BorderLayout.CENTER);

        fatalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String cmmd = ae.getActionCommand();
                if (cmmd.equals("Fatal")) {
                    ((PlagueSimulation) model).FATAL = true;
                    fatalButton.setText("Not Fatal");
                } else if (cmmd.equals("Not Fatal")) {
                    ((PlagueSimulation) model).FATAL = false;
                    fatalButton.setText("Fatal");
                }
            }
        });

        infectedSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ((PlagueSimulation) model).INITIAL_PERCENT_INFECTED = infectedSlider.getValue();
            }
        });

        probabilitySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ((PlagueSimulation) model).INFECTION_PROBABILITY = probabilitySlider.getValue();
            }
        });

        populationSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ((PlagueSimulation) model).POPULATION_SIZE = populationSlider.getValue();
            }
        });

        recoverySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ((PlagueSimulation) model).FATALITY_OR_RECOVERY_RATE = recoverySlider.getValue();
            }
        });
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
