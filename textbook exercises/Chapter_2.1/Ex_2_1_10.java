import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_10 {
    public static <T extends Comparable<T>> void shellSortInsertion(T[] a) {
        int N = a.length;
        int h = 1;
        int ex = 0;

        StdOut.println("The original array: ");
        printArray(a);

        while (h < N / 3) {
            h = 3 * h + 1; // decide sort interval based on size N
        }

        while (h >= 1) {

            // use insertion sort independently on each of the h subsequences
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                    ex++;
                }

            }
            StdOut.printf("%2d sort: ", h);
            printArray(a);
            h = h / 3;
        }
        StdOut.println("Times of updates using insertion sort: " + ex);

    }

    public static <T extends Comparable<T>> void shellSortSelection(T[] a) {
        int N = a.length;
        int h = 1;
        int ex = 0;
        StdOut.println("The original array: ");
        printArray(a);

        while (h < N / 3) {
            h = 3 * h + 1; // decide sort interval based on size N
        }

        while (h >= 1) {
            // use selection sort independently on each of the h subsequences
            for (int i = 0; i < N; i++) {
                int min = i;
                for (int j = i + h; j < N; j += h) {
                    if (less(a[j], a[min])) {
                        min = j;

                    }
                }
                exchange(a, i, min);
                ex++;

            }
            StdOut.printf("%2d sort: ", h);
            printArray(a);
            h = h / 3;
        }
        StdOut.println("Times of updates using selection sort: " + ex);
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
        String[] s1 = "E A S Y S H E L L S O R T Q U E S T I O N".split(" ");
        shellSortInsertion(s1);

        String[] s2 = "E A S Y S H E L L S O R T Q U E S T I O N".split(" ");
        shellSortSelection(s2);

    }

}
