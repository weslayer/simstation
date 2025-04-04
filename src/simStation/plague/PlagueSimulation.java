package simStation.plague;

import mvc.*;
import simStation.*;

public class PlagueSimulation extends World {
    private static int VIRULENCE;
    private static int RESISTANCE;
    public int INITIAL_PERCENT_INFECTED;
    public int INFECTION_PROBABILITY;
    public int POPULATION_SIZE;
    public int AMOUNT_INFECTED;
    public int FATALITY_OR_RECOVERY_RATE;

    public PlagueSimulation(int init_inf, int inf_prob, int init_pop, int rec_time) {
        super();
        this.INITIAL_PERCENT_INFECTED = init_inf;
        this.INFECTION_PROBABILITY = inf_prob;
        this.POPULATION_SIZE = init_pop;
        this.FATALITY_OR_RECOVERY_RATE = rec_time;
    }

    public void populate() {
        for (int i = 0; i < POPULATION_SIZE; i++)
            addAgent(new PlagueAgent());
    }

    public static void main(String[] args) {
        AppPanel panel = new WorldPanel(new PlagueFactory());
        panel.display();
    }

    @Override
    public String[] getStatus() {
        String[] ret = new String[3];
        ret[0] = "#agents = " + this.agents.size();
        ret[1] = "clock = " + this.clock;
        ret[2] = "#infected = " + this.AMOUNT_INFECTED;
        return ret;
    }
}
