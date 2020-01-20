import java.util.NoSuchElementException;

public class MyTreeMap <Key extends  Comparable <Key>, Value> {

    private Node root;

    // вспомгательный внутренний класс для элемента из ключа и значения
    private class Node {

        Key key; // ключ
        Value value; // значение
        Node left; // хранит ссылку на левое дерево
        Node right; // хранит ссылку на правое дерево
        int size; // количество узлов в дереве

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.size = 1;
        }

    }

    @Override
    public String toString() {
        return toString(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    private boolean isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key не должен быть null");
        }
        return true;
    }

    private String toString(Node node) {
        if(node == null){
            return "";
        }
        return toString(node.left)
                + "[" + node.key + "=" + node.value + "], "
                + toString(node.right);
    }

    // проверка наличия значения по ключу
    public final boolean contains(Key key) {
        return get(key) != null;
    }

    public final Value get(Key key) {
        isKeyNotNull(key);
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);

        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    // установка значения по ключу
    public final void put(Key key, Value value) {

        isKeyNotNull(key);
        if (value == null) {
            return;
        }

        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {

        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);

        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    // удаление узла
    public final void remove(Key key) {
        isKeyNotNull(key);
        root = remove(root, key);
    }

    // удаление узла (рекурсивный метод)
    private Node remove(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node tmp = node;
            node = min(node.right);
            node.right = deleteMin(tmp.right);
            node.left = tmp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }


    private int size(Node node) {

        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int size() {
        return size(root);
    }

    // поиск максимального и минимального элементов
    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        return min(node.right);
    }

    public Key minKey() {
        return min(root).key;
    }

    public Key maxKey() {
        return max(root).key;
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Дерево не содержит элементы");
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {

        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }


    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Дерево не содержит элементы");
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {

        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.size = size(node.right) + size(node.left) + 1;
        return node;
    }


    //

}