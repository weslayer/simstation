package prisoners;

import mvc.*;

public class PrisonersDilemma {
    public static void main(String[] args) {
        AppFactory factory = new PrisonersFactory();
        AppPanel panel = new PrisonersPanel(factory);
        panel.display();
    }
} 