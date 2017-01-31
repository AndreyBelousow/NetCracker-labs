package buildings.dwelling;

import buildings.office.Office;
import buildings.Space;
import buildings.exceptions.InvalidRoomsCountException;
import buildings.exceptions.InvalidSpaceAreaException;

import java.io.Serializable;

/**Класс, представляющий квартиру
 * Объект хранит площадь квартиры и количество комнат*/
public class Flat implements Space, Serializable{

    private double area;//Площадь
    private int numberOfRooms;//Число комнат

    //Константы для конструктора по умолчанию
    private static final double DEFAULT_AREA = 50;
    private static final int DEFAULT_NUMBER_OF_ROOMS = 2;

    //Конструктор по умолчанию
    public Flat(){
        this.area = DEFAULT_AREA;
        this.numberOfRooms = DEFAULT_NUMBER_OF_ROOMS;
    }

    //Конструктор, принимающий только площадь
    public Flat(double area){
        try {
            this.area = area;
        }
        catch (InvalidSpaceAreaException e){}
        this.numberOfRooms = DEFAULT_NUMBER_OF_ROOMS;
    }

    //Конструктор, принимающий площадь и число комнат
    public Flat(double area, int number){
        try {
            this.area = area;
        }catch(InvalidSpaceAreaException e){}
        try {
            this.numberOfRooms = number;
        }catch(InvalidRoomsCountException e){}
    }

    public void show(){
        System.out.print("r:" + numberOfRooms + ",s:" + area);
    }

    public String toString(){
        return ("Flat, ("+numberOfRooms+", "+area+") ");
    }

    public boolean equals(Object object){
        if (object.getClass()==this.getClass()){
            if((((Flat) object).getArea()==this.getArea())&&((Flat) object).getNumberOfRooms()==this.getNumberOfRooms()) {
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

    //_________________________________________________

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
