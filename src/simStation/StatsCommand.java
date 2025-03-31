package simStation;

import mvc.*;

public class StatsCommand extends Command {

    public StatsCommand(Model model) {
        super(model);
    }

    public void execute() {
        World world = (World) model;
        Utilities.inform(world.getStatus());
    }
}
