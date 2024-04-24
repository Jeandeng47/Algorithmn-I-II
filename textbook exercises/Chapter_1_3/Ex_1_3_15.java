import java.util.Scanner;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_15 {

    // helper method to check whether input k is valid
    private static int validateCommands(String[] args) {
        if (args.length < 1) {
            StdOut.println("Enter integer K as a command line element: java filename.java k");
            return -1;
        }

        int k = Integer.parseInt(args[0]); // convert string to Int
        if (k <= 0) {
            StdOut.println("K must be a positive integer.");
            return -1;
        }

        return k;
    }

    // helper method to store
    private static Queue<String> storeCommands(int k) {

        Scanner scanner = new Scanner(System.in);
        Queue<String> queue = new Queue<>();

        while (scanner.hasNext()) {
            String currentStr = scanner.next();
            // the queue hold the last k strings
            if (queue.size() == k) {
                queue.dequeue();
            }
            queue.enqueue(currentStr);
        }
        scanner.close();
        return queue;
    }

    // helper method to print the kth command from the last string
    private static void printKthCommand(Queue<String> queue, int k) {
        if (queue.size() < k) {
            StdOut.println("Not enough strings provided.");
        } else {
            StdOut.println("The " + k + "th string from the last comand: " + queue.dequeue());
        }

    }

    public static void main(String[] args) {

        int k = validateCommands(args);
        if (k == -1) {
            StdOut.println("K is not valid.");
        }

        StdOut.println("Enter string: ");
        Queue<String> queue = storeCommands(k);

        printKthCommand(queue, k);
    }
}
