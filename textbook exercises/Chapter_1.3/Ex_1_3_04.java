import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class Ex_1_3_04 {

    public static boolean isParenthesesBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char p = input.charAt(i);
            if (p == '{' || p == '[' || p == '(') {
                stack.push(p);
            } else if (p == '}' || p == ']' || p == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop(); // get the opening parenthese at top
                if (!isParenthesesMatch(last, p)) {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }

    private static boolean isParenthesesMatch(char opening, char closing) {
        return (opening == '{' && closing == '}' || opening == '[' && closing == ']'
                || opening == '(' && closing == ')');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StdOut.println("Enter parentheses string: ");
        String input = scanner.nextLine();
        scanner.close();

        boolean balanced = isParenthesesBalanced(input);
        System.out.println("Is the input string balanced? " + balanced);
    }

}
