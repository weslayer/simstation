package greed;

import simStation.Agent;
import simStation.MobileAgent;
import simStation.*;

import java.awt.*;

public class Cow extends MobileAgent {
    int energy = 100;
    int greediness = 25;
    Meadow meadow;
    Color color = Color.lightGray;

    public Cow(int g) {
        super();
        this.greediness = g;
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

    public Color getColor() {
        return color;
    }

    public int getGreediness() {
        return this.greediness;
    }

    public void move() {
        if (this.energy >= meadow.getMoveEnergy()) {
            heading = Heading.random();
            move(10);
        }
    }

    public void stop() {
        stopped = true;
        if (myThread != null) {
            myThread.interrupt();
        }
        this.color = Color.red;
    }


}
