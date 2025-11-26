class Solution {
    int mod=1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int n =grid.length;
        int m=grid[0].length;     
        int[][][] dp=new int[n][m][k];
        for(int[][] i:dp){
            for(int[] j:i){
                Arrays.fill(j,-1);
            }
        }
        return path(0,0,grid,k,0,dp);
    }
    private  int path(int r,int c,int[][] grid,int k,int rem,int[][][] dp){
        int n =grid.length;
        int m=grid[0].length;
        if (r >= n || c >= m || r<0 || c<0 ) return 0 ;
        int newrem = (rem + grid[r][c]) % k;
        if(dp[r][c][newrem]!=-1) return dp[r][c][newrem]%mod;
        if(r==n-1 && c==m-1 && newrem==0){
            return 1;
        }
        int down=path(r+1,c,grid,k,newrem,dp);
        int right=path(r,c+1,grid,k,newrem,dp);
        return dp[r][c][newrem]=(down+right)%mod;
    }
}