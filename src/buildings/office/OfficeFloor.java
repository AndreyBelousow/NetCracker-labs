package buildings.office;

import buildings.Floor;
import buildings.Space;
import buildings.exceptions.SpaceIndexOutOfBoundsException;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**Этаж офисного здания, основан на
 * односвязном списке*/
public class OfficeFloor implements Floor, Serializable, Iterable<Space> {

    //_________________________________________________________________________
    //Внутренний класс, реализующий односвязный список
    //Представляет отдельный узел списка
    private class ListNode implements Serializable{

        private Space office;//Текущий элемент
        private ListNode next;//Следующий элемент

        //Конструктор по умолчанию
        public ListNode(){
            //Сам элемент тоже по умолчанию, что характерно
            this.office = new Office();
            this.next = this;
        }

        //Конструктор по значащему элементу
        public ListNode(Space office){
            this.office = office;
            this.next = this;
        }

        //Конструктор по следующему
        public ListNode(ListNode next){
            this.office = new Office();
            this.next = next;
        }

        //По значащему и следующему
        public ListNode(ListNode next, Space office){
            this.next = next;
            this.office = office;
        }

    }
    //___________________________________________________________________________

    private ListNode head;//Голова списка

    //Конструктор по количеству офисов
    public OfficeFloor(int number){
        this.head = new ListNode();
        for(int i=0; i<number; i++){
            ListNode newNode = new ListNode(head);
            ListNode current = head;//TODO можно вынести все это в адд ту тейл
            for(int j=0; j<=i; j++){
                if(current.next == head){
                    current.next = newNode;
                }
                else current = current.next;
            }
        }
    }

    //Конструктор по массиву офисов
    public OfficeFloor(Space[] offices){
        this.head = new ListNode();
        for(int i=0; i<offices.length; i++){
            ListNode newNode = new ListNode(head, offices[i]);
            ListNode current = head;//TODO можно вынести все это в адд ту тейл
            for(int j=0; j<i; j++){
                if(current.next == head){
                    current.next = newNode;
                }
                else current = current.next;
            }
        }
    }

    //Добавление на этаж офиса по номеру и ссылке
    public void addSpace(int number, Space of){
        if(number> getNumberOfSpaces()) throw new SpaceIndexOutOfBoundsException();
        else {
            ListNode node = new ListNode(of);
            addNodeByNumber(number, node);
        }
    }

    //удаление офиса
    public void deleteSpace(int number){
        if(number> getNumberOfSpaces()) throw new SpaceIndexOutOfBoundsException();
        else {
            this.deleteNodeByNumber(number);
        }
    }

    //получение офиса с наибольшей площадью
    public Space getBestSpace(){
        int ar = 0;
        if(head.next==head) return null;
        Space best = head.next.office;
        ListNode current = head.next;
        while(true){
            if(current==head) return best;
            else{
                if (current.office.getArea()>best.getArea())
                    return best;
                current = current.next;
            }
        }
    }

    public void show(){
        ListNode current = head;
        do{
            current = current.next;
            current.office.show();
            System.out.print("  ");
        }while(current.next != head);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("OfficeFloor, ");
        sb.append(getNumberOfSpaces()+", [");
        for (Space s : getSpacesArray()){
            sb.append(s.toString());
        }
        sb.append("] ");
        return sb.toString();
    }

    public boolean equals(Object object){
        if (object.getClass()==this.getClass()){
            OfficeFloor obj = (OfficeFloor)object;
            if(getNumberOfSpaces()== obj.getNumberOfSpaces()){
                for(int i=0; i<getNumberOfSpaces();i++){
                    if(!(getSpacesArray()[i].equals(obj.getSpacesArray()[i]))) return false;
                }
                return true;
            }
            else return false;
        }
        else return false;
    }

    public Object clone(){
        OfficeFloor clonedFloor = new OfficeFloor(getNumberOfSpaces());
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

    //_____________________________________________________________________

    //Получение числа офисов на этаже
    public int getNumberOfSpaces(){
        if(head.next==head) return 0;
        ListNode current = head.next;
        int i=0;
        while(true){
            if(current==head) return i;
            else{
                i++;
                current = current.next;
            }
        }
    }

    //получение числа комнат на этаже
    public int getTotalNumberOfRooms(){
        int num = 0;
        if(head.next==head) return 0;
        ListNode current = head.next;
        while(true){
            if(current==head) return num;
            else{
                num+=current.office.getNumberOfRooms();
                current = current.next;
            }
        }
    }

    //Получение общей площади на этаже
    public double getTotalArea(){
        int ar = 0;
        if(head.next==head) return 0;
        ListNode current = head.next;
        while(true){
            if(current==head) return ar;
            else{
                ar+=current.office.getArea();
                current = current.next;
            }
        }
    }

    //Получение массива офисов
    public Space[] getSpacesArray(){
        Space arr[] = new Space[getNumberOfSpaces()];
        for(int i =0; i<arr.length; i++){arr[i] = (Space) getSpace(i);}
        return arr;
    }

    //Получение офиса по номеру
    public Space getSpace(int number){
        if(number> getNumberOfSpaces()) throw new SpaceIndexOutOfBoundsException();
        else return(getNodeByNumber(number).office);
    }

    //Изменение офиса по номеру и ссылке
    public void setSpace(int number, Space of){
        if(number> getNumberOfSpaces()) throw new SpaceIndexOutOfBoundsException();
        else {
            getNodeByNumber(number).office = of;
        }
    }

    //Получение узла по номеру - приватный
    private ListNode getNodeByNumber(int number){
        if(number> getNumberOfSpaces()) throw new SpaceIndexOutOfBoundsException();
        else {
            ListNode current = head;
            int i = 0;
            do {
                current = current.next;
                if (i == number) return current;
                i++;
            } while (current.next != head);
            return null;//TODO это жуткий костыль от ругательств компилятора
        }
    }

    //Удаление узла по номеру - приватный
    private void deleteNodeByNumber(int number){
        if(number> getNumberOfSpaces()) throw new SpaceIndexOutOfBoundsException();
        else {
            ListNode current = null;
            if (number == 0) current = head;
            else current = getNodeByNumber(number - 1);
            current.next = current.next.next;
        }
    }

    //Добавление узла по номеру и ссылке - приватный
    private void addNodeByNumber(int number, ListNode node){
        if(number> getNumberOfSpaces()) throw new SpaceIndexOutOfBoundsException();
        else {
            ListNode current = null;
            if (number == 0) current = head;
            else current = getNodeByNumber(number - 1);
            node.next = current.next;
            current.next = node;
        }
    }

}
