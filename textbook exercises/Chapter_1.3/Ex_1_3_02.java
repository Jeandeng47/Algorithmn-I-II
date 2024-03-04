import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_02 {
    public static void main(String[] agrs) {
        Stack<String> stack = new Stack<>();
        String[] str = "it was - the best - of times - - - it was - the - -".split("\\s+");

        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("-")) {
                StdOut.println(stack.pop());
            } else {
                stack.push(str[i]);
            }
        }
    }
}
