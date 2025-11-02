class Solution {
    //unguarded=0;
    private static final int GUARDED = 1;
    private static final int GUARD = 2;
    private static final int WALL = 3;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = GUARD;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = WALL;
        }

        for(int[] g:guards){
            int r=g[0],c=g[1];
            dfs(r, c + 1, 'R',  grid);
            dfs(r, c - 1, 'L', grid);
            dfs(r + 1, c, 'D',  grid);
            dfs(r - 1, c, 'U',  grid);
        }

        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)cnt++;
            }
        }
        return cnt;
    }
    private void dfs(int row, int col, char direction ,int[][] grid) {
        if (
            row < 0 ||
            row >= grid.length ||
            col < 0 ||
            col >= grid[0].length ||
            grid[row][col] == GUARD ||
            grid[row][col] == WALL
        ) {
            return;
        }
        grid[row][col] = GUARDED; // Mark cell as guarded
        if (direction == 'U') dfs(row - 1, col, 'U',grid); // Up
        if (direction == 'D') dfs(row + 1, col, 'D',grid); // Down
        if (direction == 'L') dfs(row, col - 1,  'L',grid); // Left
        if (direction == 'R') dfs(row, col + 1,  'R',grid); // Right
    }
}