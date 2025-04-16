package prisoners;

import simStation.*;
import mvc.*;
import java.util.Iterator;

public class PrisonersFactory extends WorldFactory {
    @Override
    public Model makeModel() {
        return new PrisonersWorld();
    }

    @Override
    public View makeView(Model m) {
        return new WorldView((World) m);
    }

    @Override
    public String[] getEditCommands() {
        return new String[] { "Start", "Pause", "Resume", "Stop", "Stats" };
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        switch (type) {
            case "Start":
                return new StartCommand(model);
            case "Pause":
                return new PauseCommand(model);
            case "Resume":
                return new ResumeCommand(model);
            case "Stop":
                return new StopCommand(model);
            case "Stats":
                return new StatsCommand(model);
            default:
                return null;
        }
    }

    @Override
    public String getTitle() {
        return "Prisoner's Dilemma Simulation";
    }

    @Override
    public String[] getHelp() {
        return new String[] {
            "Press start to begin simulation.",
            "Press pause to pause the simulation.",
            "Press resume to resume a paused simulation.",
            "Press stop to end a simulation.",
            "Press stats to see average fitness for each strategy."
        };
    }

    @Override
    public String about() {
        return "Prisoner's Dilemma Simulation version 1.0. Copyright 2025 by Nicholas Pang, Wesley Wong, and Rustico Dela Cruz III.";
    }
}

class PrisonersWorld extends World {
    private static final int POPULATION = 40; // 10 of each strategy

    @Override
    public void populate() {
        // 10 agents of each strategy type
        for (int i = 0; i < POPULATION / 4; i++) {
            addAgent(new Prisoner(new Cooperate()));
            addAgent(new Prisoner(new Cheat()));
            addAgent(new Prisoner(new RandomlyCooperate()));
            addAgent(new Prisoner(new TitForTat()));
        }
    }

    @Override
    public String[] getStatus() {
        String[] baseStatus = super.getStatus();
        String[] stats = getStrategyStats();
        
        String[] combinedStats = new String[baseStatus.length + stats.length];
        System.arraycopy(baseStatus, 0, combinedStats, 0, baseStatus.length);
        System.arraycopy(stats, 0, combinedStats, baseStatus.length, stats.length);
        
        return combinedStats;
    }

    private String[] getStrategyStats() {
        double cooperateTotal = 0.0;
        double cheatTotal = 0.0;
        double randomTotal = 0.0;
        double titForTatTotal = 0.0;
        int cooperateCount = 0;
        int cheatCount = 0;
        int randomCount = 0;
        int titForTatCount = 0;

        Iterator<Agent> it = iterator();
        while (it.hasNext()) {
            Agent agent = it.next();
            if (agent instanceof Prisoner) {
                Prisoner p = (Prisoner)agent;
                Strategy s = p.getStrategy();
                double fitness = p.getFitness();

                if (s instanceof Cooperate) {
                    cooperateTotal += fitness;
                    cooperateCount++;
                } else if (s instanceof Cheat) {
                    cheatTotal += fitness;
                    cheatCount++;
                } else if (s instanceof RandomlyCooperate) {
                    randomTotal += fitness;
                    randomCount++;
                } else if (s instanceof TitForTat) {
                    titForTatTotal += fitness;
                    titForTatCount++;
                }
            }
        }

        return new String[] {
            "Cooperate Average Fitness: " + (cooperateCount > 0 ? cooperateTotal/cooperateCount : 0),
            "Cheat Average Fitness: " + (cheatCount > 0 ? cheatTotal/cheatCount : 0),
            "Random Average Fitness: " + (randomCount > 0 ? randomTotal/randomCount : 0),
            "TitForTat Average Fitness: " + (titForTatCount > 0 ? titForTatTotal/titForTatCount : 0)
        };
    }
} 