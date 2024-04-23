
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_2_6 {
    public static boolean isCircularRotation(String s, String t) {
        return s.length() == t.length() &&
                (s + s).indexOf(t) != -1; // s+s contain t
    }

    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "TGACGAC";

        if (isCircularRotation(s, t)) {
            StdOut.println(t + " is a circular rotation of " + s);
        } else {
            StdOut.println(t + " is not a circular rotation of " + s);
        }
    }
}
