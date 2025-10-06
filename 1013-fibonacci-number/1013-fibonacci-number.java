class Solution {
    // public int fib(int n) {
    //     if(n==0||n==1) return n;
    //     return fib(n-1)+fib(n-2);
    // }


    public int fib(int n) {
        if(n==0|| n==1) return n;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        return top_down(n,dp);

    }
    public int top_down(int n,int[] dp){
        if(n==0 || n==1) return n;
        if(dp[n]!=-1){
            return dp[n];
        }
        int a=top_down(n-1,dp);
        int b=top_down(n-2,dp);
        return dp[n]=a+b;
    }
}