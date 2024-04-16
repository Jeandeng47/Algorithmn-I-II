import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_20 {
    public static double lgFactorial(int N) {
        // define base case
        if (N == 1 || N == 0) {
            return 0;
        }
        // ln(N!) = ln(N) + ln((N-1)!)
        return Math.log(N) + lgFactorial(N - 1);
    }

    public static void main(String[] args) {
        int N = 10;
        StdOut.printf("ln(" + N + ") is: %.2f\n", lgFactorial(N));

    }
}
