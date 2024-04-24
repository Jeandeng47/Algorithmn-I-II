public class Ex_1_3_39 {
    public static class RingBuffer<Item> {
        private Item[] buffer;
        private int size;
        private int head;
        private int tail;
        private final int capacity; // fixed size of the buffer

        // Constructor to create a buffer of a specific capacity.
        @SuppressWarnings("unchecked")
        public RingBuffer(int cap) {
            capacity = cap;
            buffer = (Item[]) new Object[capacity];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == buffer.length;
        }

        public int size() {
            return size;
        }

        // Add an item to the buffer. Wait or notify if full.
        public void enqueue(Item item) {
            if (isFull()) {
                throw new RuntimeException("Ringbuffer is full now.");
            }
            buffer[tail] = item;
            tail = (tail + 1) % capacity; // point to next available slot
            size++;
        }

        // Remove and return the item from the buffer that was added earliest. Wait or
        // notify if empty.
        public Item dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Ringbuffer is empty now.");
            }

            Item item = buffer[head];
            buffer[head] = null;
            head = (head + 1) % capacity; // point to next available slot
            size--;
            return item;
        }
    }

    public static void main(String[] args) {
        // Create a ring buffer with capacity 5
        RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);

        // Enqueue items into the buffer
        System.out.println("Enqueue items:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enqueue: " + i);
            ringBuffer.enqueue(i);
        }

        // Check if the buffer is full
        if (ringBuffer.isFull()) {
            System.out.println("The ring buffer is full.");
        }

        // Dequeue three items from the buffer
        System.out.println("\nDequeue items:");
        for (int i = 0; i < 3; i++) {
            int item = ringBuffer.dequeue();
            System.out.println("Dequeued: " + item);
        }

        // Enqueue two more items into the buffer
        System.out.println("\nEnqueue more items:");
        ringBuffer.enqueue(6);
        System.out.println("Enqueue: 6");
        ringBuffer.enqueue(7);
        System.out.println("Enqueue: 7");

        // Dequeue the remaining items
        System.out.println("\nDequeue remaining items:");
        while (!ringBuffer.isEmpty()) {
            int item = ringBuffer.dequeue();
            System.out.println("Dequeued: " + item);
        }

        // Check if the buffer is empty
        if (ringBuffer.isEmpty()) {
            System.out.println("\nThe ring buffer is now empty.");
        }
    }

}
