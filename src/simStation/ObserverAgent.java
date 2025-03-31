package simStation;

public class ObserverAgent extends Agent {
    public ObserverAgent() {
        super("Observer");
    }
    
    public ObserverAgent(String name) {
        super(name);
    }

    @Override
    public void update() {
        if (world != null) {
            world.updateStatistics();
        }
    }
}
