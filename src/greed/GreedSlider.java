package greed;

import mvc.Command;
import mvc.Model;

public class GreedSlider extends Command {

    public GreedSlider(Model model) {
        super(model);
    }

    public void execute(int g) {
        Meadow meadow = (Meadow)model;
        meadow.setGlobalGreed(g);
    }
}
