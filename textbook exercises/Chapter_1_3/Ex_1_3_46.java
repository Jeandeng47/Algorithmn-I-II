import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_46 {

    public static boolean hasForbiddenTripleBruteForce(int[] permutation) {

        // violation: c -> a -> b (a < b < c)

        // Loop through each number in the permutation
        for (int i = 0; i < permutation.length; i++) {

            for (int j = i + 1; j < permutation.length; j++) {

                // if a < c
                if (permutation[j] < permutation[i]) {

                    for (int k = j + 1; k < permutation.length; k++) {

                        // if a < b < c
                        if (permutation[k] > permutation[j] && permutation[k] < permutation[i]) {
                            // Found a forbidden triple
                            return true;
                        }
                    }
                }
            }
        }
        // No forbidden triple found
        return false;
    }

    public static boolean canGeneratePermutation(int[] permutation) {
        Stack<Integer> stack = new Stack<>();
        int max = -1;
        int nextExpected = 0;

        for (int num : permutation) {
            // If the number is less than max and not the next expected, it's a violation
            if (num < max && num != nextExpected) {
                return false; // A forbidden triple is detected
            }

            // If the number matches the next expected number,
            // it means we can "virtually" pop it from the stack
            while (!stack.isEmpty() && stack.peek() == nextExpected) {
                max = stack.pop(); // Update max after popping
                nextExpected++; // Update the next expected number
            }

            // Push the current number onto the stack if it's not immediately expected
            if (num != nextExpected) {
                stack.push(num);
                max = Math.max(max, num); // Update max
            } else {
                nextExpected++; // Move to the next expected number
            }
        }

        return true;
    }

    public static void main(String[] args) {
        StdOut.println("Using hasForbiddenTripleBruteForce: ");
        int[] falsePermutation = { 4, 0, 2, 3, 1 };
        boolean hasTripple1 = hasForbiddenTripleBruteForce(falsePermutation);
        StdOut.println("Permutation " + (hasTripple1 ? "cannot" : "can") + " be generated.");

        int[] truePermutation = { 1, 2, 3, 0, 4 };
        boolean hasTripple2 = hasForbiddenTripleBruteForce(truePermutation);
        StdOut.println("Permutation " + (hasTripple2 ? "cannot" : "can") + " be generated.");

        StdOut.println("Using canGeneratePermutation: ");
        boolean canGenerate1 = canGeneratePermutation(falsePermutation);
        StdOut.println("Permutation " + (canGenerate1 ? "can" : "cannot") + " be generated.");

        boolean canGenerate2 = canGeneratePermutation(truePermutation);
        StdOut.println("Permutation " + (canGenerate2 ? "can" : "cannot") + " be generated.");

    }
}
