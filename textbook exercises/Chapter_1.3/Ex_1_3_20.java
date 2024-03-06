import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_20 {
    public static class LinkedList<Item> {
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

            // speical case: remove first node
            if (first.item.equals(item)) {
                Item itemToRemove = first.item;
                first = first.next;
                N--;
                return itemToRemove;
            }

            Node x = first;
            while (x.next != null) {
                if (x.item.equals(item)) {
                    Item itemToRemove = x.item;
                    x.next = x.next.next;
                    N--;
                    return itemToRemove;
                }
                x = x.next;
            }
            return null;

        }

        public Item removeLast() {
            if (isEmpty()) {
                return null;
            }

            // special case: only one node
            if (size() == 1) {
                Item itemToRemove = first.item;
                first = null;
                N--;
                return itemToRemove;
            }

            Node secondLast = first;
            while (secondLast.next.next != null) {
                secondLast = secondLast.next;
            }

            Item itemToRemove = secondLast.next.item;
            secondLast.next = null;
            N--;
            return itemToRemove;

        }

        public Item delete(int k) {
            // check if k is valid
            if (k < 0 || k >= size()) {
                return null;
            }

            // delete the first node
            if (k == 0) {
                Item itemToRemove = first.item;
                first = first.next;
                N--;
                return itemToRemove;
            }

            Node x = first; 
            for (int i = 0; i < k - 1; i++) {
                x = x.next;
            }
            Item itemToRemove = x.next.item;
            x.next = x.next.next;
            N--;
            return itemToRemove;
        }

    }

    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            llist.insertFront(i);
        }
        StdOut.println("The original linked list...");
        llist.print(); // output: 5 4 3 2 1

        // remove item at specific index
        Integer removedItem = llist.delete(3); // Should aim to remove '2'
        StdOut.println("Removed item: " + removedItem);
        llist.print(); // Expected output: 5 4 3 1

    }
}
