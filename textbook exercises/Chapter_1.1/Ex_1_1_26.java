public class Ex_1_1_26 {
    // Method to sort three numbers using the provided logic
    public static void sortThreeNumbers() {
        int a = 9;
        int b = 3;
        int c = 6;
        int t;

        System.out.println("Original values: a = " + a + ", b = " + b + ", c = " + c);

        // Sorting logic
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            t = b;
            b = c;
            c = t;
        }

        // Print sorted values
        System.out.println("Sorted values: a = " + a + ", b = " + b + ", c = " + c);
    }

    public static void main(String[] args) {
        sortThreeNumbers();
    }
}
