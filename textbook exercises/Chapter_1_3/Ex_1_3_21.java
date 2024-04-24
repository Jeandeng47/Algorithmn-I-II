import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_21 {
    public static class LinkedList<Item> implements Iterable<Item> {
        private Node first;
        private int N;

        private class Node {
            Item item;
            Node next;
        }

        public int size() {
            return N;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public void print() {
            for (Node x = first; x != null; x = x.next) {
                StdOut.printf(x.item.toString() + " ");
            }
            StdOut.println();
        }

        public void insertFront(Item item) {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            N++;

        }

        public Item remove(Item item) {
            if (isEmpty()) {
                return null;
            }

            if (first.item.equals(item)) {
                Item itemToRemove = first.item;
                first = first.next;
                N--;
                return itemToRemove;
            }

            Node x = first;
            while (x.next != null) {
                if (x.next.item.equals(item)) {
                    Item itemToRemove = x.next.item;
                    x.next = x.next.next;
                    N--;
                    return itemToRemove;
                }
            }

            return null;
        }

        @Override
        public Iterator<Item> iterator() {
            return new LinkedListIterator();
        }

        private class LinkedListIterator implements Iterator<Item> {
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

    public static boolean find(LinkedList<Integer> llist, Integer key) {
        for (Integer item : llist) {
            if (item.equals(key)) {
                return true;
            }
        }
        return false; // key no found
    }

    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            llist.insertFront(i);
        }
        llist.print(); // output: 5 4 3 2 1

        boolean found = find(llist, 2);
        System.out.println("Found 2: " + found); // Expected: true

        found = find(llist, 10);
        System.out.println("Found 10: " + found); // Expected: false

    }
}
