package buildings.dwelling;

import buildings.*;
import buildings.exceptions.FloorIndexOutOfBoundsException;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**Класс, представляющий здание
 * Объект хранит массив этажей*/
public class Dwelling implements Building, Serializable, Iterable<Floor> {

    private Floor[] floors;//Массив этажей

    //Конструктор, принимающий количество этажей и массив к-ва квартир по этажам
    //В данном случае к-во этажей явно избыточно, но таковы требования задания
    public Dwelling(int floorsNumber, int[] flats){
        this.floors = new DwellingFloor[floorsNumber];
        for(int i=0; i<floors.length; i++){
            this.floors[i] = new DwellingFloor(flats[i]);
        }
    }

    public Dwelling(){}

    public Dwelling(int floorsNumber){
        this.floors = new DwellingFloor[floorsNumber];
        for(int i=0; i<floors.length; i++){
            this.floors[i] = new DwellingFloor(1);
        }
    }

    //Конструктор принимающий массив этажей
    public Dwelling(Floor[] newFloors){
        this.floors = new DwellingFloor[newFloors.length];
        for(int i=0; i<floors.length;i++){
            floors[i] = newFloors[i];
        }
    }

    //Добавление квартиры по номеру
    public void addSpace(int number, Space newFlat){
        if(number> getNumberOfSpaces()) throw new FloorIndexOutOfBoundsException();
        else {
            int roomsByAllFloors = 0;
            int currentFlat = 0;
            for (Floor floor : floors) {
                for (Space flat : floor.getSpacesArray()) {
                    if (currentFlat == number) {
                        floor.addSpace(currentFlat - roomsByAllFloors, newFlat);
                    }
                    currentFlat++;
                }
                roomsByAllFloors += floor.getNumberOfSpaces();
            }
        }
    }

    //Удаление квартиры по номеру
    public void deleteSpace(int number){
        if(number> getNumberOfSpaces()) throw new FloorIndexOutOfBoundsException();
        else {
            int roomsByAllFloors = 0;
            int currentFlat = 0;
            for (Floor floor : floors) {
                for (Space flat : floor.getSpacesArray()) {
                    if (currentFlat == number) {
                        floor.deleteSpace(currentFlat - roomsByAllFloors);
                    }
                    currentFlat++;
                }
                roomsByAllFloors += floor.getNumberOfSpaces();
            }
        }
    }

    //Получение квартиры с наибольшей площадью
    public Space getBestSpace(){
        Space bestSpace = new Flat(0,0);
        for(Floor floor : floors){
            if(bestSpace.getArea()<floor.getBestSpace().getArea()){
                bestSpace = floor.getBestSpace();
            }
        }
        return bestSpace;
    }

    //Получение отсортированного по убыванию массива квартир
    public Space[] getSortedSpacesArray(){
        Flat[] sortedFlats = new Flat[getNumberOfSpaces()];
        int n=0;
        for(Floor floor : floors){
            for(Space flat : floor.getSpacesArray())
                sortedFlats[n] = new Flat(flat.getArea(), flat.getNumberOfRooms());
                n++;
        }
        for(int i=0; i<sortedFlats.length; i++){
            if(sortedFlats[i].getArea()<sortedFlats[i+1].getArea()){
                Flat swap = sortedFlats[i];
                sortedFlats[i]=sortedFlats[i+1];
                sortedFlats[i+1]=swap;
            }
        }
        return sortedFlats;
    }

    public void show(){
        for(Floor floor : floors) {
            floor.show();
            System.out.println();
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Dwelling, ");
        sb.append(getNumberOfFloors()+", (");
        for (Floor s : floors){
            sb.append(s.toString());
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object object){
        if (object.getClass()==this.getClass()){
            Dwelling obj = (Dwelling) object;
            if(getNumberOfFloors()== obj.getNumberOfFloors()){
                for(int i=0; i<getNumberOfSpaces();i++){
                    if(!(getFloorsArray()[i].equals(obj.getFloorsArray()[i]))) return false;
                }
                return true;
            }
            else return false;
        }
        else return false;
    }

    public Object clone(){
        Dwelling clonedBuilding = new Dwelling(getNumberOfFloors());
        for(int i=0; i<getNumberOfFloors(); i++){
            clonedBuilding.setFloor(i, (Floor)getFloor(i).clone());
        }
        return clonedBuilding;
    }

    public int hashCode(){
        int hash = 0;
        for(Floor s : getFloorsArray()){
            hash^=s.hashCode();
        }
        return hash;
    }

    public Iterator<Floor> iterator(){
        return new Iterator<Floor>() {
            private int index;
            @Override
            public boolean hasNext() {
                return index<getNumberOfFloors();
            }

            @Override
            public Floor next() {
                if(!hasNext())
                    throw new NoSuchElementException();
                index++;
                return getFloor(index);
            }
        };
    }
    //___________________________________________________________

    public int getNumberOfFloors(){return floors.length;}

    public int getNumberOfSpaces(){
        int number = 0;
        for(Floor floor : floors) number += floor.getNumberOfSpaces();
        return number;
    }

    public double getTotalArea(){
        double area = 0;
        for(Floor floor : floors) area += floor.getTotalArea();
        return area;
    }

    public int getTotalNumberOfRooms(){
        int number = 0;
        for(Floor floor : floors) number += floor.getTotalNumberOfRooms();
        return number;
    }

    public Floor[] getFloorsArray(){return floors;}

    public Floor getFloor(int number){
        if(number> getNumberOfSpaces()) throw new FloorIndexOutOfBoundsException();
        else return floors[number];
    }

    public Space getSpace(int number){
        if(number> getNumberOfSpaces()) throw new FloorIndexOutOfBoundsException();
        else {
            int counter = 0;
            for (Floor floor : floors) {
                for (Space flat : floor.getSpacesArray()) {
                    if (counter == number) return flat;
                    counter++;
                }
            }
            return null;
        }
    }

    //Замена этажа на переданный
    public void setFloor(int number, Floor floor){
        if(number> getNumberOfSpaces()) throw new FloorIndexOutOfBoundsException();
        else {
            floors[number] = floor;
        }
    }

    //Замена квартиры
    public void setSpace(int number, Space flat){
        if(number> getNumberOfSpaces()) throw new FloorIndexOutOfBoundsException();
        else {
            getSpace(number).setArea(flat.getArea());
            getSpace(number).setNumberOfRooms(flat.getNumberOfRooms());
        }
    }

    public void getDescription(){
        System.out.println();
        System.out.println("Total area="+getTotalArea());
        System.out.println("Total flats="+ getNumberOfSpaces());
        System.out.println("Total rooms=" +getTotalNumberOfRooms());
        System.out.println("Best space=" +getBestSpace().getArea());
        System.out.println();
    }
}
