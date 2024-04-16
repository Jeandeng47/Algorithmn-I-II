import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_24 {
    public static int gcd(int p, int q, int recur_depth) {
        printIndentation(recur_depth);
        StdOut.printf("p = %d, q = %d\n", p, q);

        if (p < 0 || q < 0) {
            throw new IllegalArgumentException("p and q must be non-negative.");
        }
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r, recur_depth++);
    }

    public static void printIndentation(int n) {
        for (int i = 0; i < n; i++) {
            StdOut.print("--");
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            StdOut.println("Usage: java Euclid <integer1> <integer2>");
            return;
        }
        try {
            int p = Integer.parseInt(args[0]);
            int q = Integer.parseInt(args[1]);
            StdOut.println("Computing the greatest common divisor of " + p + " and " + q);
            int result = gcd(p, q, 0);
            StdOut.println("The greatest common divisor of " + p + " and " + q + " is " + result);
        } catch (NumberFormatException e) {
            StdOut.println("Please provide two valid integers.");
        }
    }
}