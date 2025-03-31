package simStation;

import mvc.*;
import java.util.ArrayList;

public class World extends Model {
    private static int size;
    private int clock ;
    private int alive;
    private ArrayList<Agent> AgentList;
    private Agent ObserverAgent;

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
        for (Agent agent : AgentList) {
            agent.start();
        }
        populate();
    }

    public void stopAgents() {
        for (Agent agent : AgentList) {
            agent.stop();
        }
    }

    public void pauseAgents() {
        for (Agent agent : AgentList) {
            agent.pause();
        }
    }

    public void resumeAgents() {
        for (Agent agent : AgentList) {
            agent.resume();
        }
    }

    public void populate() {
        //TODO
    }

    public String[] getStatus() {
        String[] ret = new String[3];
        ret[0] = "#agents = " + Integer.toString(AgentList.size());
        ret[1] = "#living = " + Integer.toString(this.alive);
        ret[2] = "#clock = " + Integer.toString(this.clock);
         return ret;
  }

  public void updateStatistics() {
      //TODO
  }

  public Agent getNeighbor(Agent caller, int radius) { //TODO
        Agent test = new Agent("test");
        return test;
  }



}
