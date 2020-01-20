public class Main {

    public static void main(String[] args) {

        MyTreeMap<Integer, String> map = new MyTreeMap<>();

        map.put(5,"five");
        map.put(1,"one");
        map.put(3,"tree");
        map.put(2,"two");
        map.put(4,"four");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.contains(2));

        System.out.println(map);

    }
}
