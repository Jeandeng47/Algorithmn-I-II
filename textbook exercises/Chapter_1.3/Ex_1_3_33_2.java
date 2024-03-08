import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_33_2 {

    public static class ResizingArrayDeque<Item> implements Iterable<Item> {
        private Item[] deque;
        private int size;
        private int first;
        private int last;

        // create an empty deque
        @SuppressWarnings("unchecked")
        public ResizingArrayDeque() {
            deque = (Item[]) new Object[2];
            first = last = 0;
            size = 0;
        }

        // is the deque empty?
        public boolean isEmpty() {
            return size == 0;
        }

        // number of items in the deque
        public int size() {
            return size;
        }

        // helper method to resize the deque array (wrap-around)
        private void resize(int cap) {
            if (cap <= size) {
                throw new IllegalArgumentException();
            }

            @SuppressWarnings("unchecked")
            Item[] copy = (Item[]) new Object[cap];
            for (int i = 0; i < size; i++) {
                copy[i] = deque[(first + i) % deque.length];
            }
            deque = copy;
            first = 0;
            last = size;
        }

        // add an item to the left end
        public void pushLeft(Item item) {
            if (size == deque.length) {
                resize(2 * deque.length);
            }

            // assume first = 0, deque length is 5
            // we want the first item to be as right as possible (index 4)
            // with (0 - 1 + 5) % 5, first is at the end (index 4)
            // for next push left, (4 - 1 + 5) % 5 = 3, we insert at index 3

            first = (first - 1 + deque.length) % deque.length; // Adjust first to the new insertion point
            deque[first] = item; // Insert the item at this new first position
            size++;
        }

        // remove an item from the left end
        public Item popLeft() {

            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            // assume first = 0, deque length is 5, after remove old first
            // with (0 + 1) % 5 = 1, now our new first refer to index 1

            Item item = deque[first]; // Access and store the item to be removed
            deque[first] = null; // Clear the slot (optional)
            first = (first + 1) % deque.length; // Move first to the next item
            size--;

            if (size > 0 && size == deque.length / 4) {
                resize(deque.length / 2);
            }
            return item;
        }

        // add an item to the right end
        public void pushRight(Item item) {
            if (size == deque.length) {
                resize(2 * deque.length);
            }

            // assume last = 4, deque length is 5
            // we want the first item to be as left as possible (index 0)
            // with (4 + 1) % 5, first is at the end (index 0)
            // for next push left, (0 + 1) % 5 = 1, we insert at index 1

            deque[last] = item; // Insert item at current last position
            last = (last + 1) % deque.length; // Move last to the next position (wrap around if at end)

            size++;
        }

        // remove an item from the right end
        public Item popRight() {

            if (isEmpty()) {
                throw new NoSuchElementException();
            }

            // assume last = 4, deque length is 5, after remove old last
            // with (4 - 1 + 5) % 5 = 3, now our new last refer to index 3

            last = (last - 1 + deque.length) % deque.length; // Move last back to the last occupied position
            Item item = deque[last]; // Access the item to be removed
            deque[last] = null; // Clear the slot
            size--;

            if (size > 0 && size == deque.length / 4) {
                resize(deque.length / 2);
            }
            return item;

        }

        @Override
        public Iterator<Item> iterator() {

            return new Iterator<Item>() {
                private int i = 0;

                @Override
                public boolean hasNext() {
                    return i < size;
                }

                @Override
                public Item next() {
                    if (!hasNext())
                        throw new NoSuchElementException();
                    Item item = deque[(first + i) % deque.length];
                    i++;
                    return item;
                }

            };

        }
    }

    private static void printDeque(ResizingArrayDeque<Integer> deque) {
        for (int num : deque) {
            StdOut.print(num + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();

        for (int i = 5; i > 0; i--) {
            deque.pushLeft(i);
        }
        StdOut.println("Deque after push left: ");
        printDeque(deque); // output: 1 2 3 4 5

        for (int i = 6; i <= 10; i++) {
            deque.pushRight(i);
        }
        StdOut.println("Deque after push right: ");
        printDeque(deque); // output: 1 2 3 4 5 6 7 8 9 10

        deque.popLeft();
        StdOut.println("Deque after pop left: ");
        printDeque(deque); // output: 2 3 4 5 6 7 8 9 10

        deque.popRight();
        StdOut.println("Deque after pop right: ");
        printDeque(deque); // output: 2 3 4 5 6 7 8 9
    }
}
