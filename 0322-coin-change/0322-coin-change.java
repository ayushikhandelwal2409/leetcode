class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        int ans= min_ways(coins, amount,coins.length-1,dp);
        return ans==(int)(1e7)?-1:ans;
    }
    public static int min_ways(int[] coins,int amount,int i,int[][] dp){
        if (amount < 0 || i < 0) return (int)(1e7);
        if(amount==0){
            return 0;
        }
        if (dp[i][amount] != -1) return dp[i][amount];
        int inc=1+min_ways(coins, amount-coins[i],i,dp);
        int exc=min_ways(coins, amount,i-1,dp);
        return dp[i][amount] = Math.min(inc, exc);
    }
}