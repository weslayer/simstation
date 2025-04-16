<<<<<<< HEAD
package simstation.plague;
=======
package randomWalk;
>>>>>>> dfd7a77 (put packages outside of simstation)

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
