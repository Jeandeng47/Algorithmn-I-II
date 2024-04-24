import java.util.Random;

import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_13 {

    public static class Card implements Comparable<Card> {
        private int suit;
        private int rank;

        // 1-spades, 2-hearts, 3-clubs, 4-diamonds
        public Card(int suit, int rank) {
            this.suit = suit;
            this.rank = rank;
        }

        public String toString() {
            String[] suits = { "Spades", "Hearts", "Clubs", "Diamonds" };
            String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

            return ranks[this.rank - 1] + " of " + suits[this.suit - 1];
        }

        @Override
        public int compareTo(Card other) {
            // if suits and rank equals, cards are the same
            if (this.suit != other.suit) {
                return Integer.compare(this.suit, other.suit);
            } else {
                return Integer.compare(this.rank, other.rank);
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exchange(a, j, j - 1);
                }
            }
        }
    }

    // exchange two cards
    private static <T extends Comparable<T>> void exchange(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // check the values of two cards
    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    private static <T extends Comparable<T>> void shuffle(T[] a) {
        Random rand = new Random();
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + rand.nextInt(N - i); // [0, N - i- 1] + i -> [i, N - 1]
            T temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args) {
        int numOfSuits = 4;
        int numOfRank = 13;
        Card[] deck = new Card[numOfRank * numOfSuits];

        int index = 0;
        for (int i = 1; i <= numOfSuits; i++) {
            for (int j = 1; j <= numOfRank; j++) {
                deck[index] = new Card(i, j);
                index++;
            }
        }

        // shuffle the deck before sorting
        shuffle(deck);

        // sort by increaing order
        insertionSort(deck);

        // Print the sorted deck
        for (Card card : deck) {
            StdOut.print(card + " | ");
        }
        StdOut.println();
    }
}
