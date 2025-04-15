package greed;

import mvc.Command;
import mvc.Model;

public class MoveSlider extends Command {


    public MoveSlider(Model model) {
        super(model);
    }

    public void execute(int g) {
        Meadow meadow = (Meadow)model;
        meadow.setMoveEnergy(g);
    }
}
