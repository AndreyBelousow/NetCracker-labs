package buildings.threads;

/**
 * Created by 1 on 08.12.2016.
 */

public class Semaphore {

    private boolean canRepair = true;

    public synchronized void beginRepair() throws InterruptedException {
        while (!canRepair) {
            wait();
        }
    }

    public synchronized void endRepair() {
        canRepair = false;
        notifyAll();
    }

    public synchronized void beginClean() throws InterruptedException {
        while (canRepair) {
            wait();
        }
    }

    public synchronized void endClean() {
        canRepair = true;
        notifyAll();
    }
}
