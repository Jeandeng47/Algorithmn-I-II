import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_30 {
    // if two numbers are relatively prime, then their biggest common divisor is one
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        int M = 10;
        int N = 10;
        boolean[][] matrix = new boolean[M][N];

        // initialize the matrix elements
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = (gcd(i, j) == 1);
            }
        }

        // print the matrix elements
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                StdOut.print(matrix[i][j] ? "T " : "F ");
            }
            StdOut.println();
        }
    }
}