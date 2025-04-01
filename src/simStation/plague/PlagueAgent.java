package simstation.plague;

import mvc.*;
import simstation.*;

class PlagueAgent extends MobileAgent {
    private boolean INFECTED;

    public PlagueAgent() {
        super();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(20) + 1;
        move(steps);
    }

}
