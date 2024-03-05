import java.util.Stack;
import java.lang.IllegalArgumentException;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_11 {

    public static void evaluatePostfix(String postfix) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            String token = Character.toString(postfix.charAt(i));
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // note the order of value1 and value2
                double value2 = Double.parseDouble(stack.pop());
                double value1 = Double.parseDouble(stack.pop());
                double result = evaluate(value1, value2, token);
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }
        }
        String resultString = stack.pop();
        double result = Double.parseDouble(resultString);
        StdOut.printf("The final result is %.2f.\n", result);
    }

    // helper method to do arithmetic
    private static double evaluate(double val1, double val2, String operator) {
        switch (operator) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":
                if (val2 == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero.");
                return val1 / val2;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String postfix = "234+*567+/";
        evaluatePostfix(postfix);
        // output: 2*(3+4)-5/(6+7) = 0.38
    }
}
