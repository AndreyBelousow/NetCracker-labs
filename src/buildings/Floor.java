package buildings;

import java.util.Iterator;

/**
 * Created by 1 on 01.11.2016.
 */
public interface Floor extends Comparable, Cloneable{

    public int getNumberOfSpaces();
    public double getTotalArea();
    public int getTotalNumberOfRooms();
    public Space[] getSpacesArray();
    public Space getSpace(int number);
    public void setSpace(int number, Space space);
    public void addSpace(int number, Space space);
    public void deleteSpace(int number);
    public Space getBestSpace();
    public Iterator iterator();

    //_________________
    public Object clone();
    public boolean equals(Object o);
    public int hashCode();
    public String toString();


    //_________________
    //Мои личные методы
    public void show();
}
