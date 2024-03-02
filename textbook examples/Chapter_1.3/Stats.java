
/**
 * Stats.java -- this class illustrates a typical bag client. 
 * This class computes the average and sample standard 
 * deviation of the double values reading by standard inputs.
 */

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<Double>();
        // read doubles into bag
        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }
        // get the size of the bag
        int N = numbers.size();

        double sum = 0.0;
        for (double x : numbers) {
            sum += x;
        }
        // compute mean of all doubles
        double mean = sum / N;

        sum = 0.0;
        for (double x : numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum / (N - 1));

        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);

    }
}