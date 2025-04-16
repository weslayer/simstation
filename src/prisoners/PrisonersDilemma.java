package prisoners;

import mvc.AppPanel;
import simStation.WorldFactory;

public class PrisonersDilemma {
    public static void main(String[] args) {
        WorldFactory factory = new PrisonersFactory();
        AppPanel panel = new PrisonersPanel(factory);
        panel.display();
    }
} 