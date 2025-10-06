class Solution {
    // public int[] countBits(int n) {
    //     int[] dp=new int[n+1];
    //     for(int i=0;i<=n;i++){
    //         int sum=0;
    //         int num=i;
    //         while(num!=0){
    //             sum+=num%2;
    //             num/=2;
    //         }
    //         dp[i]=sum;
    //     }
    //     return dp;
    // }

    public int[] countBits(int n) {
        if(n==0) return new int[]{0};
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i>>1]+dp[i%2];
        }
        return dp;
    }
}