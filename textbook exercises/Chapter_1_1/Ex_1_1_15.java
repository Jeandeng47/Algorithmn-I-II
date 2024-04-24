public class Ex_1_1_15 {
    public static int[] historgram(int[] a, int M) {
        int[] result = new int[M];
        for (int i = 0; i < a.length; i++) {
            // ensure values are between 0 and M-1
            if (a[i] >= 0 && a[i] < M) {
                result[a[i]]++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int M = 5;
        int[] a = { 0, 1, 1, 2, 3, 3, 3, 4, 4, 4, 4 };
        int[] histogram = historgram(a, M);

        // Print the histogram array
        System.out.println("Histogram:");
        for (int i = 0; i < histogram.length; i++) {
            System.out.println(i + ": " + histogram[i]);
        }

        // Verify the sum of the histogram equals the length of the original array
        int sum = 0;
        for (int count : histogram) {
            sum += count;
        }
        System.out.println("Sum of histogram counts: " + sum);
        System.out.println("Original array length: " + a.length);
    }
}
