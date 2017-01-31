package buildings;

import java.util.Iterator;

/**
 * Created by 1 on 08.12.2016.
 */
public class SynchronizedFloor implements Floor{
    Floor floor;

    public SynchronizedFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public synchronized Iterator<Space> iterator() {
        return null;
    }

    @Override
    public synchronized int compareTo(Object o) {
        return floor.compareTo(o);
    }

    @Override
    public synchronized int getNumberOfSpaces() {
        return floor.getNumberOfSpaces();
    }

    @Override
    public synchronized int hashCode() {
        return floor.hashCode();
    }

    @Override
    public synchronized boolean equals(Object obj) {
        return floor.equals(obj);
    }

    @Override
    public synchronized String toString() {
        return floor.toString();
    }

    @Override
    public synchronized void show() {
        floor.show();
    }

    @Override
    public synchronized double getTotalArea() {
        return floor.getTotalArea();
    }

    @Override
    public synchronized int getTotalNumberOfRooms() {
        return floor.getTotalNumberOfRooms();
    }

    @Override
    public synchronized Space[] getSpacesArray() {
        return floor.getSpacesArray();
    }

    @Override
    public synchronized Space getSpace(int index) {
        return floor.getSpace(index);
    }

    @Override
    public synchronized void setSpace(int index, Space space) {
        floor.setSpace(index, space);
    }

    @Override
    public synchronized void addSpace(int index, Space space) {
        floor.addSpace(index, space);
    }

    @Override
    public synchronized void deleteSpace(int index) {
        floor.deleteSpace(index);
    }

    @Override
    public synchronized Space getBestSpace() {
        return floor.getBestSpace();
    }

    @Override
    public synchronized Object clone() {
        return floor.clone();
    }
}
