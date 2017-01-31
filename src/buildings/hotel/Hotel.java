package buildings.hotel;

import buildings.Floor;
import buildings.Space;
import buildings.dwelling.Dwelling;

/**
 * Created by 1 on 01.12.2016.
 */
public class Hotel extends Dwelling {

    public Hotel(int numberOfFloors, int[] flats){
        super(numberOfFloors, flats);
    }

    public Hotel(Floor[] floors){
        super(floors);
    }

    public int getNumberOfStars(){
        int max=0;
        for(int i=0; i<getNumberOfFloors(); i++){
            if(getFloorsArray()[i].getClass()==HotelFloor.class){
                HotelFloor f = (HotelFloor) getFloorsArray()[i];
                if (max< f.getStars()) max = f.getStars();
            }
        }
        return max;
    }

    @Override
    public Space getBestSpace(){
        Space best = null;
        for(Floor f:getFloorsArray()){
            if(f.getClass()==HotelFloor.class) best = f.getSpace(0);
        }
        for(Floor f: getFloorsArray()){
            if(f.getClass()==HotelFloor.class) {
                HotelFloor hf = (HotelFloor) f;
                for (Space s : f.getSpacesArray()) {
                    if (best.getArea() * ((HotelFloor) f).getStars()*0.25<s.getArea()*((HotelFloor) f).getStars()*0.25) best=s;
                }
            }
        }
        return best;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Hotel, ");
        sb.append(getNumberOfStars());
        sb.append(getNumberOfFloors()+", (");
        for (Floor s : getFloorsArray()){
            sb.append(s.toString());
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object object){
        if (object.getClass()==this.getClass()){
            Hotel obj = (Hotel) object;
            if(getNumberOfFloors()== obj.getNumberOfFloors()){
                for(int i=0; i<getNumberOfSpaces();i++){
                    if(!(getFloorsArray()[i].equals(obj.getFloorsArray()[i]))) return false;
                    if(getNumberOfStars()!=obj.getNumberOfStars()) return false;
                }
                return true;
            }
            else return false;
        }
        else return false;
    }

    public int hashCode(){
        int hash = super.hashCode();
        hash^=getNumberOfStars();
        return hash;
    }

    //public Object clone(){}
}
