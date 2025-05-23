package simStation;

import mvc.*;

public class ResumeCommand extends Command {

    public ResumeCommand(Model model) {
        super(model);
    }

    public void execute() {
        World world = (World) model;
        world.resumeAgents();
    }
}
