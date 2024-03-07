import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_32 {
    public static class Steque<Item> implements Iterable<Item> {
        private Node first; // head of steque
        private Node last; // tail of steque
        private int size;

        private class Node {
            Item item;
            Node next;
        }

        // construct an empty stack
        public Steque() {
            first = null;
            last = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        // insert an item at the front
        public void push(Item item) {

            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;

            if (isEmpty()) {
                last = first;
            }
            size++;

        }

        // remove and return an item from the front
        public Item pop() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            Item item = first.item;
            first = first.next;

            if (isEmpty()) {
                last = null;
            }
            size--;
            return item;

        }

        // add an item to the end
        public void enqueue(Item item) {
            Node oldLast = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (isEmpty()) {
                first = last;
            }
            oldLast.next = last;
            size++;
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

    private static void printSteque(Steque<Integer> steque) {
        for (int item : steque) {
            StdOut.print(item + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {

        Steque<Integer> steque = new Steque<>();

        for (int i = 5; i > 0; i--) {
            steque.push(i);
        }
        printSteque(steque); // output: 1 2 3 4 5

        StdOut.println("Steque after enqueue at the end: ");
        steque.enqueue(6);
        steque.enqueue(7);
        printSteque(steque); // output: 1 2 3 4 5 6 7

        StdOut.println("Steque after push: ");
        steque.push(0);
        printSteque(steque); // output: 0 1 2 3 4 5 6 7

        StdOut.println("Steque after pop: ");
        steque.pop();
        printSteque(steque); // output: 0 1 2 3 4 5 6

    }
}
