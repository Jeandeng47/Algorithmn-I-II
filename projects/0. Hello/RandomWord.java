import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    /**
     * Reads a sequence of words from standard input and prints one of the words
     * using knuth's method
     * 
     * @param args sequence of words
     */
    public static void main(String[] args) {

        String champion = "";
        int count = 0;

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            count++;

            // use knuth's method: select the word with probability 1/i to be the champion
            if (StdRandom.bernoulli(1.0 / count)) {
                champion = word;
            }
        }
        StdOut.println(champion);

    }
}