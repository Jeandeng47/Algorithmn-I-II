
public class Ex_1_1_03 {
    public static void main(String[] args) {
        // check length of args
        if (args.length < 3) {
            System.out.println("Usage: java Ex_1_1_03 <int1> <int2> <int3>");
            return;
        }

        try {
            // convert string to int
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            int num3 = Integer.parseInt(args[2]);

            if (num1 == num2 && num2 == num3) {
                System.out.println("Equal.");
            } else {
                System.out.println("Not equal.");
            }

        } catch (NumberFormatException e) {
            System.out.println("The arguments are not valid.");
        }
    }
}
