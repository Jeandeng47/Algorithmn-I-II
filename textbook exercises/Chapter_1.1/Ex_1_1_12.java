public class Ex_1_1_12 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        // a[0] = 9, a[1] = 8, ... a[9] = 0;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        // a[0] = a[9] = 0, a[1] = a[8] = 1, ... 
        for (int i = 0; i < 10; i++)
            System.out.println(i);
    }
}
