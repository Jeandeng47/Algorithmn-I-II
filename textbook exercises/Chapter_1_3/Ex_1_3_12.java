import java.util.Iterator;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_12 {
    // define iterable stack class
    public static class IterableStack<String> extends Stack<String> {

        @Override
        public Iterator<String> iterator() {
            return super.iterator();
        }
    }

    // method to copy a stack of string
    public static IterableStack<String> copy(IterableStack<String> original) {
        if (original == null) {
            throw new IllegalArgumentException("The stack is empty");
        }

        // create temporary stack to store reversed elements
        IterableStack<String> temp = new IterableStack<>();
        for (String item : original) {
            temp.push(item);
        }
        StdOut.print("The temporary stack: ");
        printStack(temp);

        // use pop() to reverse elements to original order
        IterableStack<String> copy = new IterableStack<>();
        for (String item : temp) {
            copy.push(item);
        }

        return copy;

    }

    // helper method to observe order
    private static void printStack(IterableStack<String> stack) {
        for (String item : stack) {
            StdOut.print(item + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        IterableStack<String> stack = new IterableStack<>();
        for (int i = 0; i <= 5; i++) {
            stack.push(Integer.toString(i + 97));
        }
        StdOut.print("The original stack: ");
        printStack(stack);

        IterableStack<String> copy = copy(stack);
        StdOut.print("The copied stack: ");
        printStack(copy);

    }

}
