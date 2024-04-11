public class Ex_1_1_02 {
    public static void main(String[] args) {
        double a = (1 + 2.236) / 2;
        double b = 1 + 2 + 3 + 4.0;
        boolean c = 4.1 >= 4;
        String d = 1 + 2 + "3";

        System.out.println("The value of expression a : " + a
                + "\nThe type of expression a: " + ((Object) a).getClass().getName());
        System.out.println("The value of expression b : " + b
                + "\nThe type of expression b: " + ((Object) b).getClass().getName());
        System.out.println("The value of expression c: " + c
                + "\nThe type of expression c: " + ((Object) c).getClass().getName());
        System.out.println("The value of expression d: " + d
                + "\nThe type of expression d: " + ((Object) d).getClass().getName());
    }
}
