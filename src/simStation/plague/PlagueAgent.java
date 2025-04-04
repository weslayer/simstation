package simStation.plague;

import mvc.*;
import simStation.*;

class PlagueAgent extends MobileAgent {
    public boolean INFECTED;
    public int INFECTED_START_TIME;

    public PlagueAgent() {
        super();
        this.INFECTED_START_TIME = 0;
    }

    @Override
    public void update() {
        heading = Heading.random();
        PlagueSimulation plagueSimulation = (PlagueSimulation) this.world;
        PlagueAgent contactedAgent = (PlagueAgent) plagueSimulation.getNeighbor(this, 1);
        if (contactedAgent instanceof PlagueAgent) {
            if (contactedAgent.INFECTED && !this.INFECTED) {
                this.INFECTED = true;
                this.INFECTED_START_TIME = plagueSimulation.clock;
            }
        }
        if ((plagueSimulation.clock - this.INFECTED_START_TIME) >= plagueSimulation.FATALITY_OR_RECOVERY_RATE
                && this.INFECTED) {
            if (plagueSimulation.FATAL) {
                this.stop();
            } else {
                this.INFECTED = false;
            }
            plagueSimulation.AMOUNT_INFECTED--;
        }
        move(Utilities.rng.nextInt(20) + 1);
    }
}
