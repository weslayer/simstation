package simStation.prisoners.strategies;

import simStation.prisoners.Strategy;

public class TitForTat implements Strategy {
    private boolean isFirstMove = true;
    
    @Override
    public boolean cooperate(boolean partnerCooperated) {
        if (isFirstMove) {
            isFirstMove = false;
            return true; // coop first
        }
        return partnerCooperated; // copy
    }
} 