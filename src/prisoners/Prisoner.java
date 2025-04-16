package prisoners;

import simStation.*;

public class Prisoner extends Agent {
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
            // Get decisions from both prisoners
            boolean myMove = strategy.cooperate(this, other);
            boolean theirMove = other.getStrategy().cooperate(other, this);
            
            // Update last moves
            this.lastMove = myMove;
            other.lastMove = theirMove;
            
            // Update fitness scores based on payoff matrix
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
        
        // Random movement
        int randomHeading = (int)(Math.random() * 4);
        switch (randomHeading) {
            case 0: yc = Math.max(0, yc - 1); break; // North
            case 1: xc = Math.min(World.SIZE - 1, xc + 1); break; // East
            case 2: yc = Math.min(World.SIZE - 1, yc + 1); break; // South
            case 3: xc = Math.max(0, xc - 1); break; // West
        }
    }
} 