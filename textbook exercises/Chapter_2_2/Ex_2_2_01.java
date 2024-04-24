import edu.princeton.cs.algs4.StdOut;

public class Ex_2_2_01 {

    // make the aux and input array global
    public static Comparable<Character>[] aux;
    public static Comparable<Character>[] input;;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void mergeInPlace(Comparable[] a, int lo, int mid, int hi) {

        int i = lo; // trace movement in a[lo, mid]
        int j = mid + 1; // trace movement in a[mid+1, hi]

        // k traces movement in sorted array
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        StdOut.printf("%s ", "input: k");
        printSubArray(input, 0, input.length, true);
        StdOut.printf("%5s %5s\n", "i", "j");

        for (int k = lo; k <= hi; k++) {

            StdOut.printf("%8s ", k);
            printSubArray(input, 0, k, true);

            StdOut.printf("%10s %10s | ", i, j);
            printSubArray(aux, i, mid, true);
            printSubArray(aux, j, aux.length, false);

            if (i > mid) { 
                // case 1: left exhausted
                a[k] = aux[j++];
            } else if (j > hi) { 
                // case 2: right exhausted
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) { 
                // case 3: right element less than left
                a[k] = aux[j++];
            } else { 
                // case 4: left element less than right
                a[k] = aux[i++];
            }

        }

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void printSubArray(Object[] a, int begin, int end, boolean inline) {
        for (int i = 0; i < a.length; i++) {
            Object obj = a[i];
            if (i < begin) {
                StdOut.print(" ");
            } else if (i >= begin && i <= end) {
                StdOut.print(obj == null ? "null " : obj + " ");
            } else {
                StdOut.print(" ");
            }
        }
        // If not on the same line, print empty line after each iteration
        if (!inline) {
            StdOut.println();
        }
    }

    private static void printArray(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        // A E Q S U Y E I N O S T
        input = new Character[] { 'A', 'E', 'Q', 'S', 'U', 'Y', 'E', 'I', 'N', 'O', 'S', 'T' };
        aux = new Character[input.length];
        mergeInPlace(input, 0, 5, 11);
        StdOut.print("output: ");
        printArray(input);

    }

}
