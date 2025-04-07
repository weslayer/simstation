package prisoners;

public abstract class Agent {
    private double fitness;
    
    public Agent() {
        fitness = 0;
    }
    
    public double getFitness() {
        return fitness;
    }
    
    public void updateFitness(double delta) {
        fitness += delta;
    }
} 