import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex_1_1_36 {
    public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + StdRandom.uniformInt(N - i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            StdOut.println("Usage: java Ex_1_1_36 <intM> <intN>");
        }

        int M = Integer.parseInt(args[0]); // size of the array
        int N = Integer.parseInt(args[1]); // number of experiments
        int[][] positionCount = new int[M][M]; // M by M table
        int[] a = new int[M]; // array of size N

        for (int t = 0; t < N; t++) {
            // initialize array a
            for (int i = 0; i < M; i++) {
                a[i] = i;
            }

            shuffle(a);

            // record the position
            for (int i = 0; i < M; i++) {
                positionCount[a[i]][i]++;
            }
        }

        // Print the table
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                StdOut.printf("%5d ", positionCount[i][j]);
            }
            StdOut.println();
        }

    }
}
