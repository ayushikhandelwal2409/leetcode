class Solution {
    public int maxCoins(int[] arr) {
        int[] a=new int[arr.length+2];
        a[0]=a[a.length-1]=1;
        for (int i = 0; i < arr.length; i++) {
            a[i+1]=arr[i];
        }
        int[][] dp=new int[a.length][a.length];
        for(int[] k:dp){
            Arrays.fill(k,-1);
        }
        return burst_coin(a,0,a.length-1,dp);
    }
    public static int burst_coin(int[] arr, int i,int j,int[][] dp){
        if(i+1==j) return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MIN_VALUE;
        for (int k = i+1; k < j; k++) {
            int left=burst_coin(arr,i,k,dp);
            int right=burst_coin(arr,k,j,dp);
            int self=arr[i]*arr[j]*arr[k];
            ans=Math.max(ans,left+right+self);
        }
        return dp[i][j]=ans;
    }
}