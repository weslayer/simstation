package prisoners;

import mvc.Utilities;
import simStation.Agent;
import simStation.MobileAgent;

public class Prisoner extends MobileAgent {
    private Strategy strategy;
    private double fitness;
    private boolean lastMove; // true = cooperate, false = cheat
    private static final double COOPERATE_COOPERATE_REWARD = 3.0;
    private static final double CHEAT_COOPERATE_REWARD = 5.0;
    private static final double COOPERATE_CHEAT_REWARD = 0.0;
    private static final double CHEAT_CHEAT_REWARD = 1.0;

    public Prisoner(Strategy strategy) {
        super();
        this.strategy = strategy;
        this.fitness = 0.0;
        this.lastMove = true; // cooperation by default
    }

    public boolean getLastMove() {
        return lastMove;
    }

    public double getFitness() {
        return fitness;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    @Override
    public void update() {
        Agent neighbor = world.getNeighbor(this, 10);
        if (neighbor instanceof Prisoner) {
            Prisoner other = (Prisoner)neighbor;
            // get both decisions
            boolean myMove = strategy.cooperate(this, other);
            boolean theirMove = other.getStrategy().cooperate(other, this);
            
            // update last moves
            this.lastMove = myMove;
            other.lastMove = theirMove;
            
            // update fitness scores based on payoff matrix
            if (myMove && theirMove) {
                this.fitness += COOPERATE_COOPERATE_REWARD;
                other.fitness += COOPERATE_COOPERATE_REWARD;
            } else if (!myMove && theirMove) {
                this.fitness += CHEAT_COOPERATE_REWARD;
                other.fitness += COOPERATE_CHEAT_REWARD;
            } else if (myMove && !theirMove) {
                this.fitness += COOPERATE_CHEAT_REWARD;
                other.fitness += CHEAT_COOPERATE_REWARD;
            } else {
                this.fitness += CHEAT_CHEAT_REWARD;
                other.fitness += CHEAT_CHEAT_REWARD;
            }
        }
        
        // Use MobileAgent's movement functionality
        randomTurn();
        move(Utilities.rng.nextInt(20) + 1);
    }
} 