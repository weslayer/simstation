import mvc.*;
import randomWalk.*;
import simStation.*;

public class App {
    public static void main(String[] args) throws Exception {
        WorldFactory factory = new RandomWalkFactory();
        AppPanel panel = new WorldPanel(factory);
        panel.display();
    }
}
