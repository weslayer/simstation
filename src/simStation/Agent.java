package simStation;

import java.io.Serializable;
import java.util.Random;

public class Agent implements Serializable {
    protected int xc;
    protected int yc;
    protected boolean suspended;
    protected boolean stopped;
    protected World world;
    transient protected Thread myThread;

    private static final Random RANDOM = new Random();

    public Agent() {
        this.xc = RANDOM.nextInt(World.SIZE);
        this.yc = RANDOM.nextInt(World.SIZE);
        this.suspended = false;
        this.stopped = false;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public int getX() {
        return xc;
    }

    public int getY() {
        return yc;
    }

    public void start() {
        myThread = new Thread(this::run);
        myThread.start();
    }

    public void run() {
        onStart();
        while (!stopped) {
            try {
                if (!suspended) {
                    update();
                    Thread.sleep(20); // smooth animation
                } else {
                    Thread.sleep(100); // reduce CPU usage while suspended
                }
            } catch (InterruptedException e) {
                onInterrupted();
            }
        }
        onExit();
    }

    // Empty methods that can be overridden in subclasses
    protected void onStart() {
    }

    protected void onInterrupted() {
    }

    protected void onExit() {
    }

    public void update() {
        // To be implemented by subclasses
    }

    public void suspend() {
        suspended = true;
    }

    public void resume() {
        suspended = false;
    }

    public void stop() {
        stopped = true;
        if (myThread != null) {
            myThread.interrupt();
        }
    }
}
