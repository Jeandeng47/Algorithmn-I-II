import java.util.Random;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_31 {
    public static void drawConnections(int N, double p) {
        // initialize
        StdDraw.setCanvasSize(800, 600);
        StdDraw.setScale(-1.2, 1.2);
        StdDraw.setPenRadius(0.004);
        StdDraw.setPenColor(StdDraw.BLUE);

        // calculate coordinates
        double[] x = new double[N];
        double[] y = new double[N];
        for (int i = 0; i < N; i++) {
            x[i] = Math.cos(2 * Math.PI * i / N);
            y[i] = Math.sin(2 * Math.PI * i / N);
            StdDraw.point(x[i], y[i]);
        }

        // draw lines with probability p
        StdDraw.setPenRadius(0.002);
        StdDraw.setPenColor(StdDraw.GRAY);
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (r.nextDouble() < p) {
                    StdDraw.line(x[i], y[i], x[j], y[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            StdOut.println("Usage: java RandomConnectionsStdDraw N p");
            return;
        }
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        if (p < 0 || p > 1) {
            StdOut.println("Probability must between 0 and 1");
            return;
        }
        drawConnections(N, p);
    }
}
