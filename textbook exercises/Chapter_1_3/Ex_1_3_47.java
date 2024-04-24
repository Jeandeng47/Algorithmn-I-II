import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_3_47 {
    public static class CatenableQueue<Item> {
        private Node last; // ointer to the last node
        private int size;

        private class Node {
            Item item;
            Node next;
        }

        public CatenableQueue() {
            last = null;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void enqueue(Item item) {
            Node newNode = new Node();
            newNode.item = item;
            if (isEmpty()) {
                newNode.next = newNode; // point to itself, circular
                last = newNode; // both first and last node
            } else {
                newNode.next = last.next; // new node's next point to first node
                last.next = newNode; // connect current last and new node
                last = newNode; // update last pointer
            }
            size++;
        }

        public Item dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            Item item = last.next.item; // item in the first node
            if (last.next == last) {
                last = null; // only one node in the list
            } else {
                last.next = last.next.next; // set the last node's next to the second node, removing the first node
            }
            size--;
            return item;

        }

        public void catenate(CatenableQueue<Item> q) {
            if (q.isEmpty()) {
                return; // nothing to catenate
            }
            if (isEmpty()) {
                this.last = q.last;
            } else {
                // connect this's last and q's front
                Node temp = this.last.next; // store first node
                this.last.next = q.last.next; // make last points to q's first
                q.last.next = temp; // make q's last poinst to this' old first
                this.last = q.last; // update last pointer
            }
            // update size
            this.size = this.size() + q.size();
            // clear up q
            q.last = null;
            q.size = 0;
        }
    }

    public static void main(String[] args) {
        CatenableQueue<String> queue1 = new CatenableQueue<>();
        CatenableQueue<String> queue2 = new CatenableQueue<>();

        // Enqueue elements into the first queue
        StdOut.println("Enqueueing to Queue 1: A, B, C");
        queue1.enqueue("A");
        queue1.enqueue("B");
        queue1.enqueue("C");

        // Enqueue elements into the second queue
        StdOut.println("Enqueueing to Queue 2: D, E, F");
        queue2.enqueue("D");
        queue2.enqueue("E");
        queue2.enqueue("F");

        // Catenate queue2 to queue1
        StdOut.println("Catenating Queue 2 to Queue 1");
        queue1.catenate(queue2);

        System.out.println("Dequeueing from Queue 1 after catenation:");
        while (!queue1.isEmpty()) {
            StdOut.print(queue1.dequeue() + " ");
        }
        StdOut.println();

        // Check the size of both queues after catenation
        StdOut.println("Size of Queue 1 after dequeueing: " + queue1.size()); // Expected: 0
        StdOut.println("Size of Queue 2 after catenation: " + queue2.size()); // Expected: 0
    }
}
