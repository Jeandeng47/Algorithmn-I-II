import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_37 {
    public static <T> void printQueue(Queue<T> queue) {
        for (T item : queue) {
            StdOut.print(item + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]); // number of people
        int M = Integer.parseInt(args[1]); // Mth person to be eliminated

        Queue<Integer> queue = new Queue<>();
        for (int i = 1; i <= N; i++) {
            queue.enqueue(i); // list: 1 2 3 4 5 6 7
        }
        // Print initial queue state
        StdOut.println("Initial queue state:");
        printQueue(queue);

        while (queue.size() > 1) {
            // iterate over M-1 people
            for (int i = 1; i < M; i++) {
                queue.enqueue(queue.dequeue());
            }
            StdOut.println("Eliminated " + queue.dequeue());

            // Optional: Print the queue state after each elimination
            printQueue(queue);
        }
        StdOut.println("\nFreed person: " + queue.dequeue());
    }
}
