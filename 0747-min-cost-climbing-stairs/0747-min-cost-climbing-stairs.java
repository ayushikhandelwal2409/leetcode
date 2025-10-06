class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int zero= helper(dp,0,cost);
        int one= helper(dp,1,cost);
        return Math.min(zero,one);
    }
    public int helper(int[] dp,int i,int[] cost){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int one_jump=cost[i]+helper(dp,i+1,cost);
        int two_jump=cost[i]+helper(dp,i+2,cost);
        return dp[i]=Math.min(one_jump,two_jump);
    }
}