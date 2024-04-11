import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_13 {

    public static void main(String[] args) {
        int M = 3;
        int N = 3;

        // initialize the matrix
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // print the original matrix
        StdOut.println("The original matrix:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                StdOut.printf("%2d", matrix[i][j]);
            }
            StdOut.println();
        }

        // transpose the matrix
        int[][] transposedMatrix = new int[N][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        // print the transponsed matrix
        StdOut.println("The original matrix:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                StdOut.printf("%2d", transposedMatrix[i][j]);
            }
            StdOut.println();
        }

    }
}
