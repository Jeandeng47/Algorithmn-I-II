import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_42 {
    public static class Stack<Item> implements Iterable<Item> {
        private Node first; // head of queue
        private int size; // number of elements on queue

        private class Node {
            private Item item;
            private Node next;
        }

        public Stack() {
            first = null;
            size = 0;
        }

        // Initializes a new queue that is a copy of the given queue.
        public Stack(Stack<Item> s) {
            if (s == null || s.isEmpty()) {
                return;
            }

            Stack<Item> temp = new Stack<>();

            for (Item item : s) {
                temp.push(item);
            }

            for (Item item : temp) {
                push(temp.pop());
            }

        }

        // Checks if this queue is empty.
        public boolean isEmpty() {
            return first == null;
        }

        // Returns the number of items.
        public int size() {
            return size;
        }

        // Adds an item to this stack (insert at the front)
        public void push(Item item) {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            size++;
        }

        public Item pop() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            Item item = first.item;
            first = first.next;
            size--;
            return item;

        }

        @Override
        public Iterator<Item> iterator() {
            return new ListIterator();
        }

        private class ListIterator implements Iterator<Item> {
            private Node current = first;

            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }

        }

    }

    private static void printStack(Stack<Integer> s) {
        for (int num : s) {
            StdOut.print(num + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        Stack<Integer> original = new Stack<>();

        for (int i = 10; i > 0; i--) {
            original.push(i);
        }
        StdOut.println("The original stack: ");
        printStack(original);

        // create an independent copy
        Stack<Integer> copy = new Stack<>(original);
        StdOut.println("The copy stack: ");
        printStack(copy);

        // show changes in copy does not affect original
        copy.pop();
        copy.push(0);
        StdOut.println("The copy stack after operations on copy: ");
        printStack(copy);

        StdOut.println("The original stack after operations on copy: ");
        printStack(original);

    }
}
