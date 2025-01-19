/*
Задание 1. Преобразование дерева поиска в красно-черное дерево
Вам дано бинарное дерево поиска. Напишите метод, который преобразует его в
левостороннее красно-черное дерево (РЧД). Красно-черное дерево должно
удовлетворять следующим критериям:
1. Каждая нода имеет цвет (красный или черный).
2. Корень дерева всегда черный.
3. Новая нода всегда красная.
4. Красные ноды могут быть только левыми дочерними элементами.
5. У красной ноды все дочерние элементы черного цвета.
Для этого, реализуйте методы добавления новых элементов с балансировкой и
выполняйте следующие операции для поддержания свойств РЧД:
● Левый малый поворот
● Правый малый поворот
● Смена цвета
Критерии применения этих операций:
● Если правый дочерний элемент красный, а левый черный, то применяем
малый правый поворот.
● Если левый дочерний элемент красный и его левый дочерний элемент
тоже красный, то применяем малый левый поворот.
● Если оба дочерних элемента красные, то делаем смену цвета.
● Если корень стал красным, то перекрашиваем его в черный.
 */

class Node {
    int value;
    Node left, right, parent;
    boolean isRed;
    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.isRed = true;
    }
}

public class Main {
    private Node root;

    public Main() {
        this.root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
        root.isRed = false;
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
            node.left.parent = node;
        } else if (value > node.value) {
            node.right = insert(node.right, value);
            node.right.parent = node;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            swapColors(node);
        }
        return node;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.isRed;
    }

    private Node leftRotate(Node node) {
        Node cur = node.right;
        node.right = cur.left;
        if (cur.left != null) {
            cur.left.parent = node;
        }
        cur.parent = node.parent;
        if (node.parent == null) {
            root = cur;
        } else if (node == node.parent.left) {
            node.parent.left = cur;
        } else {
            node.parent.right = cur;
        }
        cur.left = node;
        node.parent = cur;
        cur.isRed = node.isRed;
        node.isRed = true;
        return cur;
    }

    private Node rightRotate(Node node) {
        Node cur = node.left;
        node.left = cur.right;
        if (cur.right != null) {
            cur.right.parent = node;
        }
        cur.parent = node.parent;
        if (node.parent == null) {
            root = cur;
        } else if (node == node.parent.right) {
            node.parent.right = cur;
        } else {
            node.parent.left = cur;
        }
        cur.right = node;
        node.parent = cur;
        cur.isRed = node.isRed;
        node.isRed = true;
        return cur;
    }

    private void swapColors(Node node) {
        node.isRed = !node.isRed;
        if (node.left != null) {
            node.left.isRed = !node.left.isRed;
        }
        if (node.right != null) {
            node.right.isRed = !node.right.isRed;
        }
    }

    public void print(){
        print(root, 0);
    }

    private void print(Node node, int deep){
        if (node == null){
            return;
        }

        print(node.left, deep + 4);

        for (int i = 0; i <= deep; i++)
            System.out.print(" ");
        System.out.println("значение: " + node.value + " {цвет: " + (node.isRed ? "(К)" : "(Ч)") + "}");

        print(node.right, deep + 4);
    }

    public static void main(String[] args) {
        Main tree = new Main();
        for (int i = 1; i <= 20; i++)
            tree.insert(i);

        System.out.println("Красно-черное дерево:");
        tree.print();
    }
}