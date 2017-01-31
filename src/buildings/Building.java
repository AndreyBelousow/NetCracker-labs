package buildings;

/**
 * Created by 1 on 01.11.2016.
 */
public interface Building {
    public int getNumberOfFloors();
    public int getNumberOfSpaces();
    public double getTotalArea();
    public int getTotalNumberOfRooms();
    public Floor[] getFloorsArray();
    public Floor getFloor(int number);
    public void setFloor(int number, Floor floor);
    public Space getSpace(int number);
    public void setSpace(int number, Space space);
    public void addSpace(int number, Space space);
    public void deleteSpace(int number);
    public Space getBestSpace();
    public Space[] getSortedSpacesArray();

    //_________________
    public Object clone();
    public boolean equals(Object o);
    public int hashCode();
    public String toString();


    //Мои личные методы
    //________________
    public void show();
    public void getDescription();
}
