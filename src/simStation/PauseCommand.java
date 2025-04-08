package simStation;

import mvc.*;

public class PauseCommand extends Command {

    public PauseCommand(Model model) {
        super(model);
    }

    public void execute() {
        World world = (World) model;
        world.pauseAgents();
    }
}
