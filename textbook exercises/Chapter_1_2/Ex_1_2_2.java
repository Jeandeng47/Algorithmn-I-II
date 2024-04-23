
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_2_2 {
    public static void findIntersections(Interval1D[] intervals) {
        int N = intervals.length;
        StdOut.println("The intersecting intervals: ");
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Interval1D interval1 = intervals[i];
                Interval1D interval2 = intervals[j];
                if (interval1.intersects(interval2)) {
                    StdOut.println(interval1 + "\t" + interval2);
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length <= 1) {
            StdOut.println("Usage: java Ex_1_2_2 <intN> < intervals.txt");
        }
        int N = Integer.parseInt(args[0]); // number of pairs
        Interval1D[] intervals = new Interval1D[N];
        for (int i = 0; i < N; i++) {
            intervals[i] = new Interval1D(StdIn.readDouble(), StdIn.readDouble());
        }
        findIntersections(intervals);
    }
}