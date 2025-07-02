class Solution {
    public int[] countBits(int n) {
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            int sum=0;
            int num=i;
            while(num!=0){
                sum+=num%2;
                num/=2;
            }
            dp[i]=sum;
        }
        return dp;
    }
}