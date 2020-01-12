import java.util.EmptyStackException;


public class MyStack <Item> {

    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 30;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (Item[]) new Object[capacity];
    }

    public MyStack() {
        list = (Item []) new Object[DEFAULT_CAPACITY];
    }

    public void push(Item value){
        if(isFull()){
            throw new StackOverflowError();
        }
        list[size] = value;
        size++;
    }

    public Item pop(){
        Item temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    public Item peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return list[size-1];
    }

    public boolean isFull(){
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void reCapacity(int newCapacity){
        Item[] tempArr = (Item[]) new Object[newCapacity];
        System.arraycopy(list,0,tempArr,0,size);
        list = tempArr;
    }

}
