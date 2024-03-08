import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_38_1 {
    public static class GeneralizedQueueLinkedList<Item> {

        private Node first;
        private Node last;
        private int size;

        private class Node {
            Item item;
            Node next;
        }

        public GeneralizedQueueLinkedList() {
            first = null;
            last = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // add an item at the end
        public void insert(Item x) {
            Node oldLast = last;
            last = new Node();
            last.item = x;
            if (isEmpty()) {
                first = last;
            } else {
                oldLast.next = last;
            }
            size++;
        }

        private Item removeFirst() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            Item item = first.item;
            first = first.next;
            if (first == null) {
                last = first = null;
            }
            size--;
            return item;
        }

        private Item removeLast() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            Item item = last.item;
            if (first == last) {
                first = last = null;
            } else {
                Node current = first;
                while (current.next != last) {
                    current = current.next;
                }
                current.next = null;
                last = current;
            }
            size--;
            return item;

        }

        private Item removeMiddle(int k) {
            Node previous = null;
            Node current = first;
            for (int i = 1; i < k; i++) {
                previous = current;
                current = current.next;
            } // current now is the kth node, and previous is the node before it

            if (previous != null) {
                previous.next = current.next; // skip the kth node
            }

            if (current == last) { // if the kth node is also the last node
                last = previous; // update the last node
            }

            size--;
            return current.item;
        }

        // delete and return the kth least recently inserted item
        public Item delete(int k) {
            if (isEmpty() || k <= 0 || k > size) {
                throw new NoSuchElementException();
            }

            if (k == 1) {
                return removeFirst(); // remove the first item (least recently)
            } else if (k == size) {
                return removeLast(); // remove the last item (most recently)
            } else {
                return removeMiddle(k); // remove any other kth inserted node
            }

        }

    }

    public static void main(String[] args) {
        GeneralizedQueueLinkedList<Integer> queue = new GeneralizedQueueLinkedList<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        StdOut.println("This generalized queue is implemented by linked list.");

        // delete the 1st least recently inserted
        StdOut.println("Deleted " + queue.delete(1)); // Expected: Deleted 1
        // Queue state should now be: [2, 3, 4, 5]

        // delete the 2nd least recently inserted
        StdOut.println("Deleted " + queue.delete(2)); // Expected: Deleted 3
        // Queue state should now be: [2, 4, 5]

        StdOut.println("Deleted " + queue.delete(1)); // Expected: Deleted 2
        // Queue state should now be: [4, 5]

        StdOut.println("Deleted " + queue.delete(1)); // Expected: Deleted 4
        // Queue state should now be: [5]

        StdOut.println("The queue now is " + (queue.isEmpty() ? "empty." : "non-empty."));

    }

}
