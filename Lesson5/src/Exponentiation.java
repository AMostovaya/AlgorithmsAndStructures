public class Exponentiation {

    /**
     *  Вычисляем при помощи рекурсии
     */
    public long expoRec(int a, int n){
        if (n == 1) return a;
        if (n < 1) return 1;
        else return expoRec(a, n - 1) * a;
    }


}
