import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Task51();

    }

    static int CalculateFactorial(int f, int kol) {

        int result=0;
        int res =1;
        for (int i=f; i>=1; i=i-kol) {
             res = res*i;
        }
        result = res;
        return result;
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
}
