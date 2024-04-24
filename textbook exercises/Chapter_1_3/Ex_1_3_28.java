import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_28 {
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

    // recursive version
    public static int maxRecursive(LinkedList<Integer>.Node node) {

        // define a base case
        if (node == null) {
            return 0; // return 0 if list is empty
        }

        // defien recursive case
        int max = maxRecursive(node.next);

        return Math.max(node.item, max);
    }

    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();

        // assume all the keys are positive
        for (int i = 10; i > 0; i--) {
            llist.insertFront(i);
        }

        StdOut.println("The original list is: ");
        for (Integer num : llist) {
            StdOut.print(num + " ");
        }
        StdOut.println();

        int max = maxRecursive(llist.first);
        StdOut.println("The maximum integer in the list is: " + max);

    }
}
