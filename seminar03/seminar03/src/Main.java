/*
Задача 1 - Реализуем односвязный список
Класс Node для хранения элементов списка
Класс List для хранения списка элеметов
 */

class List{

    Node head;
    Node tail;

    class Node{
        int value;
        Node next;
        Node prev;
    }

    /*
    Задача 2 - Релизуем функционал добавления и удаление данных в начало списка
    Метод pushFront класса List для добавления в начало списка
    Метод popFront класса List для удаления из начала списка
    */

//    public void pushFront(int value){ // вставка новой ноды
//        Node node = new Node(); // выделяем место для ноды
//        node.value = value; // Устанавливаем значение пришедшее в функцию ноде
//        node.next = head; // помещяем новый элемент в начало, при этом ссылка на следующий элемент становится старым начальным элементом списка
//        head = node; // начальный элемент становится новой создонной нодой
//    }

//    public void popFront(){ // удаление ноды
//        if (head != null){
//            head = head.next;// заменяем ссылку на старый элемент меняем на следующий элемент после старого
//        }
//    }

    public void print(){
        Node cur = head;
        while (cur != null){
            System.out.printf("%d ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }

    /*
    Задача 3 - Проверка вхождения элементов в список
    Метод contains для поиска нужного элемента
    Метод возвращает True или False в зависимости от того, найден элемент или нет
     */

    public boolean consist(int value){
        Node cur = head;
        while (cur != null){
            if (cur.value == value){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /*
    Задача 4- Реализуем алгоритм добавления и удаления последнего элемента из связанного списка
    Метод pushBack класса List для добавления в конец списка
    Метод popBack класса List для удаления с конца списка
     */

//    public void pushBack(int value){
//        Node node = new Node();
//        node.value = value;
//
//        if(head == null){
//            head = node;
//        }else {
//            Node cur = head;
//            while (cur.next != null){
//                cur = cur.next;
//            }
//            cur.next = node;
//        }
//    }

//    public void popBack(){
//
//        if(head != null){
//            if (head.next == null){
//                head = null;
//            }else {
//                Node cur = head;
//                while (cur.next.next != null){
//                    cur = cur.next;
//                }
//                cur.next = null;
//            }
//        }
//    }

    /*
    Задача 5 - Преобразуем односвязный список в двусвязный
    Двусвязный список предствляет из себя цепочку элементов,
    которые умеют ссылаться не только на следующий элемент
    последовательности, но и на предыдущий

    Для этого в класс class List добавим tail и в класс class Node prev;
     */

    /*
    Задача 6 - Модифицируем методы добавления и удаления элементов из конца списка
    Метод pushBack класса List для добавления в конец двусвязанного списчка
    Метод popBack класса List для удаления с конца двусвязанного списка
     */

    public void pushFront(int value){
        Node node = new Node();
        node.value = value;
        if (head == null){
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    public void popFront(){
        if (head != null){
            if (head.next == null){
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
        }
    }

    public void pushBack(int value){
        Node node = new Node();
        node.value = value;

        if (tail == null){
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }

    public void popBack(){
        if(tail != null){
            if(tail.prev == null){
                head = null;
                tail = null;
            }else {
                tail = tail.prev;
            }
        }
    }

    /*
    Задача 7 - Реализуем функцию соритровки для связного списка
    Можно использовать любой алгоритм из предыдущего семинара, но для упрощения реализации воспользуемся пузырьковой
    сортировки
     */

    public void sort(){
        boolean needSort = true;
        do{
            needSort = false;
            Node node = head;
            while (node != null && node.next != null){
                if (node.value > node.next.value){
                    Node before = node.prev;
                    Node cur = node;
                    Node next = node.next;
                    Node after = node.next.next;

                    cur.prev = next;
                    cur.next = after;
                    next.prev = before;
                    next.next = cur;

                    if (before != null){
                        before.next = next;
                    }else {
                        head = next;
                    }

                    if (after != null){
                        after.prev = cur;
                    }else {
                        tail = cur;
                    }

                    needSort = true;
                }

                node = node.next;
            }

        }while (needSort);
    }
}


public class Main {
    public static void main(String[] args) {
        List list = new List();
//        for (int i = 1; i <= 5; i++)
//            list.pushFront(i);

        for (int i = 10; i >= 1; i--)
            list.pushBack(i);

//        list.print();

//        list.popFront();
//        list.popFront();

//        list.print();

//        System.out.println(list.consist(2));
//        System.out.println(list.consist(4));

//        list.pushBack(7);
//
//        list.print();
//
//        list.popBack();
        list.sort();
        list.print();
    }
}