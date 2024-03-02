public interface FixedCapacityStackOfStringsInterface {
    /**
     * Creates an empty stack of capacity cap
     * 
     * @param cap the given capacity of the stack
     * @return the created empty stack
     */
    public FixedCapacityStackOfStrings(int cap);

    /**
     * Add a string to the stack
     * 
     * @param item the String item to be put into stack.
     */
    public void push(String item);

    /**
     * Remove and return the most recently added String.
     * 
     * @return
     */
    public String pop();

    /**
     * Check if the stack is empty.
     * 
     * @return true if the empty
     */
    public boolean isEmpty();

    /**
     * Return the number of items on the stack.
     * 
     * @return the size of the stack.
     */
    public int size();

}
