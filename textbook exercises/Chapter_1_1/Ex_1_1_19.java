import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_19 {
    // global variable to memo
    private static long[] memo;

    public static long F(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return F(N - 1) + F(N - 2);
    }

    public static long Fmemo(int N) {
        if (memo == null) {
            memo = new long[N + 1];

            // initialze the array
            for (int i = 0; i < memo.length; i++) {
                memo[i] = -1;
            }
            // base case
            memo[0] = 0;
            memo[1] = 1;
        }

        // return the stored result
        if (memo[N] != -1) {
            return memo[N];
        }

        // store the result
        memo[N] = Fmemo(N - 1) + Fmemo(N - 2);
        return memo[N];
    }

    public static void main(String[] args) {
        int M = 50;
        System.out.println("F(" + M + ") = " + Fmemo(M));

        for (int N = 0; N < 51; N++) {
            StdOut.println(N + " " + F(N));
        }
    }
}
