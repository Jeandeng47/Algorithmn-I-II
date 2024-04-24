import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_31 {
    public static class DoublyLinkedList<Item> implements Iterable<Item> {
        private DoubleNode first;
        private DoubleNode last;
        private int size;

        private class DoubleNode {
            Item item;
            DoubleNode prev;
            DoubleNode next;

            public DoubleNode(Item item) {
                this.item = item;
                this.prev = null;
                this.next = null;
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        // Insert at the beginning
        public void insertAtBeginning(Item item) {
            DoubleNode newNode = new DoubleNode(item);
            if (isEmpty()) {
                first = last = newNode;
            } else {
                newNode.next = first;
                first.prev = newNode;
                first = newNode;
            }
            size++;
        }

        // Insert at the end
        public void insertAtEnd(Item item) {
            DoubleNode newNode = new DoubleNode(item);
            if (isEmpty()) {
                first = last = newNode;
            } else {
                last.next = newNode;
                newNode.prev = last;
                last = newNode;
            }
            size++;
        }

        // Remove from the beginning
        public Item removeFromBeginning() {
            if (isEmpty())
                throw new NoSuchElementException("List is empty");
            Item item = first.item;
            first = first.next;
            if (first == null) {
                last = null;
            } else {
                first.prev = null;
            }
            size--;
            return item;
        }

        // Remove from the end
        public Item removeFromEnd() {
            if (isEmpty())
                throw new NoSuchElementException("List is empty");
            Item item = last.item;
            last = last.prev;
            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
            size--;
            return item;
        }

        // Insert before a given node
        public void insertBefore(DoubleNode node, Item item) {

            DoubleNode newNode = new DoubleNode(item);
            newNode.next = node;
            newNode.prev = node.prev;
            if (node.prev != null) {
                node.prev.next = newNode;
            } else {
                first = newNode; // Update first if node was the first node
            }
            node.prev = newNode;
            size++;

        }

        // Insert after a given node
        public void insertAfter(DoubleNode node, Item item) {

            DoubleNode newNode = new DoubleNode(item);
            newNode.prev = node;
            newNode.next = node.next;
            if (node.next != null) {
                node.next.prev = newNode;
            } else {
                last = newNode; // Update last if node was the last node
            }
            node.next = newNode;
            size++;
        }

        // Remove a given node
        public void removeNode(DoubleNode node) {
            if (node == first) {
                removeFromBeginning();
                return;
            }

            if (node == last) {
                removeFromEnd();
                return;
            }

            // the previous node's next points to the next node
            node.prev.next = node.next;
            // the next node's previous points to the previous node
            node.next.prev = node.prev;
            size--;
        }

        public DoubleNode get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            DoubleNode current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }

        @Override
        public Iterator<Item> iterator() {
            return new Iterator<Item>() {
                private DoubleNode current = first;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public Item next() {
                    if (!hasNext())
                        throw new NoSuchElementException();
                    Item item = current.item;
                    current = current.next;
                    return item;
                }
            };
        }

    }

    private static void printList(DoublyLinkedList<Integer> list) {
        for (int item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAtBeginning(2);
        list.insertAtBeginning(0);
        list.insertAtEnd(3);
        list.insertAtEnd(5);

        StdOut.println("After insertions:");
        printList(list); // output: 0 2 3 5

        DoublyLinkedList<Integer>.DoubleNode nodeAt0 = list.get(0);
        DoublyLinkedList<Integer>.DoubleNode nodeAt3 = list.get(3);

        list.insertBefore(nodeAt3, 4);
        list.insertAfter(nodeAt0, 1);

        StdOut.println("After insertions at given nodes:");
        printList(list); // output: 0 1 2 3 4 5

        list.removeFromBeginning();
        list.removeFromEnd();

        StdOut.println("After removals:");
        printList(list); // output: 1 2 3 4
    }
}
