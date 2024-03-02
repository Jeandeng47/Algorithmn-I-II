import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int size;
    private int area;
    private int T;
    private double[] percoThreshold;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException(" n and trials must be larger than 0.");
        }
        size = n;
        area = n * n;
        T = trials;

        percoThreshold = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                // choose a site uniformly at random
                int row = StdRandom.uniformInt(n) + 1;
                int col = StdRandom.uniformInt(n) + 1;
                // open the random sites
                percolation.open(row, col);
            }
            // store threshold values into array
            percoThreshold[i] = percolation.numberOfOpenSites() / area;
        }

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(percoThreshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(percoThreshold);

    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        double xbar = mean();
        double s = stddev();
        double confidenceLo = xbar - 1.96 * s / Math.sqrt(T);
        return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        double xbar = mean();
        double s = stddev();
        double confidenceHi = xbar + 1.96 * s / Math.sqrt(T);
        return confidenceHi;
    }

    // test client (see below)
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java-algs4 PercolationStats n T");
        }
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats percStats = new PercolationStats(n, T);
        System.out.println("mean                    = " + percStats.mean());
        System.out.println("stddev                  = " + percStats.stddev());
        System.out.println("95% confidence interval = [" + percStats.confidenceLo()
                + ", " + percStats.confidenceHi() + "]");
    }
}
