import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_34 {
    private static List<Double> nums = new ArrayList<>();
    private static double min = Double.MIN_VALUE;
    private static double max = Double.MAX_VALUE;
    private static double sum = 0;
    private static double sumOfSquares = 0;
    private static double count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextDouble()) {
            double num = scanner.nextDouble();
            // save all nums in the list
            nums.add(num);
            // dynamically updated fixed variables
            processNum(num);
        }

        // - Print the maximum and minimum numbers.
        printMinMax();
        // - Print the median of the numbers.
        findAndPrintMedian();

        // - Print the k th smallest value, for k less than 100.
        // - Print the sum of the squares of the numbers.
        // - Print the average of the N numbers.
        // - Print the percentage of numbers greater than the average.
        // - Print the N numbers in increasing order.
        // - Print the N numbers in random order.

    }

    private static void processNum(double num) {
        // increase count and accumulate sum & sum of squares
        count++;
        sum += num;
        sumOfSquares += num * num;

        // update min and max
        if (num > max) {
            max = num;
        }
        if (num < min) {
            min = num;
        }
    }

    private static void printMinMax() {
        StdOut.printf("Min: %.2f, Max: %.2f", min, max);
    }

    private static void findAndPrintMedian() {

    }
}
