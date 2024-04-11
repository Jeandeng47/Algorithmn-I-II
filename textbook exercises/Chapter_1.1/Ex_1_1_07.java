import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_07 {
    public static void main(String[] args) {
        // compute the approximatioon of the sqaure root of the number
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);

        // compute the sum of 1 to 999
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);

        // compute the 10 times of the number 10;
        int sum2 = 0;
        int N = 10;
        // outter loop: 1, 2, 4, 8...1000
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < N; j++) {
                sum2++;
            }
        }
        StdOut.println(sum2);

    }
}
