import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_13 {
    public static boolean isQueuePossible(int[] sequence) {
        int next = 0; // next element to enqueue
        Queue<Integer> q = new Queue<>();
        // enqueue simulation
        for (int num : sequence) {
            while (next <= num && next <= 9) {
                q.enqueue(next);
                StdOut.println("Enqueued: " + next);
                next++;
            }
            // if next to dequeue does not match the current number
            if (q.isEmpty() || q.peek() != num) {
                StdOut.println("The next number to dequeue (" + q.peek() + ") does not match " + num);
                return false;
            } else {
                q.dequeue();
                StdOut.println("Dequeued: " + num);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] sequences = {
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 4, 6, 8, 7, 5, 3, 2, 9, 0, 1 },
                { 2, 5, 6, 7, 4, 8, 9, 3, 1, 0 },
                { 4, 3, 2, 1, 0, 5, 6, 7, 8, 9 }
        };
        for (int i = 0; i < sequences.length; i++) {
            boolean isPossible = isQueuePossible(sequences[i]);
            StdOut.println("The sequence " + (char) ('a' + i)
                    + (isPossible ? " is possible." : " is impossible"));
        }

    }
}
