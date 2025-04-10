package greed;

import mvc.AppPanel;
import simStation.WorldFactory;
import simStation.WorldPanel;

import javax.swing.*;
import java.awt.*;

public class MeadowPanel extends WorldPanel {
    JPanel bigPanel = new JPanel();
    public MeadowPanel(WorldFactory factory) {
        super(factory);

        bigPanel.setLayout(new GridLayout(6, 1));

        JPanel p = new JPanel();
        JLabel greed = new JLabel("Greed", SwingConstants.CENTER);
        p.add(greed);
        bigPanel.add(p);

        p=new JPanel();
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(e -> {
            int greedValue = slider.getValue();
        });
        p.add(slider);
        bigPanel.add(p);

        p = new JPanel();
        JLabel grow = new JLabel("Grow Back Rate", SwingConstants.CENTER);
        p.add(grow);
        bigPanel.add(p);

        p = new JPanel();
        JSlider growSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
        growSlider.setMajorTickSpacing(1);
        growSlider.setMinorTickSpacing(1);
        growSlider.setPaintTicks(true);
        growSlider.setPaintLabels(true);
        growSlider.addChangeListener(e -> {
            int growValue = slider.getValue();
        });
        p.add(growSlider);
        bigPanel.add(p);

        p = new JPanel();
        JLabel energy = new JLabel("Move Energy", SwingConstants.CENTER);
        p.add(energy);
        bigPanel.add(p);

        p = new JPanel();
        JSlider energySlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 10);
        energySlider.setMajorTickSpacing(10);
        energySlider.setMinorTickSpacing(5);
        energySlider.setPaintTicks(true);
        energySlider.setPaintLabels(true);
        energySlider.addChangeListener(e -> {
            int energyValue = slider.getValue();
        });
        p.add(energySlider);
        bigPanel.add(p);


        p = new JPanel();
        p.setOpaque(false);
        p.add(bigPanel);
        controlPanel.add(p);



    }

    public static void main(String[] args) {
        MeadowFactory factory = new MeadowFactory();
        AppPanel panel = new MeadowPanel(factory);
        panel.display();
    }
}
