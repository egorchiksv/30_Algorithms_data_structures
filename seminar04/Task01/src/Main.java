/*
Задача 1 - Релизуем класс для бинарного дерева
Класс Node для хранения элементов дерева;
Класс Tree для реализации самого дерева;
Реализуем класс без методов

Задача 2 - Реализуем метод добавления в дерево
ДОобавляем метод add(value) для вставки числа в дерево.
Для определения позиции перед вставкой выполняется поиск того метода дерева, где это число могло находиться;
Не забываем, что бинарное дерево поисчка не хранит повторяющиеся элементы.

Задача 3 - Релизуем метод поиска
Добавляем метод find(int value) для проверки на существование элемента дерева со значением value.
Возвращаем объект Node, если нашли нужный элемент, иначе возвращаем null;

Задача 4 - Реализуем балансировку
Добавим балансировку дерева на примере балансировки левостороннего красно-черного дерева;
Красно-черное дерево имеет следующие кретерии:
    Каждая нода имеет цвет (красный и черный)
    Корень дерева всегда черный
    Новая нода всегда красная
    Красные ноды могут быть только левым ребенком
    У красной ноды все дети черного цвета
Вызываем балансировку при каждом изменении дерева
 */
public class Main {
    Node root;
    class Node{
        int value;
        Node left;
        Node right;
        Color color;
    }

    enum Color{
        BLACK,
        RED
    }

    public void insert(int value){
        if (root != null){
            insert(root, value);
            root = balance(root);
        }else {
            root = new Node();
            root.value = value;
        }
        root.color = Color.BLACK;
    }

    private void insert(Node node, int value){
        if (node.value != value) {
            if (node.value < value) {
                if (node.right == null) {
                    node.right = new Node();
                    node.right.value = value;
                    node.right.color = Color.RED;
                }else {
                    insert(node.right, value);
                    node.right = balance(node.right);
                }
            } else {
                if (node.left == null) {
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color = Color.RED;
                } else {
                    insert(node.left, value);
                    node.left = balance(node.left);
                }
            }
        }
    }

    public Node find(int value){
        return find(root, value);
    }

    private Node find(Node node, int value){
        if (node == null) {
            return null;
        }
        if (node.value == value){
            return node;
        }
        if (node.value < value){
            return find(node.right, value);
        }else{
            return find(node.left, value);
        }
    }

    private Node leftRotate(Node node){
        Node cur = node.right;
        node.right = cur.left;
        cur.left = node;
        cur.color = node.color;
        node.color = Color.RED;
        return cur;
    }

    private Node rightRotate(Node node){
        Node cur = node.left;
        node.left = cur.right;
        cur.right = node;
        cur.color = node.color;
        node.color = Color.RED;
        return cur;
    }

    private void swapColors(Node node){
        node.color = (node.color == Color.RED ? Color.BLACK : Color.RED);
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
    }

    private Node balance(Node node){
        boolean flag = true;
        Node cur = node;
        do{
            flag = false;

            if (cur.right != null && cur.right.color == Color.RED && (cur.left == null || cur.left.color == Color.BLACK)){
                cur = leftRotate(cur);
                flag = true;
            }

            if (cur.left != null && cur.left.color == Color.RED && cur.left.left != null && cur.left.left.color == Color.RED){
                cur = rightRotate(cur);
                flag = true;
            }

            if (cur.left != null && cur.left.color == Color.RED && cur.right != null && cur.right.color == Color.RED){
                swapColors(cur);
                flag = true;
            }

        }while (flag);
        return cur;
    }

    public static void main(String[] args) {
        Main tree = new Main();

        for (int i = 1; i <= 5; i++)
            tree.insert(i);

//        System.out.println(tree.find(5));
//        System.out.println(tree.find(6));
    }
}