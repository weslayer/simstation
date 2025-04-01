import mvc.*;
import simStation.*;
import simStation.randomWalk.*;

public class App {
    public static void main(String[] args) throws Exception {
        WorldFactory factory = new RandomWalkFactory();
        AppPanel panel = new WorldPanel(factory);
        panel.display();
    }
}
