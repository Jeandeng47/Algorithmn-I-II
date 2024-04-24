import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_30 {
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

        // reverse the list (destructively) by iteration
        public Node reverseIterative(Node firstNode) {
            Node first = firstNode;
            Node reverse = null;
            while (first != null) {
                // move first node into new list
                Node second = first.next; // Move second to the next node in the list
                first.next = reverse; // Point first's next to the reversed list

                // inside new list
                reverse = first; // Move reverse to point to first, effectively adding it to the start of the
                                 // reversed list

                // inside old list
                first = second; // Move first to second, progressing through the original list
            }
            return reverse; // reverse now points to the new head of the reversed list
        }

        // reverse the list (destructively) by recursion
        public Node reverseRecursive(Node first) {

            // special cases: empty list or list with one node
            if (first == null || first.next == null) {
                return first;
            }

            // define recursive case
            Node second = first.next;
            Node restReversed = reverseRecursive(second); // reverse the rest of the list
            second.next = first; // make original second point back to the first node
            first.next = null; // mark the end of the reversed list
            return restReversed;

        }

    }

    private static void printList(LinkedList<Integer> llist) {
        for (Integer num : llist) {
            StdOut.printf(num + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();

        for (int i = 10; i > 0; i--) {
            llist.insertFront(i);
        }

        StdOut.println("Linked list before reversion: ");
        printList(llist);
        // ouput: 1 2 3 4 5 6 7 8 9 10

        llist.first = llist.reverseIterative(llist.first);
        StdOut.println("Linked list after iterative reversion: ");
        printList(llist); // ouput: 10 9 8 7 6 5 4 3 2 1

        llist.first = llist.reverseRecursive(llist.first);
        StdOut.println("Linked list after recursive reversion: ");
        printList(llist); // ouput: 1 2 3 4 5 6 7 8 9 10

    }
}
