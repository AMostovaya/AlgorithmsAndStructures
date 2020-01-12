import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MyLinkedStack<Item> {

    private MyLinkedList<Item> stack = new MyLinkedList<>();

    public MyLinkedStack(MyLinkedList<Item> stack) {
        this.stack = stack;
    }

    public int size(){
        return stack.size();
    }

    // добавление элемента в конец списка
    public void push(Item value) {
        stack.insertLast(value);
    }

    // удаляем последний элемент
    public Item pop() {
       if (size()==0) {
           throw new NotImplementedException();
        }
        else {
            return stack.removeLast();
        }
    }

    // получаем верхний элемент
    public Item peek() {
        return stack.getFirst();
    }

}
