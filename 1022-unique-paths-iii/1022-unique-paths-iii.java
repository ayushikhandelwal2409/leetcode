class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int zero=0;//count of squares on which we can walk
        int startr=0;
        int startc=0;
        for(int r = 0; r < n ; r++){
            for(int c = 0; c < m; c++){
                if(grid[r][c] == 0)   zero++;
                   else if(grid[r][c] == 1){
                    startr = r;
                    startc = c;
                }
            }
        }
        return path(grid, startr, startc, zero);
    }
    public int path(int[][] grid,int r,int c,int zero){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -1)
           return 0;
        if(grid[r][c]==2){
            return zero==-1?1:0;
        }
        grid[r][c] = -1;
        zero--;
        // int totalCount = path(grid, x + 1, y, zero) + path(grid, x, y + 1, zero) +
        //                  path(grid, x - 1, y, zero) + path(grid, x, y - 1, zero);
        int[] rdir = {1, 0, 0, -1};
        int[] cdir = {0, -1, 1, 0};
        int totalCount=0;
        for (int k = 0; k < 4; k++) {
            int newRow = r + rdir[k];
            int newCol = c + cdir[k];
            totalCount+=path(grid,newRow, newCol, zero);
        }
        grid[r][c] = 0;
        zero++;

        return totalCount;
    }
}