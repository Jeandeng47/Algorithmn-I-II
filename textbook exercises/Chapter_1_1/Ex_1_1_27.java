import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_27 {

    private static int callCount = 0;
    private static int memoCalls = 0;
    private static int arrayCalls = 0;
    private static final Map<String, Double> memo = new HashMap<>();
    private static int memoizedRetrievals = 0;

    public static double binomial(int N, int k, double p) {
        callCount++;
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    public static double binomialMemo(int N, int k, double p) {
        memoCalls++;
        String key = N + "," + k; // key for current (N, k)
        if (memo.containsKey(key)) {
            memoizedRetrievals++;
            return memo.get(key); // retrieve the key in map
        }
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }

        double result = (1 - p) * binomialMemo(N - 1, k, p) + p * binomialMemo(N - 1, k - 1, p);
        memo.put(key, result); // put the key in map before returning
        return result;
    }

    public static double binomialArray(int N, int k, double p) {
        arrayCalls++;
        double[][] dp = new double[N + 1][k + 1];

        // initialization
        for (int i = 0; i <= N; i++) {
            dp[i][0] = Math.pow(1 - p, i); // rows: (1-p)^0, (1-p)^1,...
        }
        dp[0][0] = 1.0;

        // fill the array
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = p * dp[i - 1][j - 1] + (1 - p) * dp[i - 1][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= k; j++) {
                StdOut.printf("%.2f ", dp[i][j]);
            }
            StdOut.println();
        }

        return dp[N][k];

    }

    public static void main(String[] args) {
        double p = 0.4;
        int N = 10; // number of trials
        int k = 7; // number of successes

        // original implementation
        StdOut.println("Number of recursive calls: " + callCount);
        StdOut.printf("Binomial result: %.6f\n", binomial(N, k, p));
        StdOut.println();

        // improve with memoization
        StdOut.println("Number of memo recursive calls: " + memoCalls);
        StdOut.println("Memoized retrievals: " + memoizedRetrievals);
        StdOut.printf("Memorized Binomial result: %.6f\n", binomialMemo(N, k, p));
        StdOut.println();

        // place recursion with array-based iteration
        StdOut.println("Number of array-based recursive calls: " + arrayCalls);
        StdOut.printf("Array-based Binomial result: %.6f\n", binomialArray(N, k, p));

    }
}
