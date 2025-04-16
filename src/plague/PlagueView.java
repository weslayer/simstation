<<<<<<< HEAD:src/simStation/plague/PlagueView.java
package simStation.plague;
=======
package plague;
>>>>>>> dfd7a77 (put packages outside of simstation):src/plague/PlagueView.java

import mvc.*;
import java.awt.*;
import simStation.*;
<<<<<<< HEAD:src/simStation/plague/PlagueView.java
import java.util.Iterator;
=======
>>>>>>> dfd7a77 (put packages outside of simstation):src/plague/PlagueView.java

public class PlagueView extends WorldView {
    private static final int AGENT_SIZE = 10;

    public PlagueView(Model m) {
        super(m);
    }

    public void update() {
        repaint();
    }

    // Draw the agents (red = infected, green = healthy)
    @Override
    protected void drawAgent(Agent agent, Graphics g) {
        if (agent instanceof ObserverAgent)
            return; // Don't draw the observer

        if (agent instanceof PlagueAgent) {
            if (((PlagueAgent) agent).INFECTED == true) {
                g.setColor(Color.RED);
                if (agent.isStopped()) {
                    g.setColor(Color.BLACK);
                }
            } else {
                g.setColor(Color.GREEN);
            }
        }
        g.fillOval(agent.getX() - AGENT_SIZE / 2,
                agent.getY() - AGENT_SIZE / 2,
                AGENT_SIZE,
                AGENT_SIZE);
    }
}
