package simStation.prisoners.strategies;

import simStation.prisoners.Strategy;

public class AlwaysCooperate implements Strategy {
    @Override
    public boolean cooperate(boolean partnerCooperated) {
        return true; // always coop
    }
} 