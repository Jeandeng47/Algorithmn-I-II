import java.util.Scanner;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class Ex_1_4_03 {

    @SuppressWarnings("deprecation")
    // method to measure the execution time of the threeSum.count() for a given
    // problem size N
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int count = ThreeSum.count(a); // execute count() with array a
        return timer.elapsedTime();
    }

    public static void setupCanvas(int width, int height, double xScaleStart, double xScaleEnd, double yScaleStart,
            double yScaleEnd) {
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(xScaleStart, xScaleEnd);
        StdDraw.setYscale(yScaleStart, yScaleEnd);
    }

    public static void plotPoints(int N, boolean isLogLog) {
        double prevX = 0, prevY = 0;
        for (int n = 250; n <= N; n *= 2) {
            double time = timeTrial(n);
            StdOut.printf("%7d %5.1f\n", n, time);

            double x = isLogLog ? Math.log(n) : n;
            double y = isLogLog ? Math.log(time) : time;

            // Plot points and lines
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(x, y);

            if (prevX != 0 && prevY != 0) {
                StdDraw.setPenRadius(0.001);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.line(prevX, prevY, x, y);
            }

            prevX = x;
            prevY = y;
        }
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose plot type (1 for Standard, 2 for Log-Log):");
            int choice = scanner.nextInt();

            int N = 1000000; // Max value of N

            switch (choice) {
                case 1:
                    setupCanvas(400, 400, 0, 10000, 0, 100);
                    plotPoints(N, false);
                    break;
                case 2:
                    setupCanvas(400, 400, Math.log(250), Math.log(N), -10, 5); 
                    plotPoints(N, true);
                    break;
                default:
                    StdOut.println("Invalid choice.");
                    break;
            }
        } catch (Exception e) {
            StdOut.println("Error reading input: " + e.getMessage());
        }
    }
}
