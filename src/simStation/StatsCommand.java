package simStation;

import mvc.*;

public class StatsCommand extends Command {

    public StartCommand(Model model) {
        super(model);
    }

    public void execute() {
        World world = (World) model;
        Utilities.inform(world.getStatus());
    }
}
