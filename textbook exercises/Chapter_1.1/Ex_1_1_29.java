import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_29 {

    public static int rank(int key, int[] sortedArray) {
        // return the number of elements smaller than the key
        int lo = 0;
        int hi = sortedArray.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            StdOut.printf("Lo: %d, Hi: %d Mid: %d\n", lo, hi, mid);

            if (key <= sortedArray[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
        // lo is the index of first element larger than key
        // lo is also the number of elements less than the key

    }

    public static int count(int key, int[] sortedArray) {
        int count = 0;
        // find the minimum index where the key could be inserted
        int firstIndex = rank(key, sortedArray);
        while (firstIndex < sortedArray.length
                && sortedArray[firstIndex] == key) {
            count++;
            firstIndex++;
        }
        return count; // return the number of elements equal to the key
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 };
        int key = 3;

        int rankResult = rank(key, a);
        StdOut.println();
        int countResult = count(key, a);

        System.out.println("Number of elements less than " + key + ": " + rankResult);
        System.out.println("Number of elements equal to " + key + ": " + countResult);
    }
}