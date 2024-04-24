import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_41 {
    public static class Queue<Item> implements Iterable<Item> {
        private Node first; // beginning of queue
        private Node last; // end of queue
        private int size; // number of elements on queue

        private class Node {
            private Item item;
            private Node next;
        }

        // Checks if this queue is empty.
        public boolean isEmpty() {
            return first == null;
        }

        // Returns the number of items in this queue.
        public int size() {
            return size;
        }

        // Initializes an empty queue.
        public Queue() {
            first = null;
            last = null;
            size = 0;
        }

        // Initializes a new queue that is a copy of the given queue.
        public Queue(Queue<Item> q) {

            if (q == null || q.isEmpty()) {
                return; 
            }

            for (Item item : q) {
                enqueue(item);
            }

        }

        public void enqueue(Item item) {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (isEmpty()) {
                first = last;
            } else {
                oldLast.next = last;
            }
            size++;
        }

        public Item dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            Item item = first.item;
            first = first.next;
            size--;
            if (isEmpty()) {
                last = null;
            }
            return item;
        }

        @Override
        public Iterator<Item> iterator() {
            return new QueueIterator();
        }

        private class QueueIterator implements Iterator<Item> {
            Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item item = current.item;
                current = current.next;
                return item;
            }

        }
    }

    private static void printQueue(Queue<Integer> q) {
        for (int num : q) {
            StdOut.print(num + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        Queue<Integer> original = new Queue<>();

        for (int i = 1; i <= 10; i++) {
            original.enqueue(i);
        }
        StdOut.println("The original queue: ");
        printQueue(original);

        // create an independent copy
        Queue<Integer> copy = new Queue<>(original);
        StdOut.println("The copy queue: ");
        printQueue(copy);

        // show changes in copy does not affect original
        copy.dequeue();
        copy.enqueue(11);
        StdOut.println("The copy queue after operations on copy: ");
        printQueue(copy);

        StdOut.println("The original queue after operations on copy: ");
        printQueue(original);

    }
}
