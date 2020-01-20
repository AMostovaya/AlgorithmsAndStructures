import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        MyTreeMap<Integer, String> map = new MyTreeMap<>();

        map.put(5, "five");
        map.put(1, "one");
        map.put(3, "tree");
        map.put(2, "two");
        map.put(4, "four");


        System.out.println(map.get(1));
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.contains(2));

        System.out.println(map);

        /*
        1. Создать и запустить программу для построения двоичного дерева.
        В цикле построить двадцать деревьев с глубиной в 6 уровней.
        Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
        Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
        2. Проанализировать, какой процент созданных деревьев являются несбалансированными
         */
        final int countOfMap = 20; // количество деревьев
        int isBalanced = 0;

        // создаем деревья
        for (int i = 0; i < countOfMap; i++) {
            MyTreeMap<Integer, Integer> mapBalanced = new MyTreeMap<>();
            while (mapBalanced.height() < 6) {
                // заполняем дерево случайными числами [-100, 100]
                mapBalanced.put(ThreadLocalRandom.current().nextInt(-100, 100), 0);
            }
            if (mapBalanced.isBalanced())
                isBalanced++;
        }
        System.out.println("Из " + countOfMap + " деревьев сбалансировано " + isBalanced + "\r\n несбалансировано " + (countOfMap - isBalanced) + " деревьев");
        System.out.println("или " + ((((double) isBalanced) * 100) / (double) countOfMap) + " %");


    }
}
