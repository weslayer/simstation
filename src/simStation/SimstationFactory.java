package simStation;

import mvc.*;

public class SimstationFactory implements AppFactory {
    public Model makeModel() {
        return new Simstation();
    }

    public View makeView(Model m) {
        return new SimstationView((Simstation) m);
    }

    public String[] getEditCommands() {
        return new String[] { "Start", "Pause", "Resume", "Stop", "Stats" };
    }

    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "Start")
            return new ChangeCommand(model);
        if (type == "Pause")
            return new PauseCommand(model);
        if (type == "Resume")
            return new ResumeCommand(model);
        if (type == "Stop")
            return new StopCommand(model);
        if (type == "Stats")
            return new StatsCommand(model);
    }

    public String getTitle() {
        return "Simstation";
    }

    public String[] getHelp() {
        return new String[] {
                "Press start to begin simulation.",
                "Press pause to pause the simulation.",
                "Press resume to resume a paused simulation.",
                "Press stop to end a simulation.",
                "Press stats to see stats of a simulation."
        };
    }

    public String about() {
        return "Simstation version 1.0. Copyright 2025 by ___, ___, and Rustico Dela Cruz III.";
    }
}
