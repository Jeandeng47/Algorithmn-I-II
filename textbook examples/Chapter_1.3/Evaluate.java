
/**
 * Evaluate.java -- This class implements the Dijstra's two-stack
 * Algorithmn for expression Evaluation.
 */

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
    public static void main(String[] args) {
        // one stack for operators
        Stack<String> ops = new Stack<String>();
        // one stack for value
        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            // possibility 1: if input is operator, put into ops
            String s = StdIn.readString();
            // if it is left (, ignore
            if (s.equals("("))
                ;
            else if (s.equals("+"))
                ops.push(s);
            else if (s.equals("-"))
                ops.push(s);
            else if (s.equals("*"))
                ops.push(s);
            else if (s.equals("/"))
                ops.push(s);
            else if (s.equals("sqrt"))
                ops.push(s);
            else if (s.equals(")")) {
                // if it is right ), pop and evaluate
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+"))
                    v = vals.pop() + v;
                else if (op.equals("-"))
                    v = vals.pop() - v;
                else if (op.equals("*"))
                    v = vals.pop() * v;
                else if (op.equals("/"))
                    v = vals.pop() / v;
                else if (op.equals("sqrt"))
                    v = Math.sqrt(v);
                // push back value to stack
                vals.push(v);
            } else {
                // possibility 2: if input is operand, push double value
                vals.push(Double.parseDouble(s));
            }

        }
        // print out the final result
        StdOut.println(vals.pop());

    }

}
