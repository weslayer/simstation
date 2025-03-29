package simStation;

import mvc.*;

public class ResumeCommand extends Command {

    public StartCommand(Model model) {
        super(model);
    }

    public void execute() {
        Simstation simstation = (Simstation) model;
        simstation.resume();
    }
}
