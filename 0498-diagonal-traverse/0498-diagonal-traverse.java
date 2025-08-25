class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[n * m];
        int row = 0, col = 0;
        boolean up = true;
        int index = 0;

        while (index < n * m) {
            result[index++] = mat[row][col];

            if (up) { // moving up
                if (col == m - 1) { // last column
                    row++;
                    up = false;
                } else if (row == 0) { // first row
                    col++;
                    up = false;
                } else { // general up move
                    row--;
                    col++;
                }
            } else { // moving down
                if (row == n - 1) { // last row
                    col++;
                    up = true;
                } else if (col == 0) { // first column
                    row++;
                    up = true;
                } else { // general down move
                    row++;
                    col--;
                }
            }
        }

        return result;
    }
}
