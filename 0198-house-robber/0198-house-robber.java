class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return total_amount(nums,0,dp);
    }
    public static int total_amount(int[] nums,int i,int[] dp){
        if(i>=nums.length) return 0;   //base case

        if(dp[i]!=-1){
            return dp[i];
        }

        int rob=nums[i]+ total_amount(nums,i+2,dp);
        int dont_rob=total_amount(nums,i+1,dp);
        return dp[i]=Math.max(rob,dont_rob);
    }
}