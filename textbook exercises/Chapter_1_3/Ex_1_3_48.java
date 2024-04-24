import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_48 {
    public static class TwoStacksWithDeque<Item> {
        private Deque<Item> deque = new ArrayDeque<>();

        // define stack 1 operations
        public void pushStack1(Item item) {
            deque.addFirst(item);
        }

        public Item popStack1() {
            if (deque.isEmpty()) {
                throw new NoSuchElementException();
            }
            return deque.removeFirst();
        }

        // define stack 2 operations
        public void pushStack2(Item item) {
            deque.addLast(item);
        }

        public Item popStack2() {
            if (deque.isEmpty()) {
                throw new NoSuchElementException();
            }
            return deque.removeLast();

        }
    }

    public static void main(String[] args) {
        TwoStacksWithDeque<Integer> stacks = new TwoStacksWithDeque<>();

        // Push to Stack 1
        stacks.pushStack1(1);
        stacks.pushStack1(2);

        // Push to Stack 2
        stacks.pushStack2(3);
        stacks.pushStack2(4);

        // deque: 2 1 3 4

        // Pop from Stack 1 and Stack 2
        StdOut.println("Pop from Stack 1: " + stacks.popStack1()); // Expects 2
        StdOut.println("Pop from Stack 2: " + stacks.popStack2()); // Expects 4
    }
}
