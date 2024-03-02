
public class FixedCapacityStackOfStrings implements FixedCapacityStackOfStringsInterface {
    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        // initialized an array of given capacity
        a = new String[cap];
    }

    @Override
    public void push(String item) {
        // first store at a[N], then increase N
        a[N++] = item;
    }
    
    @Override
    public String pop() {
        // first get a[N], then decreases N
        return a[--N];

    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }


}
