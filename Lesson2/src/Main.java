import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final int COUNT_ELEMENTS = 250000;
    private static int[] array = new int[COUNT_ELEMENTS];

    public static void main(String[] args) {

        createArray();
        bubleSort();
        createArray();
        selectSort();
        createArray();
        insertSort();
    }

    private static void insertSort() {

        int buf, j;
        long m = System.currentTimeMillis();

        for (int i = 1; i < array.length; i++) {
            buf = array[i];
            j = i;
            while (j>0 && array[j-1]>= buf) {
                array[j] = array[j-1];
                --j;
            }
            array[j]=buf;
        }

        System.out.println("Методом вставки:" + (double) (System.currentTimeMillis() - m));
       // System.out.println(Arrays.toString(array));


    }

    private static void selectSort() {
        int mark, buf;

        long m = System.currentTimeMillis();

        for (int i=0; i < array.length; i++) {
            mark = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[mark]) {
                    mark = j;
                }
            }
            buf = array[i];
            array[i] = array[mark];
            array[mark] = buf;
        }

        System.out.println("Методом выбора:" + (double) (System.currentTimeMillis() - m));
        //System.out.println(Arrays.toString(array));
    }

    private static void bubleSort() {

        long m = System.currentTimeMillis();

        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i<array.length-1; i++){
                buf = array[i];
                if (array[i] > array[i+1]) {
                    isSorted = false;
                    buf = array[i];
                    array[i] = array[i+1];
                    array[i+1] = buf;

                }
            }
        }
        System.out.println("Методом пузырька:"+ (double) (System.currentTimeMillis() - m));
        //System.out.println(Arrays.toString(array));
    }

    private static void createArray() {

        Random rand = new Random();
        // создаем массив в 1 млн элементов
        for (int i=0; i<array.length; i++) {
            array[i] = rand.nextInt(500);
        }

       /* for (int i=0; i<array.length; i++){
            System.out.println(i+" "+array[i]);
        }*/
    }
}
