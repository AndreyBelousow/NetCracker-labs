package buildings.dwelling;

import buildings.Floor;
import buildings.Space;
import buildings.exceptions.SpaceIndexOutOfBoundsException;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**Класс, представляющий этаж
 * Объект хранит массив квартир*/
public class DwellingFloor implements Floor, Serializable, Iterable<Space> {

    private Space[] flats;//Массив квартир

    //Конструктор, принимающий число квартир
    public DwellingFloor(int number){
        this.flats = new Flat[number];
        for(int i=0; i<number; i++){
            flats[i] = new Flat();//В данном случае будут созданы квартиры по умолчанию
        }
    }

    //Конструктор, принимающий массив квартир
    public DwellingFloor(Space[] flats){
        this.flats = new Flat[flats.length];
        for(int i=0; i<flats.length; i++){
            this.flats[i] = new Flat(flats[i].getArea(), flats[i].getNumberOfRooms());
        }
    }

    public DwellingFloor(){}

    //Добавление квартиры на этаж
    public void addSpace(int number, Space flat){
        if(number>flats.length) throw new SpaceIndexOutOfBoundsException();
        else {
            Flat[] newFlats = new Flat[flats.length + 1];
            for (int i = 0; i < newFlats.length; i++) {
                newFlats[i] = new Flat();
                if (i < number) {
                    newFlats[i].setNumberOfRooms(flats[i].getNumberOfRooms());
                    newFlats[i].setArea(flats[i].getArea());
                } else if (i == number) {
                    newFlats[i].setNumberOfRooms(flat.getNumberOfRooms());
                    newFlats[i].setArea(flat.getArea());
                } else {
                    newFlats[i].setNumberOfRooms(flats[i - 1].getNumberOfRooms());
                    newFlats[i].setArea(flats[i - 1].getArea());
                }
            }
            flats = newFlats;
        }
    }

    //Удаление квартиры
    public void deleteSpace(int number){
        if(number>flats.length) throw new SpaceIndexOutOfBoundsException();
        else {
            Flat[] newFlats = new Flat[flats.length - 1];
            for (int i = 0; i < newFlats.length; i++) {
                newFlats[i] = new Flat();
                if (i < number) {
                    newFlats[i].setNumberOfRooms(flats[i].getNumberOfRooms());
                    newFlats[i].setArea(flats[i].getArea());
                } else {
                    newFlats[i].setNumberOfRooms(flats[i + 1].getNumberOfRooms());
                    newFlats[i].setArea(flats[i + 1].getArea());
                }
            }
            flats = newFlats;
        }
    }

    //Получение квартиры с наибольшей площадью
    public Space getBestSpace(){
        Space flat = flats[0];
        for(int i=0; i<flats.length; i++){
            if(flats[i].getArea()>flat.getArea()) flat = flats[i];
        }
        return flat;
    }

    public void show(){
        for(Space flat : flats){
            flat.show();
            System.out.print("  ");
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("DwellingFloor, ");
        sb.append(getNumberOfSpaces()+", [");
        for (Space s : flats){
            sb.append(s.toString());
        }
        sb.append("] ");
        return sb.toString();
    }

    public boolean equals(Object object){
        if (object.getClass()==this.getClass()){
            DwellingFloor obj = (DwellingFloor) object;
            if(getNumberOfSpaces()== obj.getNumberOfSpaces()){
                for(int i=0; i<getNumberOfSpaces();i++){
                    if(!(flats[i].equals(obj.getSpacesArray()[i]))) return false;
                }
                return true;
            }
            else return false;
        }
        else return false;
    }

    public Object clone(){
        DwellingFloor clonedFloor = new DwellingFloor(getNumberOfSpaces());
        for(int i=0; i<getNumberOfSpaces(); i++){
            clonedFloor.setSpace(i, (Space)getSpace(i).clone());
        }
        return clonedFloor;
    }

    public int hashCode(){
        int hash = 0;
        for(Space s : getSpacesArray()){
            hash^=s.hashCode();
        }
        return hash;
    }

    public Iterator<Space> iterator(){
        return new Iterator<Space>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < getNumberOfSpaces();
            }

            @Override
            public Space next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                index++;
                return getSpace(index);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Floor) {
            if (equals(o)) {
                return 0;
            }
            if (((Floor) o).getNumberOfSpaces() < getNumberOfSpaces())
                return 1;
            return -1;
        }
        return -2;
    }

    //_______________________________________________________

    public int getNumberOfSpaces(){
        return flats.length;
    }

    public double getTotalArea(){
        int area = 0;
        for(Space flat: flats){area+=flat.getArea();}
        return area;
    }

    public int getTotalNumberOfRooms(){
        int number = 0;
        for(Space flat: flats){number+=flat.getNumberOfRooms();}
        return number;
    }

    public Space[] getSpacesArray(){return flats;}

    public Space getSpace(int number){return flats[number];}

    //Замена квартиры на переданную
    public void setSpace(int number, Space flat){
        if(number>flats.length) throw new SpaceIndexOutOfBoundsException();
        else {
            flats[number].setArea(flat.getArea());
            flats[number].setNumberOfRooms(flat.getNumberOfRooms());
        }
    }
}
