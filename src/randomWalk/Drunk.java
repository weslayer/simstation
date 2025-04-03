package simstation.plague;

import mvc.*;
import simStation.*;

public class Drunk extends MobileAgent {
    public Drunk() {
        super();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(20) + 1;
        move(steps);
    }
}
