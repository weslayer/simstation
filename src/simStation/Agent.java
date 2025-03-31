package simStation;

import java.io.Serializable;

public class Agent extends Thread implements Runnable, Serializable {
    private int xc;
    private int yc;
    private boolean paused = false;
    private boolean stopped = false;
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

    @Override
    public void stop() { this.stopped = true;}

    public int getXPos() { return this.xc; }

    public int getXPos() {
        return this.yc;
    }

    public void setThread(World world) {
        myThread = //something;
    }
}
