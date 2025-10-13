class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // mark all as uncomputed
        }
        int diff = helper(nums, 0, n - 1, dp);
        return diff >= 0;
    }

    private int helper(int[] nums, int i, int j, int[][] dp) {
        if (i == j) return nums[i];
        if (dp[i][j] != -1) return dp[i][j];

        int pickStart = nums[i] - helper(nums, i + 1, j, dp);
        int pickEnd = nums[j] - helper(nums, i, j - 1, dp);

        dp[i][j] = Math.max(pickStart, pickEnd);
        return dp[i][j];
    }
}
// class Solution {
//     public boolean predictTheWinner(int[] nums) {
//         int n = nums.length;
//         int[] max_diff = new int[n];

//         for (int i = n - 1; i >= 0; i--) {
//             max_diff[i] = nums[i];
//             for (int j = i + 1; j < n; j++) {
//                 max_diff[j] = Math.max(nums[i] - max_diff[j], nums[j] - max_diff[j - 1]);
//             }
//         }

//         return max_diff[n - 1] >= 0; 
//     }
// }