
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_2_1 {
    public static void main(String[] args) {
        if (args.length < 1) {
            StdOut.println("Usage: java Ex_1_2_1 <intN>");
        }

        int N = Integer.parseInt(args[0]); // number of points
        Point2D[] points = new Point2D[N];

        // set up StdDraw
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLACK);

        // generate N random points
        for (int i = 0; i < N; i++) {
            double x = Math.random();
            double y = Math.random();
            points[i] = new Point2D(x, y);
            points[i].draw();
        }

        // compute the smallest distance
        double minDistance = Double.POSITIVE_INFINITY;
        Point2D p1 = null;
        Point2D p2 = null;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double distance = points[i].distanceTo(points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                    p1 = points[i];
                    p2 = points[j];
                }

            }
        }

        // draw the red line between the closest points
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.015);
        p1.drawTo(p2);

        StdOut.println("Closest distance: " + minDistance);

    }
}
