import mvc.*;
import plague.*;
import randomWalk.*;
import simStation.*;
<<<<<<< HEAD
import simStation.plague.*;
=======
>>>>>>> dfd7a77 (put packages outside of simstation)

public class App {
    public static void main(String[] args) throws Exception {
        // Test, should work:
        // AppPanel panel = new WorldPanel(new RandomWalkFactory());
        AppPanel panel = new PlaguePanel(new PlagueFactory());
        panel.display();
    }
}
