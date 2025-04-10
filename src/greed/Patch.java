package greed;

import simStation.Agent;

import java.awt.*;

public class Patch extends Agent {
    int energy = 100;
    int growRate = 1;
    int patchSize = 10;
    Color color = Color.green;

    public Patch(int x, int y) {
        super();
        this.xc = x  * patchSize;
        this.yc = y  * patchSize;

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
        changeColor();
    }

    public Color getColor() {
        return this.color;
    }

    public void setGrowRate(int i) {
        this.growRate = i;
    }

    public int getPatchSize() {
        return this.patchSize;
    }

    public void changeColor() {
        if (energy == 0) {
            color = Color.black;
        }
        else if (energy <= 20) {
            color = new Color(0, 54, 3);
        }

        else if (energy <= 40) {
            color = new Color(0, 99, 5);
        }

        else if (energy <= 60) {
            color = new Color(0, 166, 8);
        }

        else {
            color = Color.green;
        }
    }


}
