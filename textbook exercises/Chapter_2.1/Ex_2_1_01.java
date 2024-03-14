import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_01 {
    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            StdOut.printf("Iteration %2d : ", i);
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
            printArray(a);
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

    private static <T extends Comparable<T>> void printArray(T[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] a = { "E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N" };
        StdOut.println("Original array:");
        printArray(a);
        StdOut.println("Sorting steps:");
        selectionSort(a);
    }
}