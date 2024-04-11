public class Ex_1_1_05 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage java Ex_1_1_05 <doublex> <doubley>");
            return;
        }

        try {
            double x = Double.parseDouble(args[0]);
            double y = Double.parseDouble(args[1]);

            boolean areBothBetweenZeroAndOne = (x > 0.0 && x < 1.0) && (y > 0.0 && y < 1.0);

            System.out.println(areBothBetweenZeroAndOne);

        } catch (NumberFormatException e) {
            System.out.println("The arguments are not valid.");
        }
    }
}