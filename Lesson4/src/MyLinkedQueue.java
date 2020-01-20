public class MyLinkedQueue<Item> {

    private MyLinkedList<Item> queue = new MyLinkedList<>();

    public MyLinkedQueue(MyLinkedList<Item> queue) {
        this.queue = queue;
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void enqueue(Item value){
        queue.insertFirst(value);
    }

    public Item dequeue(){
        return queue.removeLast();
    }

    public Item peek(){
        return queue.getLast();
    }
}
