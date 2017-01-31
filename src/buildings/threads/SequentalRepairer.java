package buildings.threads;

import buildings.Floor;

/**
 * Created by 1 on 08.12.2016.
 */
public class SequentalRepairer implements Runnable{
    private Floor floor;
    private Semaphore semaphore;

    public SequentalRepairer(Floor floor, Semaphore semaphore) {
        this.floor = floor;
        this.semaphore = semaphore;
    }

    @Override
    public void run(){

        for (int i = 0; i < floor.getNumberOfSpaces(); i++) {
            try {
                semaphore.beginRepair();
                System.out.println("__Repairing space number " + i + " with total area " + floor.getSpace(i).getArea() + "square meters");
                semaphore.endRepair();
            }
            catch (InterruptedException err){
                System.err.println(err);
            }
        }

    }
}

