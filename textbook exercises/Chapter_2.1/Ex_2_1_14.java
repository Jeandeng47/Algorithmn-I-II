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
        int passCounter = 0; // To track the number of passes
        do {
            swapsMade = false;
            StdOut.println("\nPass #" + (++passCounter) + " start:");
            printList(deck); // Print the deck state at the beginning of each pass

            for (int i = 0; i < deck.size() - 1; i++) {
                Card topCard = deck.get(0);
                Card secondCard = deck.get(1);

                // Swap if out of order (top > second)
                if (topCard.compareTo(secondCard) > 0) {
                    // Swapping top two cards
                    deck.removeFirst();
                    deck.add(1, topCard); // Add topCard back after secondCard
                    swapsMade = true;
                    StdOut.println("Swapped: " + topCard + " with " + secondCard);
                }

                // Move the top card of the deck to the bottom
                Card movedCard = deck.removeFirst();
                deck.addLast(movedCard);
                StdOut.println("Moved " + movedCard + " to bottom");
            }
            // Additional move to ensure circular comparison
            Card movedCard = deck.removeFirst();
            deck.addLast(movedCard);
            StdOut.println("Final move to ensure circular comparison: Moved " + movedCard + " to bottom");

            StdOut.println("Pass #" + passCounter + " end:");
            printList(deck); // Print the deck state at the end of each pass

            if (!swapsMade) {
                StdOut.println("\nNo swaps made in this pass. Deck is sorted.");
            }
        } while (swapsMade);
    }

    public static void circularBubbleSort(LinkedList<Integer> intDeck) {
        boolean swapsMade;
        int passCounter = 0;
        do {
            swapsMade = false;
            StdOut.println("\nPass #" + (++passCounter) + " start:");
            printIntList(intDeck);

            for (int i = 0; i < intDeck.size() - 1; i++) {
                int top = intDeck.get(0);
                int next = intDeck.get(1);

                // swap top two if out of order
                if (top > next) {
                    intDeck.removeFirst();
                    intDeck.add(1, top);
                    swapsMade = true;
                    System.out.println("Swapped: " + next + " | " + top + "  ");
                    printIntList(intDeck);
                }

                // Move the top card of the deck to the bottom
                int moved = intDeck.removeFirst();
                intDeck.addLast(moved);
                printIntList(intDeck);
            }
            // Move the top card of the deck to the bottom
            int moved = intDeck.removeFirst();
            intDeck.addLast(moved);
            StdOut.println("Final move to ensure circular comparison: Moved " + moved + " to bottom");

            StdOut.println("Pass #" + passCounter + " end:");
            printIntList(intDeck); // Print the deck state at the end of each pass

            if (!swapsMade) {
                StdOut.println("\nNo swaps made in this pass. Deck is sorted.");
            }

        } while (swapsMade);

    }

    private static <T> void printList(LinkedList<Card> deque) {
        for (Card card : deque) {
            StdOut.print(card + " | ");
        }
        StdOut.println();
    }

    private static void printIntList(LinkedList<Integer> intDeck) {
        for (Integer i : intDeck) {
            StdOut.print(i + " ");
        }
        StdOut.println();
        for (int i = 0; i <= 1; i++) {
            StdOut.print("^ ");
        }
        StdOut.println();

    }

    public static void main(String[] args) {

        // // deck with small number of cards
        // LinkedList<Card> smallDeck = new LinkedList<>();
        // smallDeck.add(new Card(1, 13)); // King of Spades
        // smallDeck.add(new Card(4, 1)); // Ace of Diamonds
        // smallDeck.add(new Card(2, 11)); // Jack of Hearts
        // smallDeck.add(new Card(3, 7)); // 7 of Clubs
        // smallDeck.add(new Card(2, 2)); // 2 of Hearts

        // StdOut.println("Original deque:");
        // printList(smallDeck);

        // sortDeck(smallDeck);

        // StdOut.println("Sorted deque:");
        // printList(smallDeck);

        // // deck with all cards
        // LinkedList<Card> fullDeck = new LinkedList<>();
        // for (int suit = 1; suit <= 4; suit++) {
        // for (int rank = 1; rank <= 13; rank++) {
        // fullDeck.add(new Card(suit, rank));
        // }
        // }

        // Collections.shuffle(fullDeck);
        // StdOut.println("Shuffled deck: ");
        // printList(fullDeck);

        // sortDeck(fullDeck);
        // StdOut.println("\nSorted deck: ");
        // printList(fullDeck);

        // for understanding algo
        LinkedList<Integer> intDeck = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            intDeck.addLast(i);
        }

        Collections.shuffle(intDeck);
        StdOut.println("Shuffled int deck: ");
        printIntList(intDeck);

        circularBubbleSort(intDeck);
        // StdOut.println("Sorted int deck: ");
        // printIntList(intDeck);

    }

}
