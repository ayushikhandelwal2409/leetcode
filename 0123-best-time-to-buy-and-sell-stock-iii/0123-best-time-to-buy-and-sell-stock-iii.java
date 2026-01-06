class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][3];
        for(int i=0;i<n;i++)
            for(int j=0;j<2;j++)
                for(int k=0;k<3;k++)
                    dp[i][j][k]=-1;
        return profit(prices,0,1,2,dp); // holding variable as 1 in start we dont have stock
    }
    public static int profit(int[] prices,int idx,int canbuy,int transaction,int[][][] dp){
        if(idx>=prices.length || transaction==0) return 0;
        if(dp[idx][canbuy][transaction]!=-1) return dp[idx][canbuy][transaction];
        int profit=0;
        if(canbuy==1){
            int buy=-prices[idx] + profit(prices,idx+1,0,transaction,dp);
            int skip=profit(prices,idx+1,1,transaction,dp);
            profit=Math.max(buy,skip);
        }
        else{
            int sell=prices[idx] + profit(prices,idx+1,1,transaction-1,dp); 
            int hold=profit(prices,idx+1,0,transaction,dp);
            profit=Math.max(sell,hold);
        }
        return dp[idx][canbuy][transaction]=profit; 
    }
}
// canBuy = 1  →  you DO NOT have a stock → you are ALLOWED to buy
// canBuy = 0  →  you ALREADY HAVE a stock → you must sell or hold
// So canBuy represents your current STATE, not an action.
// Either you have stock (0)

// Or you don’t have stock (1)