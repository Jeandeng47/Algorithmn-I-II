// Given a set of n integers S = {0, 1, 2, ..., n-1} and a sequence of request of the following form: (1) Remove x from S (2) Find the successor of x: the smallest y in S such that y >= x. Design a data type so that all operations (except construction)  take logarithmic time or better in the worst case

import java.util.TreeSet;

class successorBST {
    private TreeSet<Integer> treeSet;

    public successorBST(int n) {
        treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
        }
    }

    public void remove(int x) {
        treeSet.remove(x);
    }

    public Integer successor(int x) {
        return treeSet.higher(x);
    }
}

public class SuccessorWithDelete {
    public static void main(String[] args) {
        successorBST bst = new successorBST(10);

        bst.remove(5);
        System.out.println(bst.successor(5));
        System.out.println(bst.successor(3));
    }

}
