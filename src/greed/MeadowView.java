package greed;

import mvc.Model;
import simStation.Agent;
import simStation.ObserverAgent;
import simStation.World;
import simStation.WorldView;

import java.awt.*;
import java.util.Iterator;

public class MeadowView extends WorldView {
    private static final int AGENT_SIZE = 10;

    public MeadowView(Model m) {
        super(m);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(World.SIZE, World.SIZE));
    }

    public void update() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPatch(g);
        World world = (World)model;
        Iterator<Agent> iterator = world.iterator();
        while (iterator.hasNext()) {
            drawAgent(iterator.next(), g);
        }
    }

    // Can be overridden in subclasses for different agent appearances
    protected void drawAgent(Agent agent, Graphics g) {
        if (agent instanceof ObserverAgent) return; // Don't draw the observer
        if (agent instanceof Patch) return;
        Cow cow = (Cow)agent;

        g.setColor(cow.getColor());
        g.fillOval(agent.getX() - AGENT_SIZE/2,
                agent.getY() - AGENT_SIZE/2,
                AGENT_SIZE,
                AGENT_SIZE);
    }

    protected void drawPatch(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        Meadow meadow = (Meadow)model;
        Patch[][] patchGrid = meadow.getMeadow();
        for (int row = 0; row < 50; row++) {
            for (int col = 0; col < 50; col++) {
                Patch patch = patchGrid[row][col];
                Rectangle patchVis = new Rectangle(patch.getX(), patch.getY(), (int) (patch.getPatchSize()/1.1), (int) (patch.getPatchSize()/1.1));
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.draw(patchVis);
                g2d.setColor(patch.getColor());
                g2d.fill(patchVis);
            }
        }
    }
}
