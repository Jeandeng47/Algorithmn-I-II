public class Ex_1_1_16 {

    public static String exR1(int n) {
        if (n <= 0)
            return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.printf("The exR1 value of %d is %s\n", n, exR1(n));
    }
}