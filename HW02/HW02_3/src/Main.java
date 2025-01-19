/*
Задача 3. Слияние двух отсортированных односвязных списков
Реализуйте метод, который сливает два отсортированных односвязных списка
в один отсортированный список.
Пример:
Input: 1 -> 3 -> 5 и 2 -> 4 -> 6
Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6
 */

class ListNode {
    ListNode head;
    int value;
    ListNode next;
    ListNode(int value) {this.value = value;}

    public void print(ListNode list) {
        while (list != null) {
            System.out.print(list.value);
            list = list.next;
            if (list != null)
                System.out.print(" -> ");
        }
    }

    public static ListNode mergeTwoList(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode merge = dummy;
        while (list1 != null && list2 != null){
            if (list1.value < list2.value){
                merge.next = list1;
                list1 = list1.next;
            } else {
                merge.next = list2;
                list2 = list2.next;
            }
            merge = merge.next;
        }

        merge.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        System.out.println("Список 1");
        list1.print(list1);
        System.out.println();
        System.out.println("Список 2");
        list2.print(list2);
        System.out.println();
        System.out.println("Список после слияния двух списков");

        ListNode list = ListNode.mergeTwoList(list1, list2);
        list.print(list);

    }
}