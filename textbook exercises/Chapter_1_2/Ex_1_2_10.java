
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex_1_2_10 {
    public static class VisualCounter {
        private int count;
        private int operationCount;
        private final int maxOperations;
        private final int maxAbsValue;

        public VisualCounter(int N, int max) {
            this.maxOperations = N;
            this.maxAbsValue = max;
            this.count = 0;
            this.operationCount = 0;
            initializePlot();
        }

        private void initializePlot() {
            StdDraw.setXscale(0, maxOperations);
            StdDraw.setYscale(-maxAbsValue, maxAbsValue);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.setPenRadius(0.015);
        }

        public void increment() {
            if (operationCount < maxOperations && Math.abs(count + 1) <= maxAbsValue) {
                count++;
                operationCount++;
                plot();
            }

        }

        public void decrement() {
            if (operationCount < maxOperations && Math.abs(count - 1) <= maxAbsValue) {
                count--;
                operationCount++;
                plot();
            }

        }

        public int tally() {
            return count;
        }

        private void plot() {
            StdDraw.point(operationCount, count);
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            StdOut.println("Usage: java Ex_1_2_10 <intN> <intMax>");
        }

        int N = Integer.parseInt(args[0]); // maximum number of operations
        int max = Integer.parseInt(args[1]); // maximum absolute value for the counter
        VisualCounter vc = new VisualCounter(N, max);

        for (int i = 0; i < N; i++) {
            if (StdRandom.bernoulli(0.5) == true) {
                vc.increment();
            } else {
                vc.decrement();
            }
        }

    }
}
