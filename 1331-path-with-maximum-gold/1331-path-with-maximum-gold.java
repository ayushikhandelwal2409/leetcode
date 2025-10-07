class Solution {
    public int getMaximumGold(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt = Math.max(cnt, max_gold(grid,i,j));
            }
        }
        return cnt;
    }
    public int max_gold(int[][] grid,int row,int col){
        int n=grid.length;
        int m=grid[0].length;
        if (row < 0 || col < 0 || row == n || col == m || grid[row][col] == 0) {
            return 0;
        }
        int maxGold=0;
        int val=grid[row][col];
        grid[row][col]=0;
        int[] dx = {-1, 0, 1, 0}; 
        int[] dy = {0, 1, 0, -1}; 
        for(int i=0;i<4;i++){
            int nrow=dx[i]+row;
            int ncol=dy[i]+col;
            maxGold=Math.max(max_gold(grid,nrow,ncol),maxGold);
        }
        grid[row][col] = val;
        return maxGold + val;
    }
}