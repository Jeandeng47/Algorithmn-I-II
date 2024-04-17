import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_28 {
    public static int[] generateRandomArray(int size, int maxValue) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * (maxValue + 1));
        }
        return array;
    }

    public static int[] removeDuplicates(int[] array) {
        if (array.length <= 2) {
            return array;
        }
        int i = 0; // slower pointer
        for (int j = 1; j < array.length; j++) {
            if (array[i] != array[j]) {
                i++;
                array[i] = array[j];
            }
        }
        // elements between 0 to i are distinct
        return Arrays.copyOf(array, i + 1);

    }

    public static void main(String[] args) {
        int size = 100;
        int maxValue = 10;
        int[] whitelist = generateRandomArray(size, maxValue);
        StdOut.println("The original array: ");
        StdOut.println(Arrays.toString(whitelist));

        Arrays.sort(whitelist);
        StdOut.println("The sorted array: ");
        StdOut.println(Arrays.toString(whitelist));

        whitelist = removeDuplicates(whitelist);
        StdOut.println("The unique array: ");
        StdOut.println(Arrays.toString(whitelist));

    }
}
