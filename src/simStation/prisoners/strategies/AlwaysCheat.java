package simStation.prisoners.strategies;

import simStation.prisoners.Strategy;

public class AlwaysCheat implements Strategy {
    @Override
    public boolean cooperate(boolean partnerCooperated) {
        return false; // always cheat
    }
} 