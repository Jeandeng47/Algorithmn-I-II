import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_40 {

    public static class MoveToFrontLList<Item> implements Iterable<Item> {
        private Node head;
        private int size;

        private class Node {
            Item item;
            Node next;

            public Node(Item item) {
                this.item = item;
                this.next = null;
            }
        }

        public MoveToFrontLList() {
            this.head = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        // Method that implements the move-to-front strategy
        public void moveToFront(Item item) {
            if (isContain(item)) {
                deleteNode(item);
            }
            insertFront(item);

        }

        private boolean isContain(Item item) {
            if (isEmpty()) {
                return false;
            }

            if (head.item.equals(item)) {
                return true;
            }

            Node current = head;
            while (current != null) {
                if (current.item.equals(item)) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        // Helper method to find and delete a node with a specific char (if it exists)
        private void deleteNode(Item item) {
            // if list is empty
            if (isEmpty()) {
                return;
            }

            // if list has only one node
            if (head.item.equals(item)) {
                head = head.next; // head = null
                size--;
                return;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.item.equals(item)) {
                    // current is the node before the duplicate
                    current.next = current.next.next;
                    size--;
                    return;
                }
                current = current.next;
            }
            // do nothing if duplicate not found

        }

        // Helper method to insert a character at the beginning of the list
        private void insertFront(Item item) {
            Node oldHead = head;
            head = new Node(item);
            head.next = oldHead;
            size++;
            return;
        }

        @Override
        public Iterator<Item> iterator() {
            return new MoveToFrontLListIterator();
        }

        private class MoveToFrontLListIterator implements Iterator<Item> {
            Node current = head;

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

    private static void printList(MoveToFrontLList<String> list) {
        for (String s : list) {
            StdOut.print(s + " ");
        }
        StdOut.println();

    }

    public static void main(String[] args) {
        MoveToFrontLList<String> list = new MoveToFrontLList<>();
        Scanner scanner = new Scanner(System.in);

        StdOut.println("Enter sequence of characters: ");
        String input = scanner.nextLine();
        String[] inputArray = input.split("\\s+");

        for (String s : inputArray) {
            list.moveToFront(s);
            printList(list); // Optional: print the list after each insertion
        }

        scanner.close();

    }
}
