package simStation;

public class ObserverAgent extends Agent{


    public ObserverAgent(String name) {
        super(name);
    }

    public void update() {
        updateStatistics();
    }
}
