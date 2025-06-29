class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] memo=new int[n][m];

        int maxlength=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                maxlength=Math.max(maxlength,dfs(matrix,i,j,memo));
            }
        }
        return maxlength;
    }
    public int dfs(int[][] matrix,int row,int col,int [][]memo){
        int n=matrix.length;
        int m=matrix[0].length;
        if(memo[row][col]!=0){
            return memo[row][col];
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int maxPath = 1;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && matrix[newRow][newCol] > matrix[row][col]) {
                maxPath = Math.max(maxPath, 1 + dfs(matrix,newRow, newCol,memo));
            }
        }
        memo[row][col] = maxPath;
        return maxPath;
    }
}