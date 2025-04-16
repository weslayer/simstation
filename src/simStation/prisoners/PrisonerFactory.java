package simStation.prisoners;

import mvc.Model;
import mvc.View;
import simStation.Agent;
import simStation.World;
import simStation.WorldFactory;
import simStation.prisoners.strategies.AlwaysCheat;
import simStation.prisoners.strategies.AlwaysCooperate;
import simStation.prisoners.strategies.RandomStrategy;
import simStation.prisoners.strategies.TitForTat;

public class PrisonerFactory extends WorldFactory {
    @Override
    public Model makeModel() {
        return new PrisonWorld();
    }
    
    @Override
    public View makeView(Model model) {
        return new PrisonerView((World)model);
    }
    
    public Agent createAgent() {
        // Randomly assign one of the four strategies
        int strategy = (int)(Math.random() * 4);
        Strategy strat;
        switch (strategy) {
            case 0:
                strat = new AlwaysCheat();
                break;
            case 1:
                strat = new AlwaysCooperate();
                break;
            case 2:
                strat = new RandomStrategy();
                break;
            default:
                strat = new TitForTat();
                break;
        }
        return new Prisoner(strat);
    }
    
    @Override
    public String getTitle() {
        return "Prisoner's Dilemma";
    }
    
    @Override
    public String about() {
        return "yay";
    }
} 