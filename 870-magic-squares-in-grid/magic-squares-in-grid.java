class Solution {

    public int numMagicSquaresInside(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        for (int i = 0; i <= rows - 3; i++) {

            for (int j = 0; j <= cols - 3; j++) {

                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isMagic(int[][] grid, int r, int c) {

        boolean[] seen = new boolean[10];

        // Check numbers are unique and between 1-9
        for (int i = r; i < r + 3; i++) {

            for (int j = c; j < c + 3; j++) {

                int num = grid[i][j];

                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }

                seen[num] = true;
            }
        }

        // Target sum
        int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];

        // Check rows
        for (int i = r; i < r + 3; i++) {

            int rowSum = 0;

            for (int j = c; j < c + 3; j++) {
                rowSum += grid[i][j];
            }

            if (rowSum != sum) {
                return false;
            }
        }

        // Check columns
        for (int j = c; j < c + 3; j++) {

            int colSum = 0;

            for (int i = r; i < r + 3; i++) {
                colSum += grid[i][j];
            }

            if (colSum != sum) {
                return false;
            }
        }

        // Main diagonal
        if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != sum) {
            return false;
        }

        // Secondary diagonal
        if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != sum) {
            return false;
        }

        return true;
    }
}