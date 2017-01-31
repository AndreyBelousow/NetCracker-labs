package buildings;

/**
 * Created by 1 on 01.11.2016.
 */
public interface Space extends Comparable, Cloneable{

    public int getNumberOfRooms();
    public double getArea();
    public void setNumberOfRooms(int number);
    public void setArea(double area);

    //_________________

    public Object clone();
    public boolean equals(Object o);
    public int hashCode();
    public String toString();

    //_________________
    //Мои личные методы
    public void show();
}
