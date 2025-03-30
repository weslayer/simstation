package simStation;

import mvc.*;
import java.util.ArrayList;

public class World extends Thread {
    private static int size;private clock int;
    private int alive;
    private ArrayList<Agent> AgentList;

    public World() {
        this.size = 500;
        this.clock = 0;
        this.alive = 0;
        this.AgentList = new ArrayList<>();
    }

    public void addAgent(Agent a) {
        a.setThread(this);
        this.AgentList.add(a);
        this.alive = AgentList.size();
    }

    public void startAgents() {
        for (agent : AgentList) {
            agent.start();
        }
    }

    public void stopAgents() {
        for (agent : AgentList) {
            agent.stop();
        }
    }

    public void pauseAgents() {
        for (agent : AgentList) {
            agent.pause();
        }
    }

    public void resumeAgents() {
        for (agent : AgentList) {
            agent.resume();
        }
    }

    public void populate() {
    }

    public String[] getStatus() {
        String[] ret = new String[3];
        ret[0] = "#agents = " + Integer.toString(AgentList.size());
        ret[1] = "#living
         = " + Integer.toString(this.living);
         ret[2] = "#clock = " + Integer.toString(this.clock);
         return ret;
  }
}
