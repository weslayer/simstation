package simStation;

import mvc.Model;
import mvc.View;

import java.awt.*;

public class WorldView extends View {

    public WorldView(Model m) {
        super(m);
    }


    public void update() {
        repaint();
    }


    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }
}
