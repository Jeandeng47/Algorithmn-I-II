import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_18 {
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
            Node prev = first;
            for (Node x = prev.next; x != null; prev = x, x = x.next) {
                if (x.item.equals(item)) {
                    Item itemToRemove = x.item;
                    // make the prev next refer to x next
                    prev.next = x.next;
                    N--;
                    return itemToRemove;
                }
            }

            // return null if item not found
            return null;
        }
        
    }

    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();
        // add integers in the list
        for (int i = 0; i <= 5; i++) {
            llist.insertFront(i);
        }
        llist.print();
        int size = llist.size();
        StdOut.print("Size of linked list before removal: " + size + "\n");

        // remove integers
        llist.remove(2);
        llist.remove(5);
        llist.print();
        size = llist.size();
        StdOut.print("Size of linked list before removal: " + size + "\n");

    }

}
