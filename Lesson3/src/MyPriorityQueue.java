import java.util.Comparator;
import java.util.EmptyStackException;

public class MyPriorityQueue <Item extends Comparable<Item>>  {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private Comparator comparator = Comparator.naturalOrder();

    public MyPriorityQueue(int capacity,Comparator comparator) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (Item []) new Comparable[capacity];
        this.comparator = comparator;
    }

    public MyPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (Item[]) new Comparable[capacity];
    }

    public MyPriorityQueue() {
        list = (Item[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void insert(Item value) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        list[size] = value;
        size++;
        int i = size - 1;
        while (i > 0 && comparator.compare(list[i],list[i-1]) > 0){
            swap(i, i-1);
            i--;
        }
    }

    public Item remove() {
        Item temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void swap(int index1, int index2) {
        Item temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }
}
