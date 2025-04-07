package simStation.prisoners;

import simStation.Agent;

public class Prisoner extends Agent {
    private double fitness;
    private boolean partnerCooperated;
    private Strategy strategy;
    private static final int INTERACTION_RADIUS = 50; // interact dist
    
    public Prisoner(Strategy strategy) {
        super();
        this.fitness = 0;
        this.strategy = strategy;
        this.partnerCooperated = false;
    }
    
    @Override
    public void update() {
        // find rand neighbor
        Prisoner partner = (Prisoner) world.getNeighbor(this, INTERACTION_RADIUS);
        if (partner != null) {
            // both do a strategy
            boolean iCooperate = strategy.cooperate(partnerCooperated);
            boolean theyCooperate = partner.getStrategy().cooperate(partner.getPartnerCooperated());
            
            updateFitness(iCooperate, theyCooperate);
            partner.updateFitness(theyCooperate, iCooperate);
            
            // update last move
            partnerCooperated = theyCooperate;
            partner.setPartnerCooperated(iCooperate);
        }
    }
    
    private void updateFitness(boolean iCooperate, boolean theyCooperate) {
        if (iCooperate && theyCooperate) {
            fitness += 3; // both coop
        } else if (!iCooperate && theyCooperate) {
            fitness += 5; // i cheat, they coop
        } else if (iCooperate && !theyCooperate) {
            fitness += 0; // i coop, they cheat
        } else {
            fitness += 1; // both cheat
        }
    }
    
    public Strategy getStrategy() {
        return strategy;
    }
    
    public boolean getPartnerCooperated() {
        return partnerCooperated;
    }
    
    public void setPartnerCooperated(boolean cooperated) {
        this.partnerCooperated = cooperated;
    }
    
    public double getFitness() {
        return fitness;
    }
} 