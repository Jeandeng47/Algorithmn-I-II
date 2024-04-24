import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_09 {
    public static void main(String[] args) {
        if (args.length < 1) {
            StdOut.println("Usage: java Ex_1_1_09 <int>");
        }

        try {
            int N = Integer.parseInt(args[0]);
            String s = "";
            for (int n = N; n > 0; n = n / 2) {
                s = (n % 2) + s;
            }
            StdOut.printf("The binary representation of positive integer %d is %s\n", N, s);
        } catch (NumberFormatException e) {
            StdOut.println("The arguments are invalid.");
        }

    }
}
