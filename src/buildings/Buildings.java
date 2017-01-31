package buildings;

import buildings.factories.BuildingFactory;
import buildings.factories.DwellingFactory;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Buildings {

    private static BuildingFactory factory = new DwellingFactory();

    //Байтовый ввод
    public static void outputBuilding (Building building, OutputStream out) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(building.getNumberOfFloors());
        sb.append(" ");
        for (int i = 0; i < building.getNumberOfFloors(); i++) {
            sb.append(building.getFloor(i).getNumberOfSpaces());
            sb.append(" ");
            for (int j = 0; j < building.getFloor(i).getNumberOfSpaces(); j++) {
                sb.append(building.getFloor(i).getSpace(j).getArea());
                sb.append(" ");
                sb.append(building.getFloor(i).getSpace(j).getNumberOfRooms());
                sb.append(" ");
            }
            out.write(sb.toString().getBytes());
        }
    }

    //Байтовый вывод
    public static Building inputBuilding(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        int pointer;
        while ((pointer=in.read())!=-1){sb.append((char)pointer);}
        String[] numbers = sb.toString().split(" ");
        int counter = 0;
        Floor[] floors = new Floor[Integer.parseInt(numbers[counter])];
        counter++;
        for (int i = 0; i < floors.length; i++) {
            Space[] spaces = new Space [Integer.parseInt(numbers[counter])];
            counter++;
            for (int j = 0; j < spaces.length; j++) {
                double area = Double.parseDouble(numbers[counter]);
                counter++;
                int rooms = Integer.parseInt(numbers[counter]);
                counter++;
                spaces[j]=factory.createSpace(rooms, area);
            }
            floors[i]=factory.createFloor(spaces);
        }
        return factory.createBuilding(floors);
    }

    //Символьный вывод
    public static void writeBuilding (Building building, Writer out) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(building.getNumberOfFloors());
        sb.append(" ");
        for (int i = 0; i < building.getNumberOfFloors(); i++) {
            sb.append(building.getFloor(i).getNumberOfSpaces());
            sb.append(" ");
            for (int j = 0; j < building.getFloor(i).getNumberOfSpaces(); j++) {
                sb.append(building.getFloor(i).getSpace(j).getArea());
                sb.append(" ");
                sb.append(building.getFloor(i).getSpace(j).getNumberOfRooms());
                sb.append(" ");
            }
            out.write(sb.toString());
        }
    }

    //Символьный ввод
    public static Building readBuilding (Reader in) throws IOException {
        StreamTokenizer st = new StreamTokenizer(in);
        st.nextToken();
        Floor[] floors = new Floor[(int)st.nval];
        st.nextToken();
        for (int i = 0; i < floors.length; i++) {
            Space[] spaces = new Space[(int)st.nval];
            st.nextToken();
            for (int j = 0; j < spaces.length; j++) {
                int rooms =(int) st.nval;
                st.nextToken();
                double area = st.nval;
                st.nextToken();
                spaces[i]=factory.createSpace(rooms, area);
            }
            floors[i]=factory.createFloor(spaces);
        }
        return factory.createBuilding(floors);
    }

    public static Building readBuilding (Scanner in){
        in.next();
        Floor[] floors = new Floor[in.nextInt()];
        in.next();
        for (int i = 0; i < floors.length; i++) {
            Space[] spaces = new Space[in.nextInt()];
            in.next();
            for (int j = 0; j < spaces.length; j++) {
                int rooms = in.nextInt();
                in.next();
                double area = in.nextDouble();
                in.next();
                spaces[i]=factory.createSpace(rooms, area);
            }
            floors[i]=factory.createFloor(spaces);
        }
        return factory.createBuilding(floors);
    }

    public static void writeBuildingFormat(Building building,Writer out) {
        PrintWriter pw = new PrintWriter(out);
        pw.printf("%d",building.getNumberOfFloors());
        for (int i = 0; i < building.getNumberOfFloors(); i++) {
            pw.printf("%d", building.getFloor(i).getNumberOfSpaces());
            for (int j = 0; j <
                    building.getFloor(i).getNumberOfSpaces(); j++) {
                pw.printf("%d", building.
                        getFloor(i).getSpace(j).getNumberOfRooms());
                pw.printf("%f", building.
                        getFloor(i).getSpace(j).getArea());
            }
        }
    }

    public static <T> void sortBuildings(T obj){
        if(obj instanceof Floor){
            Floor floor = (Floor)obj;
            List<Space> list = Arrays.asList(floor.getSpacesArray());
            Collections.sort(list, (Space o1, Space o2) -> Integer.compare( o2.getNumberOfRooms(), o1.getNumberOfRooms()));
        }
        else if(obj instanceof Building){
            Building build = (Building)obj;
            List<Floor> list = Arrays.asList(build.getFloorsArray());
            Collections.sort(list, (Floor o1, Floor o2) -> Double.compare( o2.getTotalArea(), o1.getTotalArea()));
        }
    }

    //Сортировки по возрастанию и убыванию
    public static <T extends  Comparable<T>> T[] sortArray(T[] arr){
        for(int i = 0; i<arr.length; i++){
            for(int j = i; j<arr.length; j++){
                if(arr[i].compareTo(arr[j])== 1){
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static <T> T[] negativeSortArray(T[] arr, Comparator<T> comparator){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (comparator.compare(arr[i], arr[j])==1){
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void setBuildingFactory(BuildingFactory bf){
        factory = bf;
    }

    //________________________________________________
    //Создание объектов фабрикой

    public static Space createSpace(double area) {
        return factory.createSpace(area);
    }

    public static Space createSpace(double area, Class<? extends Space> spaceClass){
        try{
            return spaceClass.getConstructor(double.class).newInstance(area);
        }
        catch (InstantiationException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException |
                NoSuchMethodException | SecurityException ex){
            throw new IllegalArgumentException();
        }
    }

    public static Space createSpace(int roomsCount, double area) {
        return factory.createSpace(roomsCount, area);
    }

    public static Space createSpace(int roomsCount, double area, Class<? extends Space> spaceClass){
        try{
            return spaceClass.getConstructor(double.class, int.class).newInstance(area, roomsCount);
        }
        catch (InstantiationException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException |
                NoSuchMethodException | SecurityException ex){
            throw new IllegalArgumentException();
        }
    }

    public static Floor createFloor(int spacesCount) {
        return factory.createFloor(spacesCount);
    }

    public static Floor createFloor(Space[] spaces) {
        return factory.createFloor(spaces);
    }

    public static Floor createFloor(int spacesCount, Class<? extends Floor> floorClass){
        try{
            return floorClass.getConstructor(int.class).newInstance(spacesCount);
        }
        catch (InstantiationException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException |
                NoSuchMethodException | SecurityException ex){
            throw new IllegalArgumentException();
        }
    }

    public static Floor createFloor(Class<? extends Floor> floorClass, Space... spaces){
        try{
            return floorClass.getConstructor(spaces.getClass()).newInstance((Object) spaces);
        }
        catch (InstantiationException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException |
                NoSuchMethodException | SecurityException ex){
            throw new IllegalArgumentException();
        }
    }

    public static Building createBuilding(int floorsCount, int[] spacesCounts) {
        return factory.createBuilding(floorsCount, spacesCounts);
    }

    public static Building createBuilding(Floor[] floors) {
        return factory.createBuilding(floors);
    }

    public static Building createBuilding(int floorsCount,
                                          Class<? extends Building> buildingClass, int... spacesCounts){
        try{
            return buildingClass.getConstructor(int.class, int[].class).newInstance(floorsCount, spacesCounts);
        }
        catch (InstantiationException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException |
                NoSuchMethodException | SecurityException ex){
            throw new IllegalArgumentException();
        }
    }

    public static Building createBuilding(Class<? extends Building> buildingClass, Floor... floors){
        try{
            return buildingClass.getConstructor(floors.getClass()).newInstance((Object) floors);
        }
        catch (InstantiationException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException |
                NoSuchMethodException | SecurityException ex){
            throw new IllegalArgumentException();
        }
    }
}

