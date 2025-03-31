package simStation;

import mvc.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class World extends Model {
    public static final int SIZE = 500;
    private int clock;
    private int alive;
    private ArrayList<Agent> agents;
    private ObserverAgent observer;
    private static final Random RANDOM = new Random();

    public World() {
        this.clock = 0;
        this.alive = 0;
        this.agents = new ArrayList<>();
        this.observer = new ObserverAgent();
        addAgent(observer);
    }

    public void addAgent(Agent a) {
        a.setWorld(this);
        agents.add(a);
        this.alive = agents.size();
        changed();
    }

    public Iterator<Agent> iterator() {
        return agents.iterator();
    }

    public void startAgents() {
        populate();
        for (Agent agent : agents) {
            agent.start();
        }
        changed();
    }

    public void stopAgents() {
        for (Agent agent : agents) {
            agent.stop();
        }
        changed();
    }

    public void pauseAgents() {
        for (Agent agent : agents) {
            agent.suspend();
        }
        changed();
    }

    public void resumeAgents() {
        for (Agent agent : agents) {
            agent.resume();
        }
        changed();
    }

    public void populate() {
        // To be implemented by subclasses
    }

    public String[] getStatus() {
        String[] ret = new String[3];
        ret[0] = "#agents = " + agents.size();
        ret[1] = "#living = " + alive;
        ret[2] = "clock = " + clock;
        return ret;
    }

    public void updateStatistics() {
        clock++;
        alive = 0;
        // Count agents that aren't the observer and aren't stopped
        for (Agent agent : agents) {
            if (!(agent instanceof ObserverAgent)) {
                alive++;
            }
        }
        changed();
    }

    public Agent getNeighbor(Agent caller, int radius) {
        if (agents.size() <= 1) return null;
        
        // Start at a random position
        int start = RANDOM.nextInt(agents.size());
        int current = start;
        
        do {
            Agent candidate = agents.get(current);
            if (candidate != caller && !(candidate instanceof ObserverAgent)) {
                // Calculate distance between agents
                int dx = candidate.getX() - caller.getX();
                int dy = candidate.getY() - caller.getY();
                double distance = Math.sqrt(dx*dx + dy*dy);
                
                if (distance <= radius) {
                    return candidate;
                }
            }
            
            // Move to next agent (wrap around)
            current = (current + 1) % agents.size();
        } while (current != start);
        
        // No suitable neighbor found
        return null;
    }
}
