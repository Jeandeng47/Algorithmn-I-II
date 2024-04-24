import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class Ex_1_3_05 {
    public static void decToBin(int N) {
        Stack<Integer> stack = new Stack<>();
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) {
            StdOut.print(d);
        }
        StdOut.println();
    }

    public static void main(String[] args) {

        StdOut.println("Enter an integer: ");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();
        decToBin(N);
    }
}
