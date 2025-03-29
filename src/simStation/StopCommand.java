package simStation;

import mvc.*;

public class StopCommand extends Command {

    public StartCommand(Model model) {
        super(model);
    }

    public void execute() {
        Simstation simstation = (Simstation) model;
        simstation.stop();
    }
}
