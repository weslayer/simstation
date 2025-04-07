package simStation.prisoners;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import simStation.Agent;
import simStation.World;
import simStation.WorldView;
import simStation.prisoners.strategies.AlwaysCheat;
import simStation.prisoners.strategies.AlwaysCooperate;
import simStation.prisoners.strategies.RandomStrategy;
import simStation.prisoners.strategies.TitForTat;

public class PrisonerView extends WorldView {
    public PrisonerView(World world) {
        super(world);
    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        World world = (World)model;
        Iterator<Agent> it = world.iterator();
        while (it.hasNext()) {
            Agent agent = it.next();
            if (agent instanceof Prisoner) {
                Prisoner p = (Prisoner)agent;
                Strategy strategy = p.getStrategy();
                
                // color based on strategy
                if (strategy instanceof AlwaysCheat) {
                    gc.setColor(Color.RED);
                } else if (strategy instanceof AlwaysCooperate) {
                    gc.setColor(Color.GREEN);
                } else if (strategy instanceof RandomStrategy) {
                    gc.setColor(Color.BLUE);
                } else if (strategy instanceof TitForTat) {
                    gc.setColor(Color.YELLOW);
                }
                
                // Draw the agent as a filled circle
                gc.fillOval(p.getX() - 5, p.getY() - 5, 10, 10);
            }
        }
    }
} 