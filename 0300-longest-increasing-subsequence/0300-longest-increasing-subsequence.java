class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS(nums);
    }
    public static int LIS(int[] arr){
        int[] dp=new int[arr.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >=0; j--) {
                if(arr[i]>arr[j]) {
                    int val = dp[j];
                    dp[i]=Math.max(dp[i],val+1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}