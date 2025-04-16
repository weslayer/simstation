package greed;

import simStation.Agent;
import simStation.World;

import java.util.ArrayList;
import java.util.Iterator;

public class Meadow extends World {
    int waitPenalty = 5;
    int GRID_SIZE = 50;
    int moveEnergy = 10;
    int numCows = 50;
    int globalGreed = 25;
    int globalGrowRate = 1;
    Patch[][] meadow;


    public Meadow() {
        super();
        meadow = new Patch[GRID_SIZE][GRID_SIZE];
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Patch patch = new Patch(row, col, globalGrowRate);
                meadow[row][col] = patch;
                addAgent(patch);
            }
        }
    }

    @Override
    public void startAgents() {
        Iterator<Agent> iterator = iterator();
        while (iterator.hasNext()) {
            Agent a = iterator.next();
            if (a instanceof Cow) {
                iterator.remove();
            }
            else if (a instanceof Patch) {
                ((Patch) a).regen();
            }
        }
        populate();
        iterator = iterator();
        while (iterator.hasNext()) {
            iterator.next().start();
        }
        changed();
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

    public void setGlobalGreed(int g) {
        this.globalGreed = g;
    }

    public void setGlobalGrowRate(int g) {
        this.globalGrowRate = g;
    }

    @Override
    public void populate() {
        for (int i = 0;i <= numCows; i++) {
            Cow cow =new Cow(globalGreed);
            cow.setMeadow(this);
            addAgent(cow);
        }
    }

    public ArrayList<Agent> getAgents() {
        ArrayList<Agent> result = new ArrayList<>();
        Iterator<Agent> iterator = iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

    public Patch[][] getMeadow() {
        return meadow;
    }
}
