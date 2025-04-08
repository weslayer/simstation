package greed;

import simStation.Agent;
import simStation.MobileAgent;

public class Cow extends MobileAgent {
    int energy = 100;
    int greediness= 25;
    Meadow meadow;


    public Cow(String name) {
        super(name);
    }

    public void setMeadow (Meadow meadow) {
        this.meadow = meadow;
    }

    public void feed() {
        this.energy += this.greediness;
    }

    @Override
    public void update() {
        this.energy -= meadow.getWaitPenalty();
        move();
    }

    public int getGreediness() {
        return this.greediness;
    }

    public void move() {
        if (this.energy >= meadow.getMoveEnergy()) {
            randomTurn();
            move(1);
        }
    }


}
