import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_04 {
    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int N = a.length;
        StdOut.printf("      :");
        printArray(a);
        for (int i = 1; i < N; i++) {
            int j = i;
            // if a[j] is less than a[j-1]
            for (; j > 0 && less(a[j], a[j - 1]); j--) {

                exchange(a, j, j - 1);
            }
            StdOut.printf("%2d %2d: ", i, j);
            printArray(a);
        }
        StdOut.printf("      :");
        printArray(a);
    }

    private static <T extends Comparable<T>> void exchange(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    private static <T extends Comparable<T>> void printArray(T[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {

        String[] a = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };
        insertionSort(a);

    }
}
