import java.util.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_09 {
    public static String insertParentheses(String input) {
        Stack<String> values = new Stack<>();
        Stack<String> operators = new Stack<>();

        String[] tokens = input.split("\\s+");
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")
                    || token.equals("sqrt")) {
                // if token is operator (other than ")")
                operators.push(token);
            } else if (token.equals(")")) {
                // if token is right parenthesis
                String value1 = values.pop();
                String value2 = values.pop();
                String operator = operators.pop();
                // value2 should come before value1
                String subExpression = "(" + value2 + operator + value1 + ")";
                values.push(subExpression);
            } else {
                // if token is a value
                values.push(token);
            }
        }
        // final expression in the value stack
        return values.pop();
    }

    public static void main(String[] args) {
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        StdOut.println(insertParentheses(input));
    }
}
