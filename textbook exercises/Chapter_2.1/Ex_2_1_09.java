import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_09 {
    public static <T extends Comparable<T>> void shellSort(T[] a) {
        int N = a.length;
        int h = 1;
        StdOut.println("The original array: ");
        printArray(a);

        while (h < N / 3) {
            h = 3 * h + 1; // decide sort interval based on size N
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }

            }
            StdOut.printf("%2d sort: ", h);
            printArray(a);
            h = h / 3;
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
        String[] s1 = "E A S Y Q U E S T I O N".split(" ");
        shellSort(s1);

        String[] s2 = "E A S Y S H E L L S O R T Q U E S T I O N".split(" ");
        shellSort(s2);
    }
}
