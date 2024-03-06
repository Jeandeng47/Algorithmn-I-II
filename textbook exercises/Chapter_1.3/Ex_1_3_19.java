import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_19 {
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
            Node oldFirst = first; // store old first node
            first = new Node(); // make new node the first
            first.item = item;
            first.next = oldFirst; // connect old first and new first
            N++;
        }

        public Item remove(Item item) {

            // check if list is empty
            if (first == null) {
                return null;
            }

            // handle removal of first node
            if (first.item.equals(item)) {
                Item itemToRemove = first.item;
                first = first.next; // remove the node
                N--;
                return itemToRemove;
            }

            // handle removal of non-first node
            Node x = first;
            while (x.next != null) {
                if (x.next.item.equals(item)) {
                    Item itemToRemove = x.next.item;
                    x.next = x.next.next;
                    N--;
                    return itemToRemove;
                }
                x = x.next;
            }

            // return null if item not found
            return null;
        }

        public Item removeLast() {
            if (first == null) {
                return null;
            }

            // handle removal of single node
            if (size() == 1) {
                Item itemToRemove = first.item;
                first = null; // remove the node
                N--;
                return itemToRemove;
            }

            // handle removal of last node
            Node secondLast = first;
            while (secondLast.next.next != null) {
                secondLast = secondLast.next;
            }

            Item itemToRemove = secondLast.next.item;
            secondLast.next = null; // remove the last node
            N--;
            return itemToRemove;

        }

    }

    public static void main(String[] args) {

        LinkedList<Integer> llist = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            llist.insertFront(i);
        }
        llist.print(); // output: 5 4 3 2 1

        // remove last item in the list
        StdOut.println("Removing last item...");
        llist.removeLast(); // Should remove '1'
        llist.print(); // Expected: 5 4 3 2

        StdOut.println("Removing item '3'...");
        llist.remove(Integer.valueOf(3)); // Should remove '3'
        llist.print(); // Expected: 5 4 2

        int size = llist.size();
        StdOut.println("The size of the linked list after removal is " + size);

    }
}
