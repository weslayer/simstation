package simStation.prisoners.strategies;

import java.util.Random;

import simStation.prisoners.Strategy;

public class RandomStrategy implements Strategy {
    private static final Random RANDOM = new Random();
    
    @Override
    public boolean cooperate(boolean partnerCooperated) {
        return RANDOM.nextBoolean(); // randomly coop or cheat
    }
} 