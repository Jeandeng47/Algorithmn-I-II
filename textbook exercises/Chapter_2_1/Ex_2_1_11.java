import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_11 {
    public static <T extends Comparable<T>> void shellSort(T[] a) {
        int N = a.length;
        int[] hArray = new int[N / 3]; // 16 / 3 = 5

        // i < N / 3, 3*i + 1 < N + 1
        for (int i = 0; i < hArray.length; i++) {
            hArray[i] = 3 * i + 1; // 1,4,7,10,13
        }

        // start from the largest h
        for (int k = hArray.length - 1; k >= 0; k--) {
            int h = hArray[k]; // h sort
            StdOut.printf("%d sort: \n", h);
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j - h])) {
                        exchange(a, j, j - h);
                    }
                    printArray(a);
                    printArrow(j, j - h, h, N);
                }
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

    public static <T> void printArray(T[] a) {
        for (T item : a) {
            StdOut.print(item + " ");
        }
        StdOut.println();
    }

    public static void printArrow(int i, int j, int h, int length) {
        for (int k = 0; k < length; k++) {
            if (k == i) {
                StdOut.print("^ ");
            } else if (k == j) {
                StdOut.print("* ");
            } else {
                StdOut.print("  ");
            }
        }
        StdOut.println();

    }

    public static void main(String[] args) {

        String[] s = "S H E L L S O R T E X A M P L E".split(" ");
        shellSort(s);
    }

}
