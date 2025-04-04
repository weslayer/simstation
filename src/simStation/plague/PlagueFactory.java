package simStation.plague;

import mvc.*;
import simStation.*;

public class PlagueFactory extends WorldFactory {
    public Model makeModel() {
        return new PlagueSimulation(20, 50, 100, 400, true);
    }

    public View makeView(Model m) {
        return new PlagueView((PlagueSimulation) m);
    }

    public String[] getEditCommands() {
        return new String[] { "Start", "Pause", "Resume", "Stop", "Stats" };
    }

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

    public String getTitle() {
        return "Plague Infection Simulation";
    }

    public String[] getHelp() {
        return new String[] {
                "Press start to begin simulation.",
                "Press pause to pause the simulation.",
                "Press resume to resume a paused simulation.",
                "Press stop to end a simulation.",
                "Press stats to see stats of a simulation.",
                "Adjust parameters of the disease and population with the sliders."
        };
    }
}
