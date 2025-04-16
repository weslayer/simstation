package plague;

import mvc.*;
import simStation.*;

public class PlagueSimulation extends World {
    // private static int VIRULENCE;
    // private static int RESISTANCE;
    public double INITIAL_PERCENT_INFECTED;
    public double INFECTION_PROBABILITY;
    public double POPULATION_SIZE;
    public double AMOUNT_INFECTED;
    public int FATALITY_OR_RECOVERY_RATE;
    public boolean FATAL;

    public PlagueSimulation(int init_inf, int inf_prob, int init_pop, int rec_time, boolean fatal) {
        super();
        this.INITIAL_PERCENT_INFECTED = init_inf;
        this.INFECTION_PROBABILITY = inf_prob;
        this.POPULATION_SIZE = init_pop;
        this.FATALITY_OR_RECOVERY_RATE = rec_time;
        this.AMOUNT_INFECTED = 0;
        this.FATAL = fatal;
    }

    @Override
    public void populate() {
        for (int i = 0; i < POPULATION_SIZE; i++) {
            PlagueAgent plagueAgent = new PlagueAgent();
            if (this.AMOUNT_INFECTED <= Math.floor((INITIAL_PERCENT_INFECTED / 100) * POPULATION_SIZE)) {
                plagueAgent.INFECTED = true;
                this.AMOUNT_INFECTED++;
            }
            this.addAgent(plagueAgent);
        }
    }

    @Override
    public String[] getStatus() {
        String[] ret = new String[3];
        ret[0] = "#agents = " + this.agents.size();
        ret[1] = "clock = " + this.clock;
        ret[2] = "#infected = " + this.AMOUNT_INFECTED;
        return ret;
    }

    public static void main(String[] args) {
        AppPanel panel = new WorldPanel(new PlagueFactory());
        panel.display();
    }
}
