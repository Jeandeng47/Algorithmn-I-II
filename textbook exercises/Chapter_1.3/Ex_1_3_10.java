import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;


public class Ex_1_3_10 {
    public static String infixToPostfix(String infixExpression) {

        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);

            if (Character.isLetterOrDigit(c)) { // handle values: appear in same order in infix / postfix

                postfix.append(c);

            } else if (c == '(') { // handle left: start of sub-expression, override precedence

                stack.push(c);

            } else if (c == ')') { // handle right: pop values until left is met

                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // pop the left parenthesis

            } else if (isOperator(c)) { // handle operator: higher precedence push before lower precedence

                while (!stack.isEmpty()
                        && precedence(c) < precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all remaining operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char operator) {
        // higer precedence, higher value
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1; // invalid operator
        }
    }

    private static boolean isOperator(char c) {
        return precedence(c) > 0; // check if operator is valid
    }

    public static void main(String[] args) {
        String infixString = "A*(B+C)-D/(E+F)";
        StdOut.println("Infix expression: " + infixString);
        StdOut.println("Postfix expression: " + infixToPostfix(infixString));
        // output should be: ABC+*DEF+/-

    }
}
