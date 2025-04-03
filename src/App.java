import mvc.*;
import simStation.*;
import simStation.plague.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Test, should work:
        // AppPanel panel = new WorldPanel(new RandomWalkFactory());
        AppPanel panel = new WorldPanel(new PlagueFactory());
        panel.display();
    }
}
