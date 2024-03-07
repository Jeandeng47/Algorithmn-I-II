import java.util.NoSuchElementException;
import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_35 {
    public static class RandomQueue<Item> {
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
    }

    public static class Card {
        private final int suit; // 1: Hearts, 2: Diamonds, 3: Clubs, 4: Spades
        private final int rank; // 1-13

        public Card(int suit, int rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
            String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
            return ranks[rank - 1] + " of " + suits[suit - 1];
        }
    }

    public static void main(String[] args) {

        RandomQueue<Card> deck = new RandomQueue<>();

        // initialize deck with 52 cards
        for (int i = 1; i <= 4; i++) { // outside loop for 4 suits
            for (int j = 1; j <= 13; j++) { // inside loop for 13 ranks
                Card card = new Card(i, j);
                deck.enqueue(card);
            }
        }

        // deal 4 hands of 13 random cards each
        for (int i = 0; i < 4; i++) {
            StdOut.println("Hand " + (i + 1) + ":");
            for (int j = 0; j < 13; j++) {
                StdOut.println(deck.dequeue()); // remove a card
            }
            System.out.println();
        }
    }

}
