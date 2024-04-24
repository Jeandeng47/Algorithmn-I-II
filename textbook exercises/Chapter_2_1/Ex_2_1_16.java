import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_16 {
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

    public static <T extends Comparable<T>> boolean check(T[] a) {

        T[] copy = a.clone();
        selectionSort(copy); // now copy is sorted

        for (int i = 0; i < copy.length; i++) {
            if (a[i] != copy[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] unsortedArray = { 1, 9, 5, 6, 3, 4, 7, 2, 8, 10 };
        boolean isSorted1 = check(unsortedArray);
        StdOut.println("This array should be unsorted. IsSorted? " + isSorted1);

        Integer[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        boolean isSorted2 = check(sortedArray);
        StdOut.println("This array should be sorted. IsSorted? " + isSorted2);

    }
}
