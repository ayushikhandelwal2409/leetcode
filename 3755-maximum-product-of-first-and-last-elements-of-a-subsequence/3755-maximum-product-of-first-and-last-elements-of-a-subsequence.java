class Solution {
    public long maximumProduct(int[] nums, int m) {
        int n = nums.length;
        long max = Long.MIN_VALUE;
        if (m == 1) {
            for (int x : nums) {
                max = Math.max(max, (long) x * x);
            }
            return max;
        }

        int minVal = nums[0];
        int maxVal = nums[0];

        for (int j = m - 1; j < n; j++) {   //  |j-i|>=m-1  <==>  (j-i+1)>=m
            int i = j - m + 1;
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);

            long product1 = (long) nums[j] * maxVal;
            long product2 = (long) nums[j] * minVal;
            max = Math.max(max, Math.max(product1, product2));
        }
    return max;
    }
}
