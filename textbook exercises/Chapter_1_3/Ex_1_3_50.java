import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_50 {
    public static class Stack<Item> implements Iterable<Item> {
        private Node first;
        private int size;
        private int modCount = 0; // modification counter

        private class Node {
            Item item;
            Node next;
        }

        public Stack() {
            first = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(Item item) {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            size++;
            modCount++;
        }

        public Item pop() {
            if (isEmpty())
                throw new NoSuchElementException("Stack underflow");
            Item item = first.item;
            first = first.next;
            size--;
            modCount++; // Increment modification counter
            return item;
        }

        @Override
        public Iterator<Item> iterator() {
            return new StackIterator(first, modCount);
        }

        private class StackIterator implements Iterator<Item> {

            private Node current;
            private final int expectedModCount;

            public StackIterator(Node first, int modCount) {
                current = first;
                expectedModCount = modCount;
            }

            // check that count has not changed since costruction of the iterator
            @Override
            public boolean hasNext() {
                if (expectedModCount != Stack.this.modCount) {
                    throw new ConcurrentModificationException();
                }
                return current != null;
            }

            @Override
            public Item next() {
                if (expectedModCount != Stack.this.modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext())
                    throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }

        }
    }

    public static void main(String[] args) {
        Stack<Integer> failFastStack = new Stack<>();
        failFastStack.push(1);
        failFastStack.push(2);
        failFastStack.push(3);
        failFastStack.push(4);

        Iterator<Integer> iterator = failFastStack.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            StdOut.println("Popped: " + num);
            if (num == 2) {
                failFastStack.pop(); // This should cause a ConcurrentModificationException on the next call to
                // hasNext() or next()
            }

        }
    }

}
