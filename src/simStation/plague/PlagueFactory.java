package simStation.plague;

import mvc.*;
import simStation.*;

class PlagueFactory extends WorldFactory {
    public Model makeModel() {
        return new PlagueSimulation();
    }

    public String getTitle() {
        return "Plague Infection Simulation";
    }
}
