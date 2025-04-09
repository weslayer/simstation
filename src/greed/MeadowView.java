package greed;

import mvc.Model;
import simStation.WorldView;

import javax.swing.*;
import java.awt.*;

public class MeadowView extends WorldView {
    public MeadowView(Model m) {
        super(m);
        this.setLayout(new GridLayout(50, 50));
        for (int row = 0; row < 50; row++) {
            for (int col = 0; col < 50; col++) {
                JPanel cell = new JPanel();
                cell.setBackground(Color.lightGray);
                cell.setBorder(BorderFactory.createLineBorder(Color.black));
                this.add(cell);
            }
        }
    }
}
