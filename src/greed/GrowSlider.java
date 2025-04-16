package greed;

import mvc.Command;
import mvc.Model;

public class GrowSlider extends Command {


    public GrowSlider(Model model) {
        super(model);
    }

    public void execute(int g) {
        Meadow meadow = (Meadow)model;
        meadow.setGlobalGrowRate(g);
    }
}
