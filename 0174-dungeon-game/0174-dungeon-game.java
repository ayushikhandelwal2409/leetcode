class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        int[][] dp =new int[n][m];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int ans=check(0,0,dungeon,dp,n,m);
        return ans;
    }
    public int check(int r,int c,int[][] grid,int[][] dp,int n,int m){
        if(r>=n || c>=m){
            return Integer.MAX_VALUE;
        }
        if(r==n-1 && c==m-1){
            return dp[r][c]=Math.max(1,1-grid[r][c]);
        }
        if(dp[r][c]!=-1){
            return dp[r][c];
        }       
        int right=check(r,c+1,grid,dp,n,m);
        int down=check(r+1,c,grid,dp,n,m);
        int health= Math.min(right,down)-grid[r][c];
        return dp[r][c]=Math.max(health,1);
    }
}