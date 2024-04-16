import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_21 {
    public static void main(String[] args) {

        StdOut.println("Enter data (name and two integers per line). Enter an empty line to stop.");
        StdOut.printf("%-20s %10s %10s %10s\n", "Name", "Int1", "Int2", "Result");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // check whethe it's empty line
            if (line.isEmpty()) {
                break;
            }
            // spilt the line into parts
            String[] parts = line.split("\\s+");
            if (parts.length < 3) {
                StdOut.println("Invalid input format. Please enter a name followed by two integers.");
                continue;
            }
            try {
                String name = parts[0];
                int num1 = Integer.parseInt(parts[1]);
                int num2 = Integer.parseInt(parts[2]);
                double result = num1 / num2;

                StdOut.printf("%-20s %10s %10s %10s\n", name, num1, num2, result);
            } catch (NumberFormatException e) {
                StdOut.println("Please enter valid integers after the name.");
            } catch (ArithmeticException e) {
                StdOut.println("Division by zero encountered. Please enter a non-zero second integer.");
            }

        }
        scanner.close();
        StdOut.println("Processing complete.");
    }
}