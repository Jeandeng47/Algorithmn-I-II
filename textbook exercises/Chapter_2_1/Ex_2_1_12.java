import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_12 {

    public static <T extends Comparable<T>> double shellSort(T[] a) {
        int N = a.length;
        int[] hArray = new int[N / 3];
        int totalCompares = 0;

        for (int i = 0; i < hArray.length; i++) {
            hArray[i] = 3 * i + 1;
        }

        for (int k = hArray.length - 1; k >= 0; k--) {
            int h = hArray[k];
            int compares = 0;
            StdOut.printf("%d sort: \n", h);
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j - h])) {
                        exchange(a, j, j - h);
                        compares++;
                    }
                }

            }

            totalCompares += compares;
            double ratioPerH = (double) compares / N; // number of compares devided by array size
            StdOut.printf("Gap h: %d. Number of compares: %2d. Compares over size: %2f.\n", h, compares, ratioPerH);

        }
        double ratio = (double) totalCompares / N;
        return ratio;
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

    public static void main(String[] args) {

        Random rand = new Random();
        int power = 2; // Start with 10^2 = 100
        int trials = 5; // For each power of 10, how many trials to average

        while (power <= 2) {
            int size = (int) Math.pow(10, power);
            double totalRatios = 0;

            for (int t = 0; t < trials; t++) {
                Double[] ranDoubles = new Double[size];
                for (int i = 0; i < size; i++) {
                    ranDoubles[i] = rand.nextDouble();
                }

                double ratio = shellSort(ranDoubles);
                totalRatios += ratio;
            }

            double avgRatio = totalRatios / trials;
            StdOut.printf("Array size: 10^%d: Average Ratio of compares: %f%n", power, avgRatio);

            power++;
        }
    }

}
