class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] row_min = new int[rows];
        Arrays.fill(row_min, Integer.MAX_VALUE);
        int[] col_max = new int[cols];
        Arrays.fill(col_max, Integer.MIN_VALUE);
        
        for (int row_ind = 0; row_ind < rows; ++row_ind) {
            for (int col_ind = 0; col_ind < cols; ++col_ind) {
                int ele = matrix[row_ind][col_ind];
                row_min[row_ind] = Math.min(row_min[row_ind], ele);
                col_max[col_ind] = Math.max(col_max[col_ind], ele);
            }
        }
         for (int row_ind = 0; row_ind < rows; ++row_ind) {
            for (int col_ind = 0; col_ind < cols; ++col_ind) {
                int ele = matrix[row_ind][col_ind];
                if (ele == row_min[row_ind] && ele == col_max[col_ind]) {
                    return Collections.singletonList(ele);
                }
            }
        }
        
        return Collections.emptyList();
    }
}