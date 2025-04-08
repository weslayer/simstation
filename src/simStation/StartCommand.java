package simStation;

import mvc.*;

public class StartCommand extends Command {

    public StartCommand(Model model) {
        super(model);
    }

    public void execute() {
        World world = (World) model;
        world.startAgents();
    }
}
