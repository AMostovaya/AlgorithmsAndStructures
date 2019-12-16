import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Task51();
        Task53();
        Task62();
        Task251();
        Task276();

    }

    private static void Task51() {
        /*
        Определение 1:
        n!!...!=n(n-k)(n-2k)...(n mod k), если n не делится на k,
        n!!...!=n(n-k)(n-2k)...k, если n делится на k (знаков ! в обоих случаях k штук).
        Определение 2:
        X mod Y — остаток от деления X на Y.
        Например, 10 mod 3 = 1; 3! = 3•2•1; 10!!! = 10•7•4•1;
         */
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int f = in.nextInt();
        String k = in.next();
        int kol = k.length();
        int res = CalculateFactorial(f, kol);
        out.println(res);
        out.flush();
    }
    static int CalculateFactorial(int f, int kol) {

        int result = 0;
        int res = 1;
        for (int i = f; i >= 1; i = i - kol) {
            res = res * i;
        }
        result = res;
        return result;
    }
    private static void Task53() {
       /*
        Таблицей умножения назовем таблицу размера n строк на m столбцов,
        в которой на пересечении i-ой строки и j-ого столбца стоит число i∙j (строки и столбцы нумеруются с единицы).
        В одной из математических школ было решено провести педагогический эксперимент.
        Для того, чтобы ученикам было проще запоминать таблицу умножения, некоторые числа в ней будут покрашены в красный, некоторые - в синий,
        а некоторые - в зеленый цвет (оставшиеся числа будут черными).
        Процесс покраски чисел можно условно разбить на четыре этапа. На первом этапе все числа красятся в черный цвет. На втором - все четные числа красятся в красный цвет, на третьем – все числа, делящиеся на 3, красятся в зеленый цвет, на четвертом - все числа, делящиеся на 5, красятся в синий цвет.
        Директор школы хочет знать, какое количество картриджей для принтеров необходимо закупить для печати таблиц. Поэтому ему необходима информация о том, сколько чисел какого цвета будет в одной раскрашенной таблице умножения n на m.
        */
        int n, m, black = 0, red = 0, green = 0, blue = 0;

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        n = in.nextInt();
        m = in.nextInt();
        int[][] mas = new int[n][m];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                System.out.printf("%4d", (j * i));
                int res = j * i;
                if (res % 5 == 0) {
                    blue++;
                } else if (res % 3 == 0) {
                    green++;
                } else if (res % 2 == 0) {
                    red++;
                } else {
                    black++;
                }
            }
            System.out.println();
        }
        out.println("RED: " + red);
        out.println("GREEN: " + green);
        out.println("BLUE: " + blue);
        out.println("BLACK: " + black);
        out.flush();
    }
    private static void Task62() {
        /*
        Известно, что шахматная доска имеет размерность 8х8 и состоит из клеток 2х цветов, например, черного и белого (см. рисунок).
        Каждая клетка имеет координату, состоящую из буквы и цифры. Горизонтальное расположение клетки определяется буквой от A до H, а вертикальное – цифрой от 1 до 8. Заметим, что клетка с координатой А1 имеет черный цвет.
        Требуется по заданной координате определить цвет клетки
         */
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String letter = (in.next());
        char c = (letter.charAt(0));

        int num_int = Integer.parseInt(letter.substring(1));

        if (((c=='A')||(c=='C')||(c=='E')||(c=='G'))&&(num_int %2!=0))
            out.print("BLACK");
        else if (((c=='B')||(c=='D')||(c=='F')||(c=='H'))&&(num_int %2 == 0))
            out.print("BLACK");
        else
            out.print("WHITE");
        out.flush();
    }

    private static void Task251() {
        /*
        Числа Фибоначчи строятся следующим образом: 1, 1, 2, 3, 5, …. В этой последовательности, начиная с третьего числа, каждый следующий член равен сумме двух предыдущих. Получаем, что, например, шестое число равно 8, а десятое - 55.
        Требуется написать программу, которая определяет, является ли заданное число числом Фибоначчи.
         */
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int f = in.nextInt();
        int a=0,b=1,c=0,i=0;

        while (c<f)
        {
            a=b;
            b=c;
            c=a+b;
            i++;
        }
        if(c==f) {
            out.println(1);
            out.print(i);
        }
        else out.print(0);
        out.flush();
    }

    private static void Task276() {
        /*
        Необходимо представить целое число N в виде суммы M примерно равных целых чисел.
        Будем считать, что числа примерно равны, если они отличаются друг от друга не более чем на единицу
         */
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int i,c;
        int n = in.nextInt();
        int m = in.nextInt();
        c=n-n/m*m;
        for (i = 0; i < m-c; i++)
            out.print(n/m + " ");
        for (i = 0; i < c; i++)
            out.print(n/m+1 + " ");
        out.flush();
    }
}
