import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_11 {
    public static void main(String[] args) {
        int M = 10;
        int N = 10;
        boolean[][] array = new boolean[M][N];

        // initialized the boolean array
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (j % 2 == 0) {
                    array[i][j] = true;
                } else {
                    array[i][j] = false;
                }
            }
        }

        // print the array
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (array[i][j] == true) {
                    StdOut.printf("* ");
                } else {
                    StdOut.printf("- ");
                }
            }
            StdOut.println();
        }

    }
}
