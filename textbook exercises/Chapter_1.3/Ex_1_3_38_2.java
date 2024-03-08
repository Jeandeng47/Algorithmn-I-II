import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_38_2 {
    public static class GeneralizedQueueArray<Item> {
        private Item[] queue;
        private int size;

        // create an empty queue
        @SuppressWarnings("unchecked")
        public GeneralizedQueueArray() {
            queue = (Item[]) new Object[1];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void resize(int cap) {
            if (cap <= size) {
                throw new IllegalArgumentException();
            }

            @SuppressWarnings({ "unchecked", "unused" })
            Item[] copy = (Item[]) new Object[cap];
            for (int i = 0; i < size; i++) {
                copy[i] = queue[i];
            }
            queue = copy;
        }

        // add an item at the end
        public void insert(Item x) {
            if (size == queue.length) {
                resize(2 * queue.length);
            }
            queue[size] = x;
            size++;
        }

        // delete and return the kth least recently inserted item
        public Item delete(int k) {
            if (isEmpty() || k <= 0 || k > size) {
                throw new NoSuchElementException();
            }
            Item item = queue[k - 1];
            // move items after K forward by one
            for (int i = k; i < size; i++) {
                queue[i - 1] = queue[i];
            }
            size--;
            queue[size] = null; // update the end of queue
            if (size > 0 && size == queue.length / 4) {
                resize(queue.length / 2);
            }
            return item;
        }
    }

    public static void main(String[] args) {
        GeneralizedQueueArray<Integer> queue = new GeneralizedQueueArray<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        StdOut.println("This generalized queue is implemented by array.");

        // delete the 1st least recently inserted
        StdOut.println("Deleted " + queue.delete(1)); // Expected: Deleted 1
        // Queue state should now be: [2, 3, 4, 5]

        // delete the 2nd least recently inserted
        StdOut.println("Deleted " + queue.delete(2)); // Expected: Deleted 3
        // Queue state should now be: [2, 4, 5]

        StdOut.println("Deleted " + queue.delete(1)); // Expected: Deleted 2
        // Queue state should now be: [4, 5]

        StdOut.println("Deleted " + queue.delete(1)); // Expected: Deleted 4
        // Queue state should now be: [5]

        StdOut.println("The queue now is " + (queue.isEmpty() ? "empty." : "non-empty."));

    }

}
