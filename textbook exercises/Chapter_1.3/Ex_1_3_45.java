import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_45 {
    public static boolean isUnderflow(String operations) {
        char[] operationChars = operations.toCharArray();
        // count = push - pop
        int count = 0;
        for (char c : operationChars) {
            if (c == '-') {
                count--;
                if (count < 0) { // Check for underflow immediately after each pop
                    return true;
                }
            } else {
                count++;
            }
        }
        return false;
    }

    public static boolean canGeneratePermutation(List<Integer> permutation) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        // false permuation: [4, 0, 2, 3, 1]
        for (int num : permutation) {
            while (i <= num) {
                stack.push(i);
                i++;
            }
            // first num: stack = [0, 1, 2, 3, 4] (i = 4)
            // second num: stack = [0, 1, 2, 3] (i = 4)
            if (stack.isEmpty() || stack.peek() != num) {
                return false;
                // second num: stack.peek() == 3 (!= 0) -> false
            } else {
                stack.pop();
                // first num: stack.peek() == num == 4, stack = [0, 1, 2, 3]
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // test isUnderflow algo
        String operations1 = "1 2 3 4 5 - - - -".replaceAll("\\s+", "");
        boolean isUnderflow1 = isUnderflow(operations1);
        StdOut.println(operations1 + (isUnderflow1 ? " has" : "has no") + " underflow.");

        String operations2 = "1 - - 2 3 - - - -".replaceAll("\\s+", "");
        boolean isUnderflow2 = isUnderflow(operations2);
        StdOut.println(operations2 + (isUnderflow2 ? " has" : "has no") + " underflow.");

        // test canGeneratePermutation algo

        int N = 5; // size of each permuation
        for (int i = 1; i <= 30; i++) {
            List<Integer> permutation = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                permutation.add(j);
            }
            Collections.shuffle(permutation); // make permuatation random

            boolean canGenerate = canGeneratePermutation(permutation);

            StdOut.println("Permutation " + permutation + " can be generated: " + canGenerate);
        }

    }
}
