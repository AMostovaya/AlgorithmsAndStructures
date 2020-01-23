import java.util.NoSuchElementException;

public class MyDeque <Item> {

    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyDeque() {
        list = (Item []) new Object[DEFAULT_CAPACITY];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    //Изменить размер дэка
     public void resize(int capacity){
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = list[i];
        }
        list = (Item[]) temp;
    }

    //Удалить все элементы из дэка
      public void clear(){
        Object[] temp = new Object[1];
        list = (Item[]) temp;
        size = 0;
    }

    //Добавление элемента в начало дэка
   public void pushFront(Item item){
        if (size == list.length){
            resize(list.length * 2);
        }
        for (int i = size; i > 0 ; i--) {
            list[i] = list[i - 1];
        }
        size++;
        list[0] = item;
    }

    //Просмотреть элемент в начале дэка
      public Item peakFront(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return (Item) list[0];
    }

    //Извлечение элемента из начала дэка
      public Item popFront(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Item item = (Item) list[0];
        size--;
        for (int i = 0; i < size; i++) {
            list[i] = list[i + 1];
        }
        if (size == list.length / 4 && size > 0){
            resize (list.length / 2);
        }
        return item;
    }

   //Добавление элемента в конец дэка
    public void pushBack(Item item){
        if (size == list.length){
            resize(list.length * 2);
        }
        list[size++] = item;
    }

    //Просмотреть элемент в конце дэка
    public Item peakBack(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return (Item) list[size - 1];
    }

    //Извлечение элемента из конеца дэка
    public Item popBack(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        Item item = (Item) list[size - 1];
        size--;
        if (size == list.length / 4 && size > 0){
            resize (list.length / 2);
        }
        return item;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append((Item)list[i].toString()).append(", ");
        }
        return stringBuilder.toString();
    }
}
