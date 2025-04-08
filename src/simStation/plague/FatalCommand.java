package simStation.plague

import mvc.*;

public class FatalCommand extends Command {

    public FatalCommand(Model model) {
        super(model);
    }

    public void execute() {
        PlagueSimulation plagueSimulation = (PlagueSimulation) model;
        plagueSimulation.FATAL = true;
    }
}
