
/**
 * readInts.java -- This class gets numbers from a file into an array
 * without knowing the file size. It enqueues numbers from a file, use
 * size() method and dequeue them into the array.
 */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class readInts {

    public static int[] readInt(String name) {
        In in = new In(name);
        Queue<Integer> q = new Queue<Integer>();

        while (!in.isEmpty()) {
            q.enqueue(in.readInt());
        }

        // get the size of the queue
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = q.dequeue();
        }
        return a;
    }

    public static void main(String[] args) {
        // check if filename is provided
        if (args.length < 1) {
            System.out.println("Usage: java ReadInts <file_name>");
            return;
        }
        String fileName = args[0];
        int[] numbers = readInt(fileName);
        for (int number : numbers) {
            StdOut.printf("%d ", number);
        }
    }

}