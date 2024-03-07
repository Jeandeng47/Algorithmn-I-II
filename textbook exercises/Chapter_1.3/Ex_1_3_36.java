import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_36 {
    public static class RandomQueue<Item> implements Iterable<Item> {
        private Item[] randomQueue;
        private int size;
        private Random rand; // Random number generator

        @SuppressWarnings("unchecked")
        public RandomQueue() {
            randomQueue = (Item[]) new Object[1];
            size = 0;
            rand = new Random();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void resize(int cap) {
            if (cap <= size) {
                throw new IllegalArgumentException();
            }

            @SuppressWarnings("unchecked")
            Item[] copy = (Item[]) new Object[cap];
            for (int i = 0; i < size; i++) {
                copy[i] = randomQueue[i];
            }
            randomQueue = copy;
        }

        // add an item
        public void enqueue(Item item) {
            if (size == randomQueue.length) {
                resize(2 * randomQueue.length);
            }
            randomQueue[size] = item;
            size++;
        }

        // remove and return a random item (sample without replacement)
        public Item dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            // generate a random int of range [0, size - 1]
            int randomIndex = rand.nextInt(size);

            // swap with the last item
            Item item = randomQueue[randomIndex];
            randomQueue[randomIndex] = randomQueue[size - 1];
            randomQueue[size - 1] = null;
            size--;
            if (size > 0 && size == randomQueue.length / 4) {
                resize(randomQueue.length / 2);
            }
            return item;
        }

        // return a random item, but do not remove (sample with replacement)
        public Item sample() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            int randomIndex = rand.nextInt(size);
            return randomQueue[randomIndex];
        }

        @Override
        public Iterator<Item> iterator() {
            return new RandomQueueIterator();
        }

        private class RandomQueueIterator implements Iterator<Item> {
            private int current = 0;
            private final Item[] shuffledQueue;

            @SuppressWarnings("unchecked")
            public RandomQueueIterator() {
                shuffledQueue = (Item[]) new Object[size];
                System.arraycopy(randomQueue, 0, shuffledQueue, 0, size);
                shuffleArray(shuffledQueue);
            }

            private void shuffleArray(Item[] array) {
                for (int i = 0; i < size; i++) {
                    int r = i + rand.nextInt(size - i);
                    Item temp = array[i];
                    array[i] = array[r];
                    array[r] = temp;
                }
            }

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item item = shuffledQueue[current];
                current++;
                return item;
            }

        }
    }

    private static void printRandomQueue(RandomQueue<Integer> queue) {
        for (int num : queue) {
            StdOut.print(num + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        RandomQueue<Integer> queue = new RandomQueue<>();

        for (int i = 1; i <= 10; i++) {
            queue.enqueue(i);
        }

        StdOut.println("First iteration of random queue: ");
        printRandomQueue(queue);

        StdOut.println("Second iteration of random queue: ");
        printRandomQueue(queue); // should be in different order

    }
}
