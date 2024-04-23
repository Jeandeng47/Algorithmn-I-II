
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_2_4 {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1; // now s2 refers to "hello"
        string1 = "world"; // now s1 refers to "world"
        StdOut.println(string1); // world
        StdOut.println(string2); // hello
    }
}
