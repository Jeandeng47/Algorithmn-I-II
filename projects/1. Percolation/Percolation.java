import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private int size;
    private int openSites;
    private int virtualTop;
    private int virtualBottom;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF ufFull; // another uf to fix backwash problem

    // creates nxn grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be positive.");
        }
        size = n;
        openSites = 0;
        virtualTop = 0;
        virtualBottom = n * n + 1;
        uf = new WeightedQuickUnionUF(n * n + 2); // n^2 dots and two virtual dots

        grid = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
    }

    public boolean validate(int row, int col) {
        // checks if row or col index out of bound
        if (row < 1 || row > size || col < 1 || col > size) {
            return false;
        }
        return true;
    }

    public int getIndex(int row, int col) {
        return (row - 1) * size + col;
    }

    public void connectNeighbours(int row, int col) {
        // if the surrounding sites are open, connect to current site
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int currIndex = getIndex(row, col);
        for (int[] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];

            if (validate(newRow, newCol) && isOpen(newRow, newCol)) {
                uf.union(currIndex, getIndex(newRow, newCol));
                ufFull.union(currIndex, getIndex(newRow, newCol));
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!validate(row, col)) {
            throw new IllegalArgumentException("Row or col out of bound.");
        }
        ;
        int currIndex = getIndex(row, col);
        if (!grid[row - 1][col - 1]) {
            grid[row - 1][col - 1] = true;
            if (row == 1) {
                uf.union(virtualTop, currIndex);
                ufFull.union(virtualTop, currIndex);
            }
            if (row == size) {
                uf.union(virtualBottom, currIndex);
            }
            connectNeighbours(row, col);
            openSites++;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (!validate(row, col)) {
            throw new IllegalArgumentException("Row or col out of bound.");
        }
        ;
        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!validate(row, col)) {
            throw new IllegalArgumentException("Row or col out of bound.");
        }
        ;
        // a full site is a open site
        // and there is a path of open sites leading from it back to any site in the top
        // row
        return isOpen(row, col) && ufFull.find(virtualTop) == ufFull.find(getIndex(row, col));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(virtualTop) == uf.find(virtualBottom);
    }

    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);
        percolation.open(1, 3);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(3, 1);

    }
}

