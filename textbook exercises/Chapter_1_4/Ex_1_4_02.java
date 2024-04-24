import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_4_02 {
    // Count triples that sum to 0, avoiding overflow
    public static int count(int[] a) {
        int N = a.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    BigInteger sum = BigInteger.valueOf(0);
                    sum = sum.add(BigInteger.valueOf(a[i]));
                    sum = sum.add(BigInteger.valueOf(a[j]));
                    sum = sum.add(BigInteger.valueOf(a[k]));
                    if (sum == BigInteger.valueOf(0)) {
                        StdOut.printf("%d %d %d\n", a[i], a[j], a[k]);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // .txt files under same directory
        String[] filePaths = { "1Kints.txt", "2Kints.txt", "4Kints.txt", "8Kints.txt" };

        try {
            for (String filePath : filePaths) {
                File file = new File(filePath);
                Scanner scanner = new Scanner(file);
                int[] nums = scanner.tokens().mapToInt(Integer::parseInt).toArray();
                StdOut.println("In file " + filePath);
                StdOut.println("Count of triples that sum to 0: " + count(nums));
                scanner.close();
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}