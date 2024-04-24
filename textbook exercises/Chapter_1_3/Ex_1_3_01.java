
public class Ex_1_3_01 {
    public static class FixedCapacityStackOfStrings {
        private String[] a;
        private int N;

        public FixedCapacityStackOfStrings(int cap) {
            // initialized an array of given capacity
            a = new String[cap];
        }

        public void push(String item) {
            // first store at a[N], then increase N
            a[N++] = item;
        }

        public String pop() {
            // first get a[N], then decreases N
            return a[--N];

        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public boolean isFull() {
            return N == a.length;
        }

    }

}