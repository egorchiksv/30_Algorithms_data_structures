import java.util.ArrayList;
/*
Задание 1. Удаление дубликатов в односвязном списке
Напишите метод, который удаляет все дубликаты из односвязного списка.
Пример:
Input: 1 -> 2 -> 3 -> 2 -> 4 -> 1
Output: 1 -> 2 -> 3 -> 4
 */
class ListNode {
    Node head;
    class Node{
        int value;
        Node next;
    }

    public void print() {
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
            if (head != null)
                System.out.print(" -> ");
        }
    }

    public void push(int value){
        Node node = new Node();
        node.value = value;

        if (head == null){
            head = node;
        }else {
            Node currunt = head;
            while (currunt.next != null){
                currunt = currunt.next;
            }
            currunt.next = node;
        }
    }

    public void removeDuplicates() {
        if (head == null) return;

        ArrayList<Integer> list = new ArrayList<>();

        Node current = head;

        list.add(current.value);

        while (current.next != null){
            if(list.contains(current.next.value)){
                current.next = current.next.next;
            } else {
                list.add(current.next.value);
                current = current.next;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode list = new ListNode();

        list.push(1);
        list.push(2);
        list.push(3);
        list.push(2);
        list.push(4);
        list.push(1);

       list.removeDuplicates();
        list.print();
    }
}