import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Ex_2_1_07 {
    public static double time(String algo, int size, int N) {
        Double totalTime = 0.0; // Accumulate time for N sorts
        for (int i = 0; i < N; i++) {
            Stopwatch watch = new Stopwatch();
            Integer[] a = getReverseIntArray(size); // size: size of array
            if (algo.equals("selection")) {
                selectionSort(a);
            } else if (algo.equals("insertion")) {
                insertionSort(a);
            }
            totalTime += watch.elapsedTime();
        }
        return totalTime / N; // return average time

    }

    private static Integer[] getReverseIntArray(int size) {
        Integer[] a = new Integer[size];
        int init = size;
        for (int i = 0; i < size; i++) {
            a[i] = init;
            init--;
        }
        return a;
    }

    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            int j = i;
            // if a[j] is less than a[j-1]
            for (; j > 0 && less(a[j], a[j - 1]); j--) {

                exchange(a, j, j - 1);
            }

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
        int numberOfSorts = 10000;
        double selectionTime = time("selection", arraySize, numberOfSorts);
        double insertionTime = time("insertion", arraySize, numberOfSorts);

        StdOut.printf("Selection time: %.3fs\n", selectionTime);
        StdOut.printf("Insertion time: %.3fs\n", insertionTime);
        StdOut.printf(
                "The array with reversed elements: array size is %2d, run %2d times, selection sort use %.3f times than insertion sort\n",
                arraySize, numberOfSorts, selectionTime / insertionTime);
    }
}
