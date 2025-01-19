/*
Задача 2. Поиск среднего элемента в односвязном списке
Реализуйте метод, который находит средний элемент односвязного списка за
один проход по нему.
Пример:
Input: 1 -> 2 -> 3 -> 4 -> 5
Output: 3
 */
class ListNode {
    ListNode head;
    int value;
    ListNode next;

    public void print() {
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
            if (head != null)
                System.out.print(" -> ");
        }
    }

    public void push(int value) {
        ListNode node = new ListNode();
        node.value = value;

        if (head == null) {
            head = node;
        } else {
            ListNode currunt = head;
            while (currunt.next != null) {
                currunt = currunt.next;
            }
            currunt.next = node;
        }
    }

    public void findMiddle() {
        if (head != null) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            System.out.println("Средний элемент " + slow.value);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode list = new ListNode();

        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.findMiddle();
        list.print();
    }
}