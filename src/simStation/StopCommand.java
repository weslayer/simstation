package simStation;

import mvc.*;

public class StopCommand extends Command {

    public StopCommand(Model model) {
        super(model);
    }

    public void execute() {
        World world = (World) model;
        world.stopAgents();
    }
}
