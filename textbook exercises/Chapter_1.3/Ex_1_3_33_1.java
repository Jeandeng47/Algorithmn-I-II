import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_33_1 {

    public static class Deque<Item> implements Iterable<Item> {
        private Node first;
        private Node last;
        private int size;

        private class Node {
            Item item;
            Node next;
            Node prev;
        }

        // create an empty deque
        public Deque() {
            first = null;
            last = null;
            size = 0;
        }

        // is the deque empty?
        public boolean isEmpty() {
            return size == 0;
        }

        // number of items in the deque
        public int size() {
            return size;
        }

        // add an item to the left end
        public void pushLeft(Item item) {
            Node newNode = new Node();
            newNode.item = item;
            if (isEmpty()) {
                last = first = newNode;
            } else {
                newNode.next = first;
                first.prev = newNode;
                first = newNode;
            }
            size++;
        }

        // add an item to the right end
        public void pushRight(Item item) {
            Node newNode = new Node();
            newNode.item = item;
            if (isEmpty()) {
                last = first = newNode;
            } else {
                newNode.prev = last;
                last.next = newNode;
                last = newNode;
            }
            size++;
        }

        // remove an item from the left end
        public Item popLeft() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            Item item = first.item;
            first = first.next;

            if (first == null) {
                last = null;
            } else {
                first.prev = null;
            }
            size--;
            return item;

        }

        // remove an item from the right end
        public Item popRight() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            Item item = last.item;
            last = last.prev;

            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
            size--;
            return item;
        }

        @Override
        public Iterator<Item> iterator() {
            return new Iterator<Item>() {
                private Node current = first;

                @Override
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

            };
        }

    }

    private static void printDeque(Deque<Integer> deque) {
        for (int num : deque) {
            StdOut.print(num + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        for (int i = 5; i > 0; i--) {
            deque.pushLeft(i);
        }
        StdOut.println("Deque after push left: ");
        printDeque(deque); // output: 1 2 3 4 5

        for (int i = 6; i <= 10; i++) {
            deque.pushRight(i);
        }
        StdOut.println("Deque after push right: ");
        printDeque(deque); // output: 1 2 3 4 5 6 7 8 9 10

        deque.popLeft();
        StdOut.println("Deque after pop left: ");
        printDeque(deque); // output: 2 3 4 5 6 7 8 9 10

        deque.popRight();
        StdOut.println("Deque after pop right: ");
        printDeque(deque); // output: 2 3 4 5 6 7 8 9
    }

}
