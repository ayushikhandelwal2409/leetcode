class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // only one house

        // Case 1: exclude last house
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = amount(nums, 0, n - 2, dp1);

        // Case 2: exclude first house
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = amount(nums, 1, n - 1, dp2);

        return Math.max(case1, case2);
    }

    public int amount(int[] nums, int idx, int end, int[] dp) {
        if (idx > end) return 0;

        if (dp[idx] != -1) return dp[idx];

        int rob = nums[idx] + amount(nums, idx + 2, end, dp);
        int dontRob = amount(nums, idx + 1, end, dp);

        return dp[idx] = Math.max(rob, dontRob);
    }
}