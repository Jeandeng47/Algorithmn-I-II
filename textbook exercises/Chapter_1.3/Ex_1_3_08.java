import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_08 {
    public static class DoublingStackOfStrings {
        int N = 0;
        String[] array;

        public DoublingStackOfStrings() {
            array = new String[1];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        // number of elements
        public int size() {
            return N;
        }

        // total space allocated
        public int capacity() {
            return array.length;
        }

        // helper method to resize the array
        private void resize(int cap) {
            String[] copy = new String[cap];
            for (int i = 0; i < N; i++) {
                copy[i] = array[i];
            }
            array = copy;
        }

        public void push(String item) {
            // double size of array if full
            if (N == array.length) {
                resize(2 * array.length);
            }
            array[N++] = item;
        }

        public String pop() {

            if (isEmpty())
                throw new RuntimeException("Stack underflow");

            String item = array[--N];
            array[N] = null; // avoid loitering

            // shrink the array if utilization lower than 25%
            if (N > 0 && N <= array.length / 4) {
                resize(array.length / 2);
            }
            return item;
        }

        public String peek() {
            if (isEmpty())
                throw new RuntimeException("Stack underflow");
            return array[N - 1];
        }

    }

    public static void main(String[] args) {
        DoublingStackOfStrings stack = new DoublingStackOfStrings();
        String[] str = "it was - the best - of times - - - it was - the - -".split("\\s+");
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("-")) {
                if (!stack.isEmpty()) {
                    StdOut.println(stack.pop());
                }
            } else {
                stack.push(str[i]);
            }
        }

        StdOut.printf("Number of elements left on stack: %d \n", stack.size());
        StdOut.printf("The size of the array: %d\n", stack.capacity());
    }
}
