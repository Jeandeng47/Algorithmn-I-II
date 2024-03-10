import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_49 {
    public static class QueueWithThreeStacks<Item> {
        private Stack<Item> input;
        private Stack<Item> output;
        // private Stack<Item> temp; no need to have a third stack

        // constructor
        public QueueWithThreeStacks() {
            input = new Stack<>();
            output = new Stack<>();
        }

        // push to the input stack
        public void enqueue(Item item) {
            input.push(item); // 1 2 3 4

        }

        // pop from the output stack
        public Item dequeue() {
            if (output.isEmpty()) {
                // Transfer from input to temp, reversing order
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.isEmpty() ? null : output.pop();

        }

        public int size() {
            return input.size() + output.size();
        }
    }

    public static void main(String[] args) {
        QueueWithThreeStacks<Integer> queue = new QueueWithThreeStacks<>();

        // put into input stack: 1 2 3
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        StdOut.println(queue.dequeue()); // Expected: 1
        queue.enqueue(4);

        StdOut.println(queue.dequeue()); // Expected: 2
        StdOut.println(queue.dequeue()); // Expected: 3
        StdOut.println(queue.dequeue()); // Expected: 4

    }
}
