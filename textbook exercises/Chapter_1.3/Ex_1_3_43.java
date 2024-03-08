import java.io.File;
import java.util.LinkedList;

import java.util.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_43 {
    public static void listFilesRecursive(File dir, int depth, Queue<String> q) {

        if (!dir.exists() || !dir.isDirectory()) {
            StdOut.println("The given directory is invalid.");
            return;
        }

        // store the files under the dir into a list
        File[] files = dir.listFiles();

        // define the base case
        if (files == null) {
            return;
        }

        // use indentation based on depth
        String indent = "----".repeat(depth);

        for (File file : files) {
            // for each file/dir, add path to queue with proper indent
            q.add(indent + file.getName());

            // define recursive cases
            if (file.isDirectory()) {
                listFilesRecursive(file, depth + 1, q);
            }
        }

    }

    public static void main(String[] args) {
        if (args.length == 0) {
            StdOut.println("Please enter the name of directory.");
            return;
        }

        File rootDir = new File(args[0]);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            StdOut.println("The given root directory is invalid.");
            return;
        }

        // create a queue to store the list of files
        Queue<String> queue = new LinkedList<>();
        listFilesRecursive(rootDir, 0, queue);

        while (!queue.isEmpty()) {
            StdOut.println(queue.poll());
        }
    }
}
