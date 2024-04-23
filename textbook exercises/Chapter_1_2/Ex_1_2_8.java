
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_2_8 {
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            StdOut.printf("%d ", array[i]);
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 6, 7, 8, 9, 10 };

        StdOut.println("Array a before operation: ");
        printArray(a);
        StdOut.println("Array b before operation: ");
        printArray(b);

        int[] t = a;
        a = b;
        b = t;

        StdOut.println("Array a after operation: ");
        printArray(a);
        StdOut.println("Array b after operation: ");
        printArray(b);
    }
}
