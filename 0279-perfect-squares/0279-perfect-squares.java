class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        return perfect_squares(n,dp);
        
    }
    public int perfect_squares(int n,int[] dp){
        if (n < 4)
            return n;
        
        if (dp[n] != 0)
            return dp[n];
        
        int ans = n;
        
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + perfect_squares(n - square, dp));
        }
        
        return dp[n] = ans; 
    }
}