package buildings.office;

import buildings.Building;
import buildings.Floor;
import buildings.Space;
import buildings.exceptions.FloorIndexOutOfBoundsException;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**Класс офисного здания
 * Основан на двусвязном циклическом списке с выделенной головой
 */
public class OfficeBuilding implements Building, Serializable, Iterable<Floor> {

    //________________________________________________________________________
    //Внутренний класс, представляющий отдельный узел двусвязного списка
    private class ListNode implements Serializable{

        private Floor floor;//Текущий элемент
        private ListNode next;//Следующий элемент
        private ListNode prev;//Предыдущий

        //Конструктор по умолчанию
        public ListNode(){
            //Сам элемент тоже по умолчанию, что характерно
            //this.floor = new OfficeFloor();
            this.next = this;
            this.prev = this;
        }

        //Конструктор по значащему элементу
        public ListNode(Floor floor){
            this.floor = floor;
            this.next = this;
            this.prev = this;
        }

        //Конструктор по следующему и предыдущему
        public ListNode(ListNode next, ListNode prev){
            //this.floor = new OfficeFloor();
            this.next = next;
            this.prev = prev;
        }

        //По значащему и след\пред
        public ListNode(ListNode next, ListNode prev, Floor floor){
            this.floor = floor;
            this.next = next;
            this.prev = prev;
        }
    }
    //________________________________________________________________________

    private ListNode head;//Голова списка

    //Конструктор по к-ву этажей и массиву к-ва офисов
    //Опять - таки, к-во этажей здесь явно излишне
    //Но таковы уж требования задания
    public OfficeBuilding(int floors, int[] offices){
        this.head = new ListNode();
        for(int i=0; i<offices.length; i++){
            OfficeFloor floor = new OfficeFloor(offices[i]);
            ListNode node = new ListNode(floor);
            addToHead(node);
        }
    }

    public OfficeBuilding(int floors){
        this.head = new ListNode();
        for(int i=0; i<floors; i++){
            OfficeFloor floor = new OfficeFloor(1);
            ListNode node = new ListNode(floor);
            addToHead(node);
        }
    }

    //Конструктор по массиву этажей
    public OfficeBuilding(Floor[] offices){
        this.head = new ListNode();
        for(int i=0; i<offices.length; i++){
            ListNode node = new ListNode(offices[i]);
            addToHead(node);
        }
    }

    public int getNumberOfFloors(){
        int num = 0;
        ListNode current = head;
        while(current.next!=head){
            current = current.next;
            num++;
        }
        return num;
    }

    public int getNumberOfSpaces(){
        ListNode current = head;
        int num = 0;
        while(current.next!=head){
            current = current.next;
            num+=current.floor.getNumberOfSpaces();
        }
        return num;
    }

    public int getTotalNumberOfRooms(){
        ListNode current = head;
        int num = 0;
        while(current.next!=head){
            current = current.next;
            num+=current.floor.getTotalNumberOfRooms();
        }
        return num;
    }

    public double getTotalArea(){
        ListNode current = head;
        double sqr = 0;
        while(current.next!=head){
            current = current.next;
            sqr+=current.floor.getTotalArea();
        }
        return sqr;
    }

    public Floor[] getFloorsArray(){
        Floor[] floors = new Floor[getNumberOfFloors()];
        for(int i=0; i< floors.length; i++){
            floors[i] = getNodeByNumber(i).floor;
        }
        return floors;
    }

    public Floor getFloor(int number){
        if(number> getNumberOfSpaces()) throw new FloorIndexOutOfBoundsException();
        else {
            return getNodeByNumber(number).floor;
        }
    }

    public void setFloor(int number, Floor floor){
        if(number> getNumberOfSpaces()) throw new FloorIndexOutOfBoundsException();
        else {
            getNodeByNumber(number).floor = floor;
        }
    }

    public Space getSpace(int number){
        if(number> getNumberOfSpaces()) throw new FloorIndexOutOfBoundsException();
        else {
            int counter = 0;
            ListNode current = head.next;
            while (current.next != head) {
                current = current.next;
                for (Space office : current.floor.getSpacesArray()) {
                    if (counter == number) return office;
                    counter++;
                }
            }
            return null;
        }
    }

