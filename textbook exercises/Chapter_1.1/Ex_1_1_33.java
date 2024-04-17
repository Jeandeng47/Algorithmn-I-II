public class Ex_1_1_33 {
    // vector dot product
    public static double dot(double[] x, double[] y) {
        // the two vectors must have equal length
        if (x.length != y.length) {
            throw new IllegalArgumentException("Vector lengths do not match.");
        }
        // A = [a1, a2, ..., an], B = [b1, b2, ..., bn]
        // A * B = a1 * b1 + a2 * b2 + ... + an * bn
        double dotProduct = 0.0;
        for (int i = 0; i < x.length; i++) {
            dotProduct += x[i] * y[i];
        }
        return dotProduct;
    }

    // transpose
    public static double[][] transpose(double[][] a) {
        int numOfRows = a[0].length;
        int numOfCols = a.length;
        double[][] transposedMatrix = new double[numOfRows][numOfCols];
        for (int i = 0; i < numOfCols; i++) {
            for (int j = 0; j < numOfRows; j++) {
                transposedMatrix[j][i] = a[i][j];
            }
        }
        return transposedMatrix;
    }

    // matrix-matrix product
    public static double[][] mult(double[][] a, double[][] b) {
        // matrix product: dot product of i-th row of matrix A (m * n matrix) and
        // j-column of matrix B (n * p matrix)

        // check if col(A) equals to row(B)

        int colsA = a[0].length;
        int rowsA = a.length;
        int colsB = b[0].length;
        int rowsB = b.length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix dimensions do not allow multiplication.");
        }

        double[][] multResult = new double[rowsA][colsB];

        // tranpose column of matrix B
        double[][] transposedB = transpose(b);
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                multResult[i][j] = dot(a[i], transposedB[j]);
            }
        }
        return multResult;

    }

    // matrix-vetor product
    public static double[] mult(double[][] a, double[] x) {
        // matrix-vector product: dot product of i-th row of A and vector x
        int rowsA = a[0].length;
        int colsA = a.length;
        if (rowsA != x.length) {
            throw new IllegalArgumentException("Matrix and vector dimensions do not allow multiplication.");
        }
        double[] multResult = new double[colsA];
        for (int i = 0; i < colsA; i++) {
            multResult[i] = dot(a[i], x);
        }
        return multResult;

    }

    // vector-matrix product
    public static double[] mult(double[] y, double[][] a) {
        // matrix-vector product: dot product of the i-th row of tranposed A and vector
        // x
        int colsA = a.length;
        if (y.length != colsA) {
            throw new IllegalArgumentException("Matrix and vector dimensions do not allow multiplication.");
        }
        double[][] tranpsosedA = transpose(a);
        double[] multResult = new double[tranpsosedA.length];
        for (int i = 0; i < tranpsosedA.length; i++) {
            multResult[i] = dot(y, tranpsosedA[i]);
        }
        return multResult;

    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(double[] array) {
        for (double val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        double[] vectorX = { 1, 2, 3 };
        double[] vectorY = { 4, 5, 6 };
        double[][] matrixA = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        double[][] matrixB = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };

        System.out.println("Dot product of vectorX and vectorY: " + dot(vectorX, vectorY));

        System.out.println("Matrix-matrix product of matrixA and matrixB:");
        printMatrix(mult(matrixA, matrixB));

        System.out.println("Transpose of matrixA:");
        printMatrix(transpose(matrixA));

        System.out.println("Matrix-vector product of matrixA and vectorX:");
        printArray(mult(matrixA, vectorX));

        System.out.println("Vector-matrix product of vectorY and matrixA:");
        printArray(mult(vectorY, matrixA));
    }
}
