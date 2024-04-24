import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_14 {
    public static class ResizingArrayQueueOfStrings implements Iterable<String> {
        private int head; // index of first element
        private int tail; // index of next element to be added
        private int N; // number of elements in the array
        private String[] array;

        // Construct an empty array
        public ResizingArrayQueueOfStrings() {
            array = new String[1];
            head = 0;
            tail = 0;
            N = 0;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int capacity() {
            return array.length;
        }

        public int size() {
            return N;
        }

        // helper method to resize the array
        private void resize(int cap) {
            // ensure the new array is big enough to hold all the elements
            if (cap < size()) {
                throw new IllegalArgumentException("The capacity of the new array should be larger than size.");
            }
            String[] newArray = new String[cap];
            for (int i = 0; i < size(); i++) {
                newArray[i] = array[(head + i) % array.length];
            }
            array = newArray;
            // order is re-organized in the new array
            head = 0;
            tail = N;
        }

        // insert at the end of array
        public void enqueue(String item) {
            // double array size if it's full
            if (N == array.length) {
                resize(2 * array.length);
            }

            array[tail] = item;
            tail++;
            // wrap around
            if (tail == array.length) {
                tail = 0; // if tail is at the end of array, insert one at the front
            }
            N++;
        }

        // remove at the end of array
        public String dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue underflow");
            }
            String itemToRemove = array[head];
            array[head] = null;
            head++;

            // wrap around
            if (head == array.length) {
                head = 0; // if head is at the end of array, insert next one at the front
            }

            // resize if array utilization less than 25%
            if (size() > 0 && size() == array.length / 4) {
                resize(array.length / 2);
            }
            N--;
            return itemToRemove;
        }

        @Override
        public Iterator<String> iterator() {
            return new ArrayIterator();
        }

        // implement iterator to make queue iterable
        public class ArrayIterator implements Iterator<String> {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < N;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                String item = array[(head + i) % array.length];
                i++;
                return item;
            }

        }

    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();

        for (int i = 0; i <= 5; i++) {
            queue.enqueue(Integer.toString(i));
        }

        StdOut.println("After enqueue, the queue is: ");
        for (String s : queue) {
            StdOut.print(s + " ");
        }
        StdOut.println();

        queue.dequeue();
        queue.dequeue();

        StdOut.println("After dequeue, the queue now is: ");
        for (String s : queue) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
