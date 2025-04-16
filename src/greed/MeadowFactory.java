package greed;

import mvc.Command;
import mvc.Model;
import mvc.View;
import simStation.*;

public class MeadowFactory extends WorldFactory {
    public Model makeModel() {
        return new Meadow();
    }

    public View makeView(Model m) {
        return new MeadowView(m);
    }

    public String[] getEditCommands() {
        return new String[] { "Start", "Pause", "Resume", "Stop", "Stats", "Greed", "Grow", "Move" };
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
        if (type == "Greed")
            return new GreedSlider(model);
        if (type == "Grow")
            return new GrowSlider(model);
        if (type == "Move")
            return new MoveSlider(model);
        return null;
    }


    public String getTitle() {
        return "Greedy Pastures";
    }


    public String about() {
        return "Greedy Pastures version 1.0. Copyright 2025 by Nicholas pang, ___, and Rustico Dela Cruz III.";
    }

}
