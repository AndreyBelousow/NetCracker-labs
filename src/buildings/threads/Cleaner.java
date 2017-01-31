package buildings.threads;

import buildings.Floor;

/**
 * Created by 1 on 08.12.2016.
 */
public class Cleaner extends Thread{
    private Floor floor;

    public Cleaner(Floor floor) {
        this.floor = floor;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; !isInterrupted() && i < floor.getNumberOfSpaces(); i++) {
            System.out.println("Cleaning room number " + i + " with total area " + floor.getSpace(i).getArea() + "square meters");
        }
    }
}
