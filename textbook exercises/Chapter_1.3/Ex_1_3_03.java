import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_03 {
    public static boolean isValidSequence(int[] sequence) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder operations = new StringBuilder();

        int next = 0; // next number to be pushed into stack

        for (int num : sequence) {
            while (next <= num) {
                stack.push(next++);
                operations.append("Push ").append(next - 1).append(", ");
            }
            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                operations.append("Pop ").append(num).append(", ");
            } else {
                return false;
            }
        }
        StdOut.println(operations.toString());
        return true;
    }

    public static void main(String[] args) {
        int[][] sequences = {
                { 4, 3, 2, 1, 0, 9, 8, 7, 6, 5 },
                { 4, 6, 8, 7, 5, 3, 2, 9, 0, 1 },
                { 2, 5, 6, 7, 4, 8, 9, 3, 1, 0 },
                { 4, 3, 2, 1, 0, 5, 6, 7, 8, 9 },
                { 1, 2, 3, 4, 5, 6, 9, 8, 7, 0 },
                { 0, 4, 6, 5, 3, 8, 1, 7, 2, 9 },
                { 1, 4, 7, 9, 8, 6, 5, 3, 0, 2 },
                { 2, 1, 4, 3, 6, 5, 8, 7, 9, 0 }
        };

        for (int i = 0; i < sequences.length; i++) {
            boolean isValid = isValidSequence(sequences[i]);
            StdOut.println("Sequence " + (char) ('a' + i)
                    + (isValid ? " is possible.\n" : " is impossible.\n"));
        }
    }
}
