package simStation;

import mvc.*;

public class PauseCommand extends Command {

    public StartCommand(Model model) {
        super(model);
    }

    public void execute() {
        Simstation simstation = (Simstation) model;
        simstation.pause();
    }
}
