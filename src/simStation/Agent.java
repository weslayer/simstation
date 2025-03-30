package simStation;

public class Agent extends Thread {
    private int xc;
    private int yc;
    private boolean paused;
    private boolean stopped;
    private String agentName;
    private Thread myThread;

    public Agent(String name) {
        this.xc = 0;
        this.yc = 0;
        this.paused = false;
        this.stopped = false;
        this.agentName = name;
        this.myThread = null;
    }

    public void run() {
        while (!this.paused) {
            this.update();
            sleep(20);
        }
    }

    public void pause() {
        this.paused = true;
    }

    @Override
    public void resume() {
        this.paused = false;
    }

    public void update() {
    }

    public void int getXPos() {
        return this.xc;
    }

    public void int getXPos() {
        return this.yc;
    }
}
