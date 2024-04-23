
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex_1_2_3 {
    public static void main(String[] args) {
        if (args.length < 3) {
            StdOut.println("Usage: java Ex_1_2_3 <intN> <doubleMin> <doubleMax>");
        }

        // parse commands
        int N = Integer.parseInt(args[0]); // number of intervals
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);

        // set up stddraw
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(0.005);

        // generate random intervals
        Interval2D[] intervals = new Interval2D[N];
        for (int i = 0; i < N; i++) {
            double xlo = StdRandom.uniformDouble(min, max);
            double xhi = StdRandom.uniformDouble(xlo, max);
            double ylo = StdRandom.uniformDouble(min, max);
            double yhi = StdRandom.uniformDouble(ylo, max);

            Interval1D intervalx = new Interval1D(xlo, xhi);
            Interval1D intervaly = new Interval1D(ylo, yhi);
            intervals[i] = new Interval2D(intervalx, intervaly);
            intervals[i].draw();
        }

        // count intersections and containments
        int intersectCount = 0;
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.setPenRadius(0.005);
                if (intervals[j].intersects(intervals[k])) {
                    intersectCount++;
                    intervals[j].draw();
                    intervals[k].draw();
                    StdOut.println(intervals[j] + " intersects with " + intervals[k]);
                }
            }
        }
        StdOut.println("The number of intersecting interval pairs is: " + intersectCount);

        // calculate intersections and containments
    }
}