package simStation.prisoners;

import mvc.AppPanel;

public class PrisonerTest {
    public static void main(String[] args) {
        AppPanel panel = new AppPanel(new PrisonerFactory());
        panel.display();
    }
} 