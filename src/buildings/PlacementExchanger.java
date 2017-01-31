package buildings;

import buildings.exceptions.FloorIndexOutOfBoundsException;
import buildings.exceptions.InexchangeableFloorsException;
import buildings.exceptions.InexchangeableSpacesException;
import buildings.exceptions.SpaceIndexOutOfBoundsException;

public class PlacementExchanger {

    //Провверка возможности обмена помещениями
    public static boolean canExchangeSpaces(Space one, Space two){
        if((one.getArea()==two.getArea())&&(one.getNumberOfRooms()==two.getNumberOfRooms())) return true;
        else return false;
    }

    //Провверка возможности обмена этажами
    public static boolean canExchangeFloors(Floor one, Floor two){
        if((one.getTotalArea()==two.getTotalArea())&&(one.getNumberOfSpaces()==two.getNumberOfSpaces())) return true;
        //TODO потенциальная ошибка, не оговоренная в условии - совпадение площади и числа помещений при разном числе комнат
        else return false;
    }

    //Метод обмена помещениями двух этажей
    public static void exchangeFloorRooms(Floor floor1, int index1, Floor floor2, int index2) throws InexchangeableSpacesException {
        //Проверка допустимости номеров помещений
        try{
            floor1.getSpace(index1);
            floor2.getSpace(index2);
        }
        catch(SpaceIndexOutOfBoundsException e){}

        if(canExchangeSpaces(floor1.getSpace(index1),floor2.getSpace(index2))){
            //Защита от замены с одинаковыми индексами
            Space tmp = floor1.getSpace(index1);
            floor1.setSpace(index1, floor2.getSpace(index2));
            floor2.setSpace(index2,tmp);
        }
        else throw new InexchangeableSpacesException();
    }

    //Метод обмена этажами двух зданий
    public static void exchangeBuildingFloors(Building building1, int index1, Building building2, int index2) throws InexchangeableFloorsException {
        //Проверка допустимости номеров помещений
        try{
            building1.getFloor(index1);
            building2.getFloor(index2);
        }
        catch(FloorIndexOutOfBoundsException e){}

        if(canExchangeFloors(building1.getFloor(index1),building2.getFloor(index2))){
            //Защита от замены с одинаковыми индексами
            Floor tmp = building1.getFloor(index1);
            building1.setFloor(index1, building2.getFloor(index2));
            building2.setFloor(index2,tmp);
        }
        else throw new InexchangeableFloorsException();
    }


}
