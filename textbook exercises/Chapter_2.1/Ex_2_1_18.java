import java.util.Scanner;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_18 {

    // initialize the canvas
    private static void initializeCanvas(int N) {
        StdDraw.setCanvasSize(800, 400);
        StdDraw.setXscale(-1, N);
        StdDraw.setYscale(-0.05, 1);
        StdDraw.setPenRadius(0.015);
    }

    // draw a specific bar on the canvas
    private static void show(Double[] a, int current, int hightlight, boolean isInsertion, int sortedBoundary) {
        StdDraw.clear();
        for (int i = 0; i < a.length; i++) {
            if (i == current) {
                StdDraw.setPenColor(StdDraw.BLUE);
            } else if (i == hightlight) {
                StdDraw.setPenColor(StdDraw.RED);
            } else if (i <= sortedBoundary) {
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            } else {
                StdDraw.setPenColor(StdDraw.DARK_GRAY);
            }
            double x = i;
            double y = a[i] * 0.5;
            double rectWidth = 0.3;
            double rectHeight = a[i] * 0.5;
            StdDraw.filledRectangle(x, y, rectWidth, rectHeight);
        }
        StdDraw.show();
        StdDraw.pause(1000);
    }

    public static void selectionSort(Double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            show(a, i, min, false, i); // Visualize after swapping
            exchange(a, i, min);

        }
    }

    public static void insertionSort(Double[] a) {
        int N = a.length;

        for (int i = 1; i < N; i++) {
            int j = i;

            // Show the initial state before insertion starts

            for (; j > 0 && less(a[j], a[j - 1]); j--) {
                show(a, j, j - 1, true, i); // Visualize
                exchange(a, j, j - 1);

            }

        }

    }

    private static void exchange(Double[] a, int i, int j) {
        Double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Double v, Double w) {
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        int N = 50;
        Double[] a = new Double[N];

        for (int i = 0; i < N; i++) {
            a[i] = Math.random();
        }

        Scanner scanner = new Scanner(System.in);
        StdOut.println("Enter 0 to animiate selection sort, 1 to animate insertion sort");
        int choice = Integer.parseInt(scanner.nextLine());
        scanner.close();

        initializeCanvas(N);

        if (choice == 0) {
            selectionSort(a);
        } else if (choice == 1) {
            insertionSort(a);
        } else {
            StdOut.println("Invalid choice. Re-enter.");
        }

        System.exit(0);

    }

}
