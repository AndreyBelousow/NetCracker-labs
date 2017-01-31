package buildings.hotel;

import buildings.Space;
import buildings.dwelling.DwellingFloor;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by 1 on 01.12.2016.
 */
public class HotelFloor extends DwellingFloor{

    private static final int DEFAULT_NUMBER_OF_STARS = 1;

    private int stars;

    public HotelFloor(int number){
        super(number);
        this.stars = DEFAULT_NUMBER_OF_STARS;
    }

    public HotelFloor(Space[] spaces){
        super(spaces);
        this.stars = DEFAULT_NUMBER_OF_STARS;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HotelFloor, ");
        sb.append(stars);
        sb.append(getNumberOfSpaces()+", [");
        for (Space s : getSpacesArray()){
            sb.append(s.toString());
        }
        sb.append("] ");
        return sb.toString();
    }

    public boolean equals(Object object){
        if (object.getClass()==this.getClass()){
            HotelFloor obj = (HotelFloor) object;
            if(getNumberOfSpaces()== obj.getNumberOfSpaces()){
                for(int i=0; i<getNumberOfSpaces();i++){
                    if(!(getSpacesArray()[i].equals(obj.getSpacesArray()[i]))) return false;
                    if(stars!=obj.getStars()) return false;
                }
                return true;
            }
            else return false;
        }
        else return false;
    }

    public int hashCode(){
        int hash = super.hashCode();
        hash^=stars;
        return hash;
    }

    //public Object clone(){}

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

    //________________________________

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}

