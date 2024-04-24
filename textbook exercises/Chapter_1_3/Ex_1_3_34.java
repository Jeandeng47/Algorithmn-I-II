import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_34 {
    public static class RandomBag<Item> implements Iterable<Item> {
        private Item[] randomBag;
        private int size;

        @SuppressWarnings("unchecked")
        public RandomBag() {
            randomBag = (Item[]) new Object[1];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        private void resize(int cap) {
            if (cap <= size) {
                throw new IllegalArgumentException();
            }

            @SuppressWarnings("unchecked")
            Item[] copy = (Item[]) new Object[cap];
            for (int i = 0; i < size; i++) {
                copy[i] = randomBag[i];
            }
            randomBag = copy;
        }

        // add item to the end
        public void add(Item item) {
            if (size == randomBag.length) {
                resize(randomBag.length * 2);
            }
            randomBag[size] = item;
            size++;
        }

        @Override
        public Iterator<Item> iterator() {
            return new RandomBagIterator();
        }

        private class RandomBagIterator implements Iterator<Item> {
            private int current;
            private final Item[] shuffledBag;

            public RandomBagIterator() {
                shuffledBag = randomBag.clone(); // create a copy of array for shuffling
                shuffleArray(shuffledBag);
            }

            private void shuffleArray(Item[] array) {
                Random rand = new Random();
                for (int i = 0; i < size; i++) {
                    // random index of range [i, size - i]
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
                if (isEmpty()) {
                    throw new NoSuchElementException();
                }
                Item item = shuffledBag[current];
                current++;
                return item;
            }

        }

    }

    private static void printRandomBage(RandomBag<Integer> bag) {
        for (int num : bag) {
            StdOut.print(num + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {

        RandomBag<Integer> bag = new RandomBag<>();

        for (int i = 1; i <= 10; i++) {
            bag.add(i);
        }
        StdOut.println("Random bag after adding: "); // output: 1- 10 in random order
        printRandomBage(bag);

        StdOut.println("Check Random bag again: "); // output: 1- 10 in random order (different than last time)
        printRandomBage(bag);
    }
}
