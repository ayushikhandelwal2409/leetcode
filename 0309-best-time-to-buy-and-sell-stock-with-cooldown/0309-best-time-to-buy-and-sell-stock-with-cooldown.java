class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int[] arr:dp)
        Arrays.fill(arr,-1);
        return profit(prices,0,1,dp); // holding variable
    }
    public static int profit(int[] prices,int idx,int canbuy,int[][] dp){
        if(idx>=prices.length) return 0;
        if(dp[idx][canbuy]!=-1) return dp[idx][canbuy];
        int profit=0;
        if(canbuy==1){
            int buy=-prices[idx] + profit(prices,idx+1,0,dp);
            int skip=profit(prices,idx+1,1,dp);
            profit=Math.max(buy,skip);
        }
        else{
            int sell=prices[idx] + profit(prices,idx+2,1,dp); //cooldown tomorrow 
            int hold=profit(prices,idx+1,0,dp);
            profit=Math.max(sell,hold);
        }
        return dp[idx][canbuy]=profit; 
    }
}