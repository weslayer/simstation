package greed;

import simStation.Agent;

public class Patch extends Agent {
    int energy = 100;
    int growRate = 1;
    int patchSize = 10;

    public Patch(String name) {
        super();
    }

    public void eat(Cow cow) {
        if (this.energy >= cow.getGreediness()) {
            this.energy -= cow.getGreediness();
            cow.feed();
        }
        else {
            cow.move();
        }
    }

    public void update () {
        this.energy += growRate;
    }


}
