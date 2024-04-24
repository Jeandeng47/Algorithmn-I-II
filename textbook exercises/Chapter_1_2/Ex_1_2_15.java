import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_2_15 {
    public static int[] readInts(String name) {
        In in = new In(name);
        String input = in.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ints[i] = Integer.parseInt(words[i]);
        }
        return ints;
    }

    public static int[] readIntsQueue(String name) {
        In in = new In(name);
        // use a queue to read in ints
        Queue<Integer> q = new Queue<>();
        while (!in.isEmpty()) {
            q.enqueue(in.readInt());
        }
        int size = q.size();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = q.dequeue(); // FIFO
        }
        return ints;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            StdOut.println("Usage: java Ex_1_2_15 <file_name>");
            return;
        }

        String fileName = args[0];

        // Use readInts method
        StdOut.println("Reading integers using readInts method:");
        try {
            int[] ints = readInts(fileName);
            for (int i : ints) {
                StdOut.print(i + " ");
            }
            StdOut.println();
        } catch (Exception e) {
            StdOut.println("Error reading file with readInts: " + e.getMessage());
        }

        // Use readIntsQueue method
        StdOut.println("Reading integers using readIntsQueue method:");
        try {
            int[] intsQueue = readIntsQueue(fileName);
            for (int i : intsQueue) {
                StdOut.print(i + " ");
            }
            StdOut.println();
        } catch (Exception e) {
            StdOut.println("Error reading file with readIntsQueue: " + e.getMessage());
        }
    }

}
