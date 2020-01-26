import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ChainHashMap<Integer, String> map = new ChainHashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");

        System.out.println(map.contains(2));
        System.out.println(map.get(4));
        map.put(4,"four4");
        System.out.println(map.get(4));

      /*  Random random = new Random();
        for (int i = 0; i < 35; i++) {
            map.put(random.nextInt(1000), "");
        }*/
        System.out.println("Удаление: " + map.delete(1));


        System.out.println(map);

    }
}
