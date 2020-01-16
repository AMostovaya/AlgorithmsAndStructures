import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyQueue <Item> {

    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 0;

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (Item []) new Object[capacity];
    }

    public MyQueue() {
        list = (Item []) new Object[DEFAULT_CAPACITY];
    }

    public void insert(Item value) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        list[end] = value;
        size++;
        end = nextIndex(end);
    }

    public Item remove() {
        Item temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public Item peekFront() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[begin];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
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
}
