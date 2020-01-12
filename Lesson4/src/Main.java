import java.util.Iterator;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {


        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.insertFirst("Katia");
        myLinkedList.insertFirst("Maria");
        myLinkedList.insertFirst("Luba");
        myLinkedList.insertFirst("Luba");
        myLinkedList.insertFirst("Luba");

        System.out.println(myLinkedList);
        myLinkedList.insertLast("Sania");
        System.out.println(myLinkedList);

        myLinkedList.insert(3, "Petia");
        System.out.println(myLinkedList);

        myLinkedList.remove("Luba");
        System.out.println(myLinkedList);

        for (String s : myLinkedList) {
            System.out.print(s + " ");
        }

        // реализация ListIterator
       ListIterator<String> iterator = myLinkedList.listIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

        // реализация стека
        MyLinkedStack stack = new MyLinkedStack<>(myLinkedList);
        stack.push("12");
        stack.push("13");
        stack.push("14");

        System.out.println("Первый добавлен: "+stack.peek());



    }


}