    public void setSpace(int number, Space office){
        if(number> getNumberOfSpaces()) throw new FloorIndexOutOfBoundsException();
        else {
            //TODO подумать верно ли это
            int officesByFloors = 0;
            ListNode current = head.next;
            while (current.next != head) {
                current = current.next;
                int counter = 0;
                for (Space of : current.floor.getSpacesArray()) {
                    if (counter + officesByFloors == number) current.floor.setSpace(counter, office);
                    counter++;
                }
                officesByFloors+=counter;
            }
        }
    }

    public void addSpace(int number, Space office){
        if(number> getNumberOfSpaces()) throw new FloorIndexOutOfBoundsException();
        else {
            //TODO подумать верно ли это
            int officesByFloors = 0;
            ListNode current = head.next;
            while (current.next != head) {
                current = current.next;
                int counter = 0;
                for (Space of : current.floor.getSpacesArray()) {
                    if (counter + officesByFloors == number) current.floor.addSpace(counter, office);
                    counter++;
                }
                officesByFloors+=counter;
            }
        }
    }

    public void deleteSpace(int number){
        if(number> getNumberOfSpaces()) throw new FloorIndexOutOfBoundsException();
        else {
            //TODO подумать верно ли это
            int officesByFloors = 0;
            ListNode current = head.next;
            while (current.next != head) {
                current = current.next;
                int counter = 0;
                for (Space of : current.floor.getSpacesArray()) {
                    if (counter + officesByFloors == number) current.floor.deleteSpace(counter);
                    counter++;
                }
                officesByFloors+=counter;
            }
        }
    }

    public Space getBestSpace(){
        ListNode current = head.next;
        Space best = current.floor.getSpace(0);
        while(current.next!=head){
            current = current.next;
            for(Space of: current.floor.getSpacesArray()){
                if(of.getArea()>best.getArea()) best = of;
            }
        }
        return best;
    }

    public Space[] getSortedSpacesArray(){
        Space[] offices = new Space[getNumberOfSpaces()];

        ListNode current = head.next;
        int n=0;
        while (current.next != head) {
            current = current.next;
            for (Space of : current.floor.getSpacesArray()) {
                offices[n] = of;
                n++;
            }
        }
        for(int i=0; i<offices.length; i++){
            if(offices[i].getArea()>offices[i+1].getArea()){
                Space swap = offices[i];
                offices[i] = offices[i+1];
                offices[i+1] = swap;
            }
        }
        return offices;
    }

    public void show(){
        ListNode current = head.next;
        while(current.next!=head) {
            current = current.next;
            current.floor.show();
            System.out.println();
        }
    }

    public void getDescription(){
        System.out.println();
        System.out.println("Total area="+getTotalArea());
        System.out.println("Total offices="+ getNumberOfSpaces());
        System.out.println("Total rooms=" +getTotalNumberOfRooms());
        System.out.println("Best space=" +getBestSpace().getArea());
        System.out.println();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("OfficeBuilding, ");
        sb.append(getNumberOfFloors()+", (");
        for (Floor s : getFloorsArray()){
            sb.append(s.toString());
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean equals(Object object){
        if (object.getClass()==this.getClass()){
            OfficeBuilding obj = (OfficeBuilding) object;
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
        OfficeBuilding clonedBuilding = new OfficeBuilding(getNumberOfFloors());
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
    //__________________________________________________________________

    //Добавление нового узла на нулевое место
    private void addToHead(ListNode node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    //Добавление узла - приватный
    private void addNodeByNumber(int number, ListNode node){
        ListNode current = head.next;
        int i = 0;
        while(i!=number){
            current = current.next;
            i++;
        }
        node.next = current;
        node.prev = current.prev;
        node.next.prev = node;
        node.prev.next = node;
    }

    //Удаление узла - приватный
    private void deleteNode(int number){
        ListNode current = head.next;
        int i = 0;
        while(i!=number){
            current = current.next;
            i++;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
    }

    //Получение узла - приватный
    private ListNode getNodeByNumber(int number){
        ListNode current = head.next;
        int i = 0;
        while(i!=number){
            current = current.next;
            i++;
        }
        return current;
    }
}
