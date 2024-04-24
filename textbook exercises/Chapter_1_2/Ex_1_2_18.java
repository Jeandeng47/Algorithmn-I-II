import edu.princeton.cs.algs4.StdOut;

public class Ex_1_2_18 {
    public static class Accumulator {
        private double m;
        private double s;
        private int N;

        public void addDataValue(double x) {
            N++;
            s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
            m = m + (x - m) / N;
        }

        public double mean() {
            return m;
        }

        public double var() {
            return s / (N - 1);
        }

        public double stddev() {
            return Math.sqrt(this.var());
        }

    }

    public static void main(String[] args) {

        // Create a dataset with larger numbers and higher variance
        double[] data = new double[1000];
        for (int i = 0; i < data.length; i++) {
            data[i] = Math.pow(-1, i) * 1e10 + i; // Alternating sign with increasing magnitude
        }

        // Traditional calculation of mean and variance
        double tMean = 0;
        double tVariance = 0;

        for (double x : data) {
            tMean += x;
        }
        tMean /= data.length;

        for (double x : data) {
            tVariance += (x - tMean) * (x - tMean);
        }
        tVariance /= (data.length - 1);

        // calculation using accumulator
        Accumulator accumulator = new Accumulator();
        for (double x : data) {
            accumulator.addDataValue(x);
        }

        double aMean = accumulator.mean();
        double aVariance = accumulator.var();

        // Print results from both methods
        StdOut.printf("Traditional Mean: %.6f\n", tMean);
        StdOut.printf("Traditional Variance: %.6f\n", tVariance);
        StdOut.printf("Updated Mean: %.6f\n", aMean);
        StdOut.printf("Updated Variance: %.6f\n", aVariance);

        // Output difference in variance calculations
        StdOut.printf("Difference in Variance: %.6f\n", Math.abs(tVariance - aVariance));

    }
}
