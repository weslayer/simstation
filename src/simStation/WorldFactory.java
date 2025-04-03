package simStation;

import mvc.*;

public class WorldFactory implements AppFactory {
    public Model makeModel() {
        return new World();
    }

    public View makeView(Model m) {
        return new WorldView((World) m);
    }

    public String[] getEditCommands() {
        return new String[] { "Start", "Pause", "Resume", "Stop", "Stats" };
    }

    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "Start")
            return new StartCommand(model);
        if (type == "Pause")
            return new PauseCommand(model);
        if (type == "Resume")
            return new ResumeCommand(model);
        if (type == "Stop")
            return new StopCommand(model);
        if (type == "Stats")
            return new StatsCommand(model);
        return null;
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
        return "Simstation version 1.0. Copyright 2025.";
    }
}
