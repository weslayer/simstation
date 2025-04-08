package simStation.plague;

import mvc.*;

public class NotFatalCommand extends Command {

    public NotFatalCommand(Model model) {
        super(model);
    }

    public void execute() {
        PlagueSimulation plagueSimulation = (PlagueSimulation) model;
        plagueSimulation.FATAL = false;
    }
}
