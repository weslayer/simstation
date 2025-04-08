package simStation;

import mvc.Model;
import mvc.View;

import java.awt.*;
import java.util.Iterator;

public class WorldView extends View {
    private static final int AGENT_SIZE = 10;

    public WorldView(Model m) {
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
        World world = (World)model;
        Iterator<Agent> iterator = world.iterator();
        while (iterator.hasNext()) {
            drawAgent(iterator.next(), g);
        }
    }
    
    // Can be overridden in subclasses for different agent appearances
    protected void drawAgent(Agent agent, Graphics g) {
        if (agent instanceof ObserverAgent) return; // Don't draw the observer
        
        g.setColor(Color.RED);
        g.fillOval(agent.getX() - AGENT_SIZE/2, 
                  agent.getY() - AGENT_SIZE/2, 
                  AGENT_SIZE, 
                  AGENT_SIZE);
    }
}
