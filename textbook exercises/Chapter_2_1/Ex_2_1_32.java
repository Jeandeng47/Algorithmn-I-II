import java.util.Random;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Ex_2_1_32 {
    private static void plotResults(double[] sizes, double[] selectTimes, double[] insertTimes, double[] shellTimes) {
        StdDraw.setCanvasSize(800, 400);
        StdDraw.setXscale(sizes[0] * 0.9, sizes[sizes.length - 1] * 1.1); // 10% margin
        double maxTime = getMaxTime(selectTimes, insertTimes, shellTimes);
        StdDraw.setYscale(maxTime * -0.1, maxTime * 1.1); // 10% margin
        StdDraw.setPenRadius(0.005);

        // draw selection sort times
        StdDraw.setPenColor(StdDraw.BLUE);
        drawDotLine(sizes, selectTimes);

        // draw insertion sort times
        StdDraw.setPenColor(StdDraw.GREEN);
        drawDotLine(sizes, insertTimes);

        // draw sell sort times
        StdDraw.setPenColor(StdDraw.RED);
        drawDotLine(sizes, shellTimes);
    }

    private static void drawDotLine(double[] sizes, double[] times) {
        for (int i = 0; i < sizes.length; i++) {

            StdDraw.point(sizes[i], times[i]);
            if (i > 0) {
                StdDraw.line(sizes[i - 1], times[i - 1], sizes[i], times[i]);
            }
        }
    }

    // helper method to return the maximum time of all sorts
    private static double getMaxTime(double[]... arrays) {
        double max = 0.0;
        for (double[] array : arrays) {
            for (double value : array) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }

    public static double time(String algo, int size, int trials) {
        double totalTime = 0.0;
        for (int i = 0; i < trials; i++) {
            Stopwatch watch = new Stopwatch();
            Integer[] original = getRandomIntArray(size);
            Integer[] a = original.clone();
            switch (algo) {
                case "insertion sort":
                    insertionSort(a);
                    break;
                case "selection sort":
                    a = original.clone();
                    selectionSort(a);
                    break;
                case "shell sort":
                    a = original.clone();
                    shellSort(a);
                    break;
                default:
                    break;
            }
            totalTime += watch.elapsedTime();

        }
        return totalTime / trials;
    }

    private static Integer[] getRandomIntArray(int size) {
        Integer[] a = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt(size);
        }
        return a;
    }

    // shell sort
    public static <T extends Comparable<T>> void shellSort(T[] a) {
        int N = a.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }

            }
            h = h / 3;
        }

    }

    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            T key = a[i]; // the key to insert
            int j = i;
            // no sentinel, check j > 0 here
            while (j > 0 && less(key, a[j - 1])) {
                a[j] = a[j - 1]; // move the larger one to the right
                j--;
            }
            a[j] = key;
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            // if a[j] is less than a[j-1]
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
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

    public static void main(String[] args) {
        // Default values
        int arraySize = 1000;
        int numberOfDoubles = 5;
        int numberOfSorts = 10;

        // Parse command line
        StdOut.println(
                "Please enter array size, number of doublings and number of sorting as command line arguments: ");

        if (args.length >= 3) {
            try {
                arraySize = Integer.parseInt(args[0]);
                numberOfDoubles = Integer.parseInt(args[1]);
                numberOfSorts = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing command-line arguments. Using default values.");
            }
        }

        // Arrays to hold the sizes and times for each sort
        double[] sizes = new double[numberOfDoubles]; // 1000, 2000, 4000...
        double[] selectTimes = new double[numberOfDoubles];
        double[] insertTimes = new double[numberOfDoubles];
        double[] shellTimes = new double[numberOfDoubles];

        for (int i = 0; i < numberOfDoubles; i++) {
            sizes[i] = arraySize; // Use log scale for sizes
            selectTimes[i] = time("selection sort", arraySize, numberOfSorts);
            insertTimes[i] = time("insertion sort", arraySize, numberOfSorts);
            shellTimes[i] = time("shell sort", arraySize, numberOfSorts);
            arraySize = arraySize * 2; // double array size
        }

        plotResults(sizes, selectTimes, insertTimes, shellTimes);

    }
}