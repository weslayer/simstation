import mvc.*;
import simStation.*;
import plague.*;
import prisoners.*;
import randomWalk.*;
import greed.*;
public class App {
    public static void main(String[] args) throws Exception {
        AppPanel panel = new WorldPanel(new RandomWalkFactory());
        AppPanel panel2 = new PlaguePanel(new PlagueFactory());
        AppPanel panel3 = new PrisonersPanel(new PrisonersFactory());
        AppPanel panel4 = new MeadowPanel(new MeadowFactory());
        panel.display();
        panel2.display();
        panel3.display();
        panel4.display();
    }
}