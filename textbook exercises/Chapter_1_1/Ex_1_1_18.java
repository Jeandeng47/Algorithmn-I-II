import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_18 {
    public static int mystery(int a, int b) {
        // base case: any number multiplies by 0 is 0
        if (b == 0) 
            return 0;
        // even case: if b is even, call itself (a doubled, b halved)
        // a * 2b = 2a * b
        if (b % 2 == 0)
         
            return mystery(a + a, b / 2);
        // odd case: if b is odd, call itself (a doubled, b halved, add a)
        // a * b = a * (b - 1) + a
        return mystery(a + a, b / 2) + a;
    }

    public static int mysteryMul(int a, int b) {
        // base case: any number to the power of 0 is 1
        if (b == 0)
            return 1;
        // even case: if b is even, call itself (a squared, b halved)
        // a^b = (a^2)^(b/2)
        if (b % 2 == 0)
            return mystery(a * a, b / 2);
        // odd case: if b is odd, call itself (a squared, b b halved, multiplies a)
        // a^b = a*a^(b-1)
        return mystery(a * a, b / 2) * a;
    }

    public static void main(String[] args) {
        int result1 = mystery(2, 25);
        int result2 = mystery(3, 11);
        StdOut.printf("The result of mystery(2, 25) is %d\n", result1);
        StdOut.printf("The result of mystery(3, 11) is %d\n", result2);

        int result3 = mysteryMul(2, 3);
        int result4 = mysteryMul(5, 2);
        StdOut.printf("The result of mysteryMul(2, 3) is %d\n", result3);
        StdOut.printf("The result of mysteryMul(5, 2) is %d\n", result4);
    }
}
