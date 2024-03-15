import java.util.Collections;
import java.util.LinkedList;

import edu.princeton.cs.algs4.StdOut;

public class Ex_2_1_14 {

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
            // first compare suit than compare rank
            if (this.suit != other.suit) {
                return Integer.compare(this.suit, other.suit);
            } else {
                return Integer.compare(this.rank, other.rank);
            }
        }
    }

    // circular version of bubble sort
    public static void sortDeck(LinkedList<Card> deck) {
        boolean swapsMade;
        do {
            swapsMade = false;
            for (int i = 0; i < deck.size() - 1; i++) {
                Card topCard = deck.get(0);
                Card secondCard = deck.get(1);

                // Swap if out of order (top > second)
                if (topCard.compareTo(secondCard) > 0) {
                    // Swapping top two cards
                    deck.removeFirst();
                    deck.add(1, topCard); // Add topCard back after secondCard
                    swapsMade = true;
                }

                // Move the top card of the deck to the bottom
                deck.addLast(deck.removeFirst());
            }
            // Additional move to ensure circular comparison
            deck.addLast(deck.removeFirst());
        } while (swapsMade);
    }

    private static <T> void printList(LinkedList<Card> deque) {
        for (Card card : deque) {
            StdOut.print(card + " | ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {

        // deck with small number of cards
        LinkedList<Card> smallDeck = new LinkedList<>();
        smallDeck.add(new Card(1, 13)); // King of Spades
        smallDeck.add(new Card(4, 1)); // Ace of Diamonds
        smallDeck.add(new Card(2, 11)); // Jack of Hearts
        smallDeck.add(new Card(3, 7)); // 7 of Clubs
        smallDeck.add(new Card(2, 2)); // 2 of Hearts

        StdOut.println("Original deque:");
        printList(smallDeck);

        sortDeck(smallDeck);

        StdOut.println("Sorted deque:");
        printList(smallDeck);

        // deck with all cards
        LinkedList<Card> fullDeck = new LinkedList<>();
        for (int suit = 1; suit <= 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                fullDeck.add(new Card(suit, rank));
            }
        }

        Collections.shuffle(fullDeck);
        StdOut.println("Shuffled deck: ");
        printList(fullDeck);

        sortDeck(fullDeck);
        StdOut.println("\nSorted deck: ");
        printList(fullDeck);

    }

}
