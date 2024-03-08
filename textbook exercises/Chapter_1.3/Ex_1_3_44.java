import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_44 {

    public static class Buffer {
        private Stack<Character> leftStack;
        private Stack<Character> rightStack;

        // create an empty buffer
        public Buffer() {
            leftStack = new Stack<>(); // hold items left to cursor
            rightStack = new Stack<>(); // hold items right to cursor
        }

        // insert c at the cursor position
        public void insert(char c) {
            leftStack.push(c);
        }

        // delete and return the character at the cursor
        public char delete() {
            if (rightStack.isEmpty()) {
                return '\0';
            } else {
                return rightStack.pop();
            }
        }

        // move the cursor k positions to the left
        // -> equals to moving k items at right stack to the left stack
        public void left(int k) {
            while (k > 0 && !leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
                k--;
            }

        }

        // move the cursor k positions to the right
        // -> equals to moving k items at left stack to the right stack
        public void right(int k) {
            while (k > 0 && !rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
                k--;
            }
        }

        // number of characters in the buffer
        public int size() {
            return leftStack.size() + rightStack.size();
        }

        // for visualization and debugging
        public String toString() {

            Stack<Character> temp = new Stack<>();

            // left stack: 1 2 3 4 5
            while (!leftStack.isEmpty()) {
                temp.push(leftStack.pop());
            } // temp: 5 4 3 2 1

            StringBuilder bufferContent = new StringBuilder();

            while (!temp.isEmpty()) {
                char c = temp.pop();
                bufferContent.append(c); // content: 1 2 3 4 5
                leftStack.push(c); // left stack: 1 2 3 4 5
            }
            bufferContent.append("|"); // represent cursor
            for (Character c : rightStack) {
                bufferContent.append(c);
            }
            return bufferContent.toString();
        }

    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        buffer.insert('A');
        buffer.insert('B');
        buffer.insert('C');
        StdOut.println("After inserts: " + buffer.toString());
        // Expected : After inserts: ABC|

        buffer.left(2);
        StdOut.println("After moving left: " + buffer.toString());
        // Expected: After moving left: A|BC

        buffer.insert('D');
        StdOut.println("After inserting at cursor: " + buffer.toString());
        // Expected: After inserting at cursor: AD|BC

        buffer.right(2);
        StdOut.println("After moving right: " + buffer.toString());
        // Expected: After moving right: ADBC|

        buffer.delete();
        StdOut.println("After deleting at cursor: " + buffer.toString());
        // After deleting at cursor: ADBC|

        StdOut.println("Buffer size: " + buffer.size());
        // Buffer size: 4

    }

}
