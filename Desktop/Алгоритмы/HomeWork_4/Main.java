package HomeWork_4;

public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        // Вставка элементов
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);

        // Проверка цветов узлов
        System.out.println("Цвет корня: " + tree.root.color);
        System.out.println("Цвет левого потомка корня: " + tree.root.left.color);
        System.out.println("Цвет правого потомка корня: " + tree.root.right.color);
        System.out.println("Цвет левого потомка правого потомка корня: " + tree.root.right.left.color);
        System.out.println("Цвет правого потомка правого потомка корня: " + tree.root.right.right.color);

        // Проверка балансировки
        System.out.println("Проверка балансировки: ");
        tree.printInOrder(tree.root);
    }
}

class Node {
    int key;
    Node parent;
    Node left;
    Node right;
    String color;

    public Node(int key) {
        this.key = key;
        this.color = "RED";
    }

    public Node(int key, Node parent) {
        this.key = key;
        this.parent = parent;
        this.color = "RED";
    }
}

class RedBlackTree {
    Node root;

    public RedBlackTree() {
        this.root = null;
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            root.color = "BLACK"; 
            return;
        }

        Node node = insertRecursive(root, key);
        fixInsertion(node);
    }

    private Node insertRecursive(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
    
        if (key < root.key) {
            if (root.left == null) {
                root.left = insertRecursive(root.left, key);
                root.left.parent = root;
                return root.left;
            } else {
                return insertRecursive(root.left, key);
            }
        } else {
            if (root.right == null) {
                root.right = insertRecursive(root.right, key);
                root.right.parent = root;
                return root.right;
            } else {
                return insertRecursive(root.right, key);
            }
        }
    }

    private void fixInsertion(Node node) {
        while (node != root && node.parent.color.equals("RED")) {
            if (node.parent == node.parent.parent.left) {
                Node uncle = node.parent.parent.right;
                if (uncle != null && uncle.color.equals("RED")) { 
                    node.parent.color = "BLACK";
                    uncle.color = "BLACK";
                    node.parent.parent.color = "RED";
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    node.parent.color = "BLACK";
                    node.parent.parent.color = "RED";
                    rightRotate(node.parent.parent);
                }
            } else {
                Node uncle = node.parent.parent.left;
                if (uncle != null && uncle.color.equals("RED")) {
                    node.parent.color = "BLACK";
                    uncle.color = "BLACK";
                    node.parent.parent.color = "RED";
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = "BLACK";
                    node.parent.parent.color = "RED";
                    leftRotate(node.parent.parent);
                }
            }
        }
        root.color = "BLACK"; 
    }

    private void leftRotate(Node x) {
        if (x != null && x.right != null) {
            Node y = x.right;
            x.right = y.left;
            if (y.left != null) {
                y.left.parent = x;
            }
            y.parent = x.parent;
            if (x.parent == null) {
                root = y;
            } else if (x == x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
            y.left = x;
            x.parent = y;
        }
    }

    private void rightRotate(Node y) {
        if (y != null && y.left != null) {
            Node x = y.left;
            y.left = x.right;
            if (x.right != null) {
                x.right.parent = y;
            }
            x.parent = y.parent;
            if (y.parent == null) {
                root = x;
            } else if (y == y.parent.right) {
                y.parent.right = x;
            } else {
                y.parent.left = x;
            }
            x.right = y;
            y.parent = x;
        }
    }

    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.key + " (" + node.color + ")");
            printInOrder(node.right);
        }
    }
}