import java.util.LinkedList;

public class Main {

   public static void main(String[] args) {

        /**
         * Дано натуральное число a, которое необходимо возвести в степень n.
         * f(a, n) = a * a * ... * a = (a^[n - 1]) * a;
         */

       Exponentiation();

        /*
        Имеется рюкзак с ограниченной вместимостью по массе; также имеется набор вещей с определенным весом и ценностью.
        Необходимо подобрать такой набор вещей, чтобы он помещался в рюкзаке и имел максимальную ценность (стоимость).
        */

       SolveBackpackItems();
    }

   static void Exponentiation() {

       int a = 5;
       int n = 3;

       Exponentiation exp = new Exponentiation();
       long result = exp.expoRec(a, n);

       System.out.println("Результат: число " + a + " в степени " + n + " = " + result);

   }

    static void SolveBackpackItems() {

       LinkedList<Items> item = new LinkedList<>();
        // добавляем предварительный набор предметов в рюкзак
        item.add(new Items("Бинокль", 0.5, 12));
        item.add(new Items("Компас", 0.25, 7));
        item.add(new Items("Спальник", 5, 27));
        item.add(new Items("Термос", 8, 14));
        item.add(new Items("Палатка", 13, 10));

        System.out.println("Общий список предметов:");
        for (Items i: item) {
            System.out.println(i.name + " " + i.weight + "кг " + i.price + "р.");
        }

        // начинаем собирать рюкзак
        Backpack backpack = new Backpack(10);
        backpack.MakeAllSets(item);

        // ищем оптимальный набор
        LinkedList<Items> solve = backpack.GetBestSet();

        if (solve == null)  {
            System.out.println("Решение не найдено!");
        }
        else {

            item.clear();

            System.out.println("Набор для рюкзака:");

            for (Items i: solve) {
               System.out.println(i.name);
            }
        }
    }

}
