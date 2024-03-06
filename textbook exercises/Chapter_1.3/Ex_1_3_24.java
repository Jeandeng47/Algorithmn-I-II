import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_24 {
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

        public Node removeAfter(Node node) {
            if (node != null && node.next != null) {
                // remove the node after the given node
                node.next = node.next.next;
                N--;
            }
            return node;
        }

        public Node findNode(Item item) {
            for (Node x = first; x != null; x = x.next) {
                if (x.item.equals(item)) {
                    return x;
                }
            }
            return null;
        }

    }

    public static void main(String[] args) {
        LinkedList<String> llist = new LinkedList<>();

        llist.insertFront("Doe");
        llist.insertFront("John");
        llist.insertFront("am");
        llist.insertFront("I");
        llist.insertFront("World");
        llist.insertFront("Hello");

        StdOut.println("Linked list before removal: ");
        for (String s : llist) {
            StdOut.printf(s + " "); // ouput: Hello World I am John Doe
        }
        StdOut.println();

        // should remove the string after hello
        LinkedList<String>.Node node = llist.findNode("Hello");
        llist.removeAfter(node);

        StdOut.println("Linked list after removal: ");
        for (String s : llist) {
            StdOut.printf(s + " "); // ouput: Hello I am John Doe
        }
        StdOut.println();
    }
}
