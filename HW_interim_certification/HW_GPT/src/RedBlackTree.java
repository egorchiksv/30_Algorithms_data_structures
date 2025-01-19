class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    static class Node {
        int value;
        Node left, right;
        boolean color;

        Node(int value) {
            this.value = value;
            this.color = RED; // Новая нода всегда красная
        }
    }

    private Node root;

    // Проверка, является ли узел красным
    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    // Левый малый поворот
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // Правый малый поворот
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    // Смена цвета
    private void flipColors(Node h) {
        h.color = RED;
        if (h.left != null) h.left.color = BLACK;
        if (h.right != null) h.right.color = BLACK;
    }

    // Добавление элемента в дерево
    public void add(int value) {
        root = add(root, value);
        root.color = BLACK; // Корень всегда черный
    }

    private Node add(Node h, int value) {
        if (h == null) {
            return new Node(value);
        }

        if (value < h.value) {
            h.left = add(h.left, value);
        } else if (value > h.value) {
            h.right = add(h.right, value);
        }

        // Балансировка дерева
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        return h;
    }

    // Печать дерева (инфиксный обход)
    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.println(indent + (last ? "R── " : "L── ") + node.value + " (" + (node.color == RED ? "RED" : "BLACK") + ")");
            printTree(node.left, indent + (last ? "   " : "│  "), false);
            printTree(node.right, indent + (last ? "   " : "│  "), true);
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.add(10);
        tree.add(20);
        tree.add(5);
        tree.add(15);
        tree.add(25);
        tree.add(1);

        tree.printTree();
    }
}
