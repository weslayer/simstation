package greed;

import simStation.Agent;
import simStation.MobileAgent;
import mvc.*;
import simStation.*;

public class Cow extends MobileAgent {
    int energy = 100;
    int greediness= 80;
    Meadow meadow;

    public Cow() {
        super();
    }

    public void setMeadow (Meadow meadow) {
        this.meadow = meadow;
    }

    public void feed() {
        this.energy += this.greediness;
        System.out.println(energy);
    }

    @Override
    public void update() {
        this.energy -= meadow.getWaitPenalty();
        if (this.energy <= 0) {
            this.stop();
            System.out.println("I died");
        }
        Agent standing = meadow.getNeighbor(this, 10);
        if (standing instanceof Patch) {
            Patch stand = (Patch)standing;
            if (stand.energy >= this.greediness) {
                stand.eat(this);
            }
            else {
                move();
            }
        }
    }

    public int getGreediness() {
        return this.greediness;
    }

    public void setGreediness(int g) {
        this.greediness = g;
    }

    public void move() {
        if (this.energy >= meadow.getMoveEnergy()) {
            heading = Heading.random();
            move(10);
            System.out.println("Im moving");
        }
        System.out.println("Im trying to move");
    }


}
