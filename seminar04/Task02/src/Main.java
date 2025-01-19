/*
Задача 5 - Реализуем свой класс Хэш-таблицы
Создаем класс HashMap;
Для реализации корзинок будем использовать список из прошлого семинара;
Для начала можно реализовать простой класс без расширения в случае большого количества элементов;
 */
public class Main {
    class Entity{
        int key;
        int value;
    }

    class Basket{
        Node head;
        class Node{
            Entity entity;
            Node next;
        }

        private boolean push(Entity entity){
            Node node = new Node();
            node.entity = entity;
            if (head == null){
                head = node;
            }else {
                Node cur = head;
                while (cur.next != null){
                    if (cur.entity.key == entity.key){
                        return false;
                    }
                    cur = cur.next;
                }
                cur.next = node;
            }
            return true;
        }

        private boolean remove(int key){
            if (head != null){
                if (head.entity.key == key){
                    head = head.next;
                }else {
                    if (head.next == null) {
                        Node cur = head;
                        while (cur != null) {
                            if (cur.entity.key == key) {
                                cur.next = cur.next.next;
                                return true;
                            }
                            cur = cur.next;
                        }
                    }
                }
            }
            return false;
        }

        private Integer find(int key){
            Node cur = head;
            while (cur != null) {
                if (cur.entity.key == key) {
                    return cur.entity.value;
                }
                cur = cur.next;
            }
            return null;
        }

    }

    static final int INIT_SIZE = 16;
    Basket[] baskets;

    public Main(){
        this(INIT_SIZE);
    }

    public Main(int size){
        baskets = new Basket[size];
    }

    private int getIndex(int key){
        return key % baskets.length;
    }

    public boolean push(int key, int value){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket == null){
            basket = new Basket();
            baskets[index] = basket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        return basket.push(entity);
    }

    public boolean remove(int key){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket != null){
            basket = new Basket();
            baskets[index] = basket;
            return basket.remove(key);
        }
        return false;
    }

    public Integer find(int key){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket != null){
            return basket.find(key);
        }
        return null;
    }

    public static void main(String[] args) {
        Main map = new Main();
        map.push(1, 2);
        map.push(3, 4);

        System.out.println(map.find(1));
        System.out.println(map.find(2));

        map.remove(1);
        map.push(2, 5);

        System.out.println(map.find(1));
        System.out.println(map.find(2));
    }
}