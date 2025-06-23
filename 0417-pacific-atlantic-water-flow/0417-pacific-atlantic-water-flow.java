class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // if (heights == null || heights.length == 0 || heights[0].length == 0) {
        //     return new ArrayList<>();
        // }
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacificReachable = new boolean[m][n];
        boolean[][] atlanticReachable = new boolean[m][n];

        // Perform DFS from Pacific Ocean
        for (int i = 0; i < m; i++) {
            dfs(heights, pacificReachable, i, 0);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacificReachable, 0, j);
        }
        // Perform DFS from Atlantic Ocean
        for (int i = 0; i < m; i++) {
            dfs(heights, atlanticReachable, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, atlanticReachable, m-1, j);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacificReachable[i][j] && atlanticReachable[i][j]){
                    ArrayList<Integer> pair=new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    ans.add(pair);
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] heights, boolean[][] reachable, int r, int c) {
        reachable[r][c] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
        for (int[] dir : directions) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length
                    && !reachable[newRow][newCol] && heights[newRow][newCol] >= heights[r][c]) {
                dfs(heights, reachable, newRow, newCol);
            }
        }
    }
}