import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_34 {
    private static List<Double> nums = new ArrayList<>();
    private static double max = Double.MIN_VALUE;
    private static double min = Double.MAX_VALUE;
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

        // - Print the sum of the squares of the numbers.
        printSumOfSquares();

        // - Print the average of the N numbers.
        double average = printAverage();

        // - Print the percentage of numbers greater than the average.
        printPercLargerAvg(average);

        // - Print the N numbers in increasing order.
        printNumsAsc();

        // - Print the k th smallest value, for k less than 100.
        printKthSmallestNum(3);

        // - Print the N numbers in random order.
        printNumsRandom();

        scanner.close();

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
        StdOut.printf("Min: %.2f, Max: %.2f\n", min, max);
    }

    private static void findAndPrintMedian() {
        if (!nums.isEmpty()) {
            double median;
            if (nums.size() % 2 == 0) {
                median = (nums.get(nums.size() / 2 - 1)
                        + nums.get(nums.size() / 2)) / 2.0;
            } else {
                median = nums.get(nums.size() / 2);
            }
            StdOut.println("Median: " + median);
        }

    }

    private static double printAverage() {
        double average = sum / count;
        StdOut.println("Average: " + average);
        return average;
    }

    private static void printSumOfSquares() {
        StdOut.println("Sum of Squares: " + sumOfSquares);
    }

    private static void printNumsAsc() {
        Collections.sort(nums); // sort the list
        StdOut.println("Numbers in increasing order: ");
        for (double num : nums) {
            StdOut.printf("%.2f ", num);
        }
        StdOut.println();
    }

    private static void printKthSmallestNum(int k) {
        if (k <= nums.size()) {
            StdOut.println("The " + k + "th smallest value: " + nums.get(k - 1));
        }
    }

    private static void printPercLargerAvg(double average) {
        int percCount = 0;
        for (double num : nums) {
            if (num > average) {
                percCount++;
            }
        }
        StdOut.println("Percentage of numbers greater than the average: " +
                (percCount * 100.0 / count) + "%");

    }

    private static void printNumsRandom() {
        Collections.shuffle(nums);
        StdOut.println("Numbers in random order: ");
        for (double num : nums) {
            StdOut.printf("%.2f ", num);
        }
        StdOut.println();
    }

}
