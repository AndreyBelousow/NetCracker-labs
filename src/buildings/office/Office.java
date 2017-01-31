package buildings.office;

import buildings.Space;
import buildings.exceptions.InvalidRoomsCountException;
import buildings.exceptions.InvalidSpaceAreaException;

import java.io.Serializable;

/**Класс, представляющий офис
 * Хранит свою площадь и к-во комнат*/
public class Office implements Space, Serializable {

    private double area;
    private int numberOfRooms;

    //Константы для конструктора по умолчанию
    private static final double DEFAULT_AREA = 250;
    private static final int DEFAULT_NUMBER_OF_ROOMS = 1;

    //Конструктор по умолчанию
    public Office(){
        this.area = DEFAULT_AREA;
        this.numberOfRooms = DEFAULT_NUMBER_OF_ROOMS;
    }

    //Конструктор по площади
    public Office(double area){
        try {
            this.area = area;
        }catch(InvalidSpaceAreaException e){}
        this.numberOfRooms = DEFAULT_NUMBER_OF_ROOMS;
    }

    //Конструктор по площади и числу комнат
    public Office(double area, int numberOfRooms){
        try {
            this.numberOfRooms = numberOfRooms;
        }catch(InvalidRoomsCountException e){}
        try {
            this.area = area;
        }catch(InvalidSpaceAreaException e){}
    }

    //Конструктор по переданному элементу
    public Office(Office of){
        try {
            this.area = of.getArea();
        }catch(InvalidSpaceAreaException e){}
        try {
            this.numberOfRooms = of.getNumberOfRooms();
        }catch(InvalidRoomsCountException e){}
    }

    public void show(){
        System.out.print("r:" + numberOfRooms + ",s:" + area);
    }

    public String toString(){
        return ("Office, ("+numberOfRooms+", "+area+") ");
    }

    public boolean equals(Object object){
        if (object.getClass()==this.getClass()){
            if((((Office) object).getArea()==this.getArea())&&((Office) object).getNumberOfRooms()==this.getNumberOfRooms()) {
                return true;
            }
            else return false;
        }
        else return false;
    }

    public int hashCode(){
        return (int)(((int)area^numberOfRooms)^(((long)area>>4)^numberOfRooms));
    }

    public Object clone(){
        return new Office(area, numberOfRooms);
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Space){
            if(equals(o)){
                return 0;
            }
            if(((Space) o).getArea() < getArea())
                return 1;
            return -1;
        }
        return -2;
    }
    //______________________________________________________________________

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
