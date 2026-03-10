class Solution {
    int[][] dir={{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp=new double[n][n][k+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j], -1.0);
            }
        }
        return helper(row,column,n,dp,k);
    }
    public double helper( int r,int c,int n,double[][][] dp,int moves){
        if(r<0 || c<0 ||r>=n || c>=n){
            return 0.0;
        }
        if(moves==0){
            return 1.0;
        }
        if(dp[r][c][moves]!=-1.0){
            return dp[r][c][moves];
        }
        double prob=0;
        for(int i=0;i<8;i++){
            int nrow=r+dir[i][0];
            int ncol=c+dir[i][1];
            prob+=helper(nrow,ncol,n,dp,moves-1)/8.0;
        }
        return dp[r][c][moves]=prob;
    }
}