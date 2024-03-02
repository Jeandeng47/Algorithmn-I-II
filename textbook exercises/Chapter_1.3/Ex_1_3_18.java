import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_18 {
    static class LinkedList<Item> {
        private Node first;
        private int N;

        // Define the node structure
        private class Node {
            Item item;
            Node next;
        }

        // Helper function to print out the linked list
        public void print() {
            // iterate through the list till the end
            for (Node x = first; x != null; x = x.next) {
                StdOut.printf(x.item.toString() + " ");
            }
            StdOut.println();
        }

        // insert the item at the front of the list
        public void insertFront(Item item) {
            Node oldFirst = first; // store old first node
            first = new Node(); // make new node the first
            first.item = item; // assign item
            first.next = oldFirst; // connect old first and new first
            N++;
        }

        // remove the node with specific item
        public Item remove(Item item) {

            // base case: check if list is empty
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

        public int size() {
            return N;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();
        // add integers in the list
        llist.insertFront(5);
        llist.insertFront(4);
        llist.insertFront(3);
        llist.insertFront(2);
        llist.insertFront(1);
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
