package simStation.randomWalk;

import mvc.*;
import simStation.*;

public class RandomWalkFactory extends WorldFactory {
    public Model makeModel() {
        return new RandomWalkSimulation();
    }

    public String getTitle() {
        return "Random Walks";
    }
}
