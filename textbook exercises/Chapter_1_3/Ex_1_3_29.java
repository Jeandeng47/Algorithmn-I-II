import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_29 {
    public static class CirculaQueue<Item> implements Iterable<Item> {
        private Node last;
        private int N;

        private class Node {
            Item item;
            Node next;

            // method to create a new node
            Node(Item item) {
                this.item = item;
                this.next = null;
            }
        }

        // create an empty queue
        public CirculaQueue() {
            this.last = null;
            this.N = 0;
        }

        public int size() {
            return N;
        }

        public boolean isEmpty() {
            return last == null;
        }

        // enqueue at the end of the queue
        public void enqueue(Item item) {

            Node newNode = new Node(item);

            // if list is empty
            if (isEmpty()) {
                newNode.next = newNode;// point to itself
                last = newNode;
            } else {
                newNode.next = last.next; // let new node's next points to first
                last.next = newNode; // now oldlast's next pointsto new node
                last = newNode; // update new node to be the last
            }
            N++;
        }

        // dequeue from the beginning of the queue
        public Item dequeue() {
            // if list is empty
            if (isEmpty()) {
                throw new NoSuchElementException("Queue unferflow");
            }

            // if list has only one element
            if (last.next == last) {
                Item item = last.next.item;
                last = null;
                N--;
                return item;
            }

            // first is pointed by last.next
            Item item = last.next.item;
            last.next = last.next.next; // skip the first node
            N--;
            return item;
        }

        @Override
        public Iterator<Item> iterator() {
            return new QueueIterator();
        }

        private class QueueIterator implements Iterator<Item> {
            private int size = N;
            private Node current = (isEmpty()) ? null : last.next; // if not empty, start from first node

            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item item = current.item;
                current = current.next;
                size--;
                return item;
            }

        }

    }

    public static void main(String[] args) {
        CirculaQueue<Integer> queue = new CirculaQueue<>();

        for (int i = 0; i <= 5; i++) {
            queue.enqueue(i); // should output: 0 1 2 3 4 5
        }

        StdOut.println("The queue after enqueue: ");
        for (Integer item : queue) {
            StdOut.print(item + " ");
        }
        StdOut.println();

        queue.dequeue();
        queue.dequeue();

        StdOut.println("The queue after dequeue: ");
        for (Integer item : queue) {
            StdOut.print(item + " "); // should output: 2 3 4 5
        }
    }
}
