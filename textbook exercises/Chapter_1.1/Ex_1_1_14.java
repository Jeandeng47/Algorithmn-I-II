import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_14 {
    public static int lg(int N) {
        int i = 0;
        while (N > 1) {
            N = N / 2;
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int N = 16;
        StdOut.printf("The largest int not larger the base-2 logarithm of %d is %d.\n", N, lg(N));
    }
}
