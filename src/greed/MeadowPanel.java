package greed;

import mvc.AppPanel;
import mvc.Utilities;
import simStation.WorldFactory;
import simStation.WorldPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MeadowPanel extends WorldPanel implements ChangeListener {
    JPanel bigPanel = new JPanel();
    JSlider greedSlider;
    JSlider growSlider;
    JSlider energySlider;

    public MeadowPanel(WorldFactory factory) {
        super(factory);

        bigPanel.setLayout(new GridLayout(6, 1));

        JPanel p = new JPanel();
        JLabel greed = new JLabel("Greed", SwingConstants.CENTER);
        p.add(greed);
        bigPanel.add(p);

        p=new JPanel();
        greedSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
        greedSlider.setMajorTickSpacing(25);
        greedSlider.setMinorTickSpacing(10);
        greedSlider.setPaintTicks(true);
        greedSlider.setPaintLabels(true);
        greedSlider.addChangeListener(this);
        p.add(greedSlider);
        bigPanel.add(p);

        p = new JPanel();
        JLabel grow = new JLabel("Grow Back Rate", SwingConstants.CENTER);
        p.add(grow);
        bigPanel.add(p);

        p = new JPanel();
        growSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);
        growSlider.setMajorTickSpacing(1);
        growSlider.setMinorTickSpacing(1);
        growSlider.setPaintTicks(true);
        growSlider.setPaintLabels(true);
        growSlider.addChangeListener(this);
        p.add(growSlider);
        bigPanel.add(p);

        p = new JPanel();
        JLabel energy = new JLabel("Move Energy", SwingConstants.CENTER);
        p.add(energy);
        bigPanel.add(p);

        p = new JPanel();
        energySlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 10);
        energySlider.setMajorTickSpacing(10);
        energySlider.setMinorTickSpacing(5);
        energySlider.setPaintTicks(true);
        energySlider.setPaintLabels(true);
        energySlider.addChangeListener(this);
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


    protected void handleException(Exception e) {
        Utilities.error(e);
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        try {
            JSlider slider = (JSlider) e.getSource();
           if (slider == greedSlider) {
               GreedSlider command = (GreedSlider) this.factory.makeEditCommand(this.model, "Greed", this);
               command.execute(slider.getValue());
           } else if (slider == growSlider) {
               GrowSlider command = (GrowSlider) this.factory.makeEditCommand(this.model, "Grow", this);
               command.execute(slider.getValue());
           } else if (slider == energySlider) {
               MoveSlider command = (MoveSlider) this.factory.makeEditCommand(this.model, "Move", this);
               command.execute(slider.getValue());
           }
        } 
        catch(Exception h) {
            handleException(h);
        }
    }
}
