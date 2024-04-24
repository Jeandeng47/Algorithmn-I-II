import java.util.Scanner;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_06 {
    public static void reverse(Queue<String> q) {
        Stack<String> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.push(q.dequeue());
        }
        StdOut.println("\nThe stack is: ");
        for (String s : stack) {

            StdOut.print(s);
        }
        while (!stack.isEmpty()) {
            q.enqueue((stack.pop()));
        }
        StdOut.println("\nThe queue is: ");
        for (String s : q) {

            StdOut.print(s);
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            q.enqueue(s);
        }
        scanner.close();

        reverse(q);
    }
}
