import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_32 {

    private static int getMax(int[] counts) {
        int max = 0;
        for (int count : counts) {
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            StdOut.println(" Usage: echo <data...> | java Ex_1_1_32 <int N> <double l> <double r>");
            return;
        }

        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);

        if (l >= r) {
            StdOut.println("Error: l must be less than r.");
            return;
        }

        int[] counts = new int[N];
        double binSize = (r - l) / N;

        StdOut.println("Reading input values and categorizing into bins...");
        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            if (value >= l && value < r) {
                int index = (int) ((value - l) / binSize);
                if (index >= 0 && index < N) {
                    counts[index]++;
                }
            }
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.printf("%d ", counts[i]);
        }
        System.out.println("");

        // Get the max count to set the y-scale
        int maxCount = getMax(counts);

        // Setting up the canvas and scales
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(l - 0.5, r + 0.5);
        StdDraw.setYscale(-0.5, maxCount + 0.5);

        // Drawing the histogram
        double w = binSize;
        for (int i = 0; i < N; i++) {
            double x = l + w / 2.0 + w * i; // Center of the bin
            double y = counts[i] / 2.0; // Center y of the rectangle
            double rw = w / 4.0;
            double rh = counts[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
            StdDraw.text(x, 2 * y + 0.1, counts[i] + "");
        }
    }

}
