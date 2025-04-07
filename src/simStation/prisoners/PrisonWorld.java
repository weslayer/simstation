package simStation.prisoners;

import java.util.ArrayList;
import java.util.Iterator;

import simStation.Agent;
import simStation.World;
import simStation.prisoners.strategies.AlwaysCheat;
import simStation.prisoners.strategies.AlwaysCooperate;
import simStation.prisoners.strategies.RandomStrategy;
import simStation.prisoners.strategies.TitForTat;

public class PrisonWorld extends World {
    public PrisonWorld() {
        super();
    }
    
    @Override
    public void populate() {
        // Create 40 agents (10 of each strategy type)
        for (int i = 0; i < 40; i++) {
            addAgent(new PrisonerFactory().createAgent());
        }
    }
    
    @Override
    public String[] getStatus() {
        // average fitness for each strategy type
        double avgAlwaysCheat = 0;
        double avgAlwaysCooperate = 0;
        double avgRandom = 0;
        double avgTitForTat = 0;
        int countAlwaysCheat = 0;
        int countAlwaysCooperate = 0;
        int countRandom = 0;
        int countTitForTat = 0;
        
        Iterator<Agent> it = iterator();
        while (it.hasNext()) {
            Agent agent = it.next();
            if (agent instanceof Prisoner) {
                Prisoner p = (Prisoner)agent;
                Strategy strategy = p.getStrategy();
                double fitness = p.getFitness();
                
                if (strategy instanceof AlwaysCheat) {
                    avgAlwaysCheat += fitness;
                    countAlwaysCheat++;
                } else if (strategy instanceof AlwaysCooperate) {
                    avgAlwaysCooperate += fitness;
                    countAlwaysCooperate++;
                } else if (strategy instanceof RandomStrategy) {
                    avgRandom += fitness;
                    countRandom++;
                } else if (strategy instanceof TitForTat) {
                    avgTitForTat += fitness;
                    countTitForTat++;
                }
            }
        }
        
        ArrayList<String> results = new ArrayList<>();
        String[] baseStats = super.getStatus();
        for (String stat : baseStats) {
            results.add(stat);
        }
        
        if (countAlwaysCheat > 0) results.add("Always Cheat avg fitness = " + (avgAlwaysCheat / countAlwaysCheat));
        if (countAlwaysCooperate > 0) results.add("Always Cooperate avg fitness = " + (avgAlwaysCooperate / countAlwaysCooperate));
        if (countRandom > 0) results.add("Random avg fitness = " + (avgRandom / countRandom));
        if (countTitForTat > 0) results.add("Tit for Tat avg fitness = " + (avgTitForTat / countTitForTat));
        
        return results.toArray(new String[0]);
    }
} 