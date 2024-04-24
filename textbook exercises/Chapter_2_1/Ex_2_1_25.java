import java.util.Random;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Ex_2_1_25 {
    public static double time(String algo, int size, int N) {
        Double totalTime = 0.0; // Accumulate time for N sorts
        for (int i = 0; i < N; i++) {
            Stopwatch watch = new Stopwatch();
            Integer[] original = getRandomIntArray(size); // size: size of the array
            Integer[] a = original.clone(); // Make a copy of the array for sorting
            
            if (algo.equals("insertion without exchanges")) {
                insertionSortWithoutExchange(a);
            } else if (algo.equals("insertion")) {
                a = original.clone(); // Re-clone the original array for a fair comparison
                insertionSort(a);
            }
            totalTime += watch.elapsedTime();
        }
        return totalTime / N; // return average time

    }

    private static Integer[] getRandomIntArray(int size) {
        Integer[] a = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt(size);
        }
        return a;
    }

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            // if a[j] is less than a[j-1]
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {

                exchange(a, j, j - 1);
            }

        }
    }

    public static <T extends Comparable<T>> void insertionSortWithoutExchange(T[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            T key = a[i]; // the key to insert
            int j = i;
            // no sentinel, check j > 0 here
            while (j > 0 && less(key, a[j - 1])) {
                a[j] = a[j - 1]; // move the larger one to the right
                j--;
            }
            a[j] = key;
        }

    }

    private static <T extends Comparable<T>> void exchange(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        int arraySize = 1000;
        int numberOfSorts = 1000;
        double insertWithoutExchTime = time("insertion without exchanges", arraySize, numberOfSorts);
        double insertionTime = time("insertion", arraySize, numberOfSorts);

        StdOut.printf("Insertion without exchanges time: %.3fs\n", insertWithoutExchTime);
        StdOut.printf("Insertion time: %.3fs\n", insertionTime);
        StdOut.printf(
                "The array with random elements: array size is %2d, run %2d times, insertion without exchanges use %.3f times than insertion sort\n",
                arraySize, numberOfSorts, insertWithoutExchTime / insertionTime);
    }
}
