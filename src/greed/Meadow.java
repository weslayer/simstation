package greed;

import simStation.Agent;
import simStation.World;

import java.util.ArrayList;

public class Meadow extends World {
    int waitPenalty = 5;
    int GRID_SIZE = 50;
    int moveEnergy = 10;
    int numCows = 50;
    Patch[][] meadow;


    public Meadow() {
        super();
        meadow = new Patch[GRID_SIZE][GRID_SIZE];
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Patch patch = new Patch(row, col);
                meadow[row][col] = patch;
                addAgent(patch);
            }
        }


    }

    public Patch getPatch(int xc, int yc) {
        return meadow[xc][yc];
    }

    public int getMoveEnergy() {
        return this.moveEnergy;
    }

    public int getWaitPenalty() { return this.waitPenalty; }

    public void setMoveEnergy(int m) {
        this.moveEnergy = m;
    }

    public void populate() {
        for (int i = 0;i <= numCows; i++) {
            Cow cow =new Cow();
            cow.setMeadow(this);
            addAgent(cow);
        }
    }

    public ArrayList<Agent> getAgents() {
        return this.agents;
    }

    public Patch[][] getMeadow() {
        return meadow;
    }
}
