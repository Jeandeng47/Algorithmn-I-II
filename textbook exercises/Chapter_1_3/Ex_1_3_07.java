import java.util.EmptyStackException;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_07 {
     // inner class to define node in stack
    private static class StackNode<T> {
        private T data; // data in the node
        private StackNode<T> next; // next node

        public StackNode(T data) {
            this.data = data;
        }
    }

    // inner class to define my stack
    public static class MyStack<T> {
        private StackNode<T> top;

        // similar to insert front
        public void push(T item) {
            StackNode<T> current = new StackNode<>(item);
            current.next = top;
            top = current;
        }

        // similar to remove front
        public T pop() {
            if (top == null) {
                throw new EmptyStackException();
            }
            T item = top.data;
            top = top.next;
            return item;
        }

        public T peek() {
            if (top == null) {
                throw new EmptyStackException();
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        StdOut.println("Push elements onto the stack:");
        for (int i = 0; i <= 10; i++) {
            StdOut.println("Pushing " + i);
            stack.push(i);
        }
        StdOut.println("Peeking the top element of the stack: " + stack.peek());
    }
}
