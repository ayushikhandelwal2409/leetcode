class Solution {
    public int minStartValue(int[] nums) {
        int minSum = Integer.MAX_VALUE; // Initialize minSum to a large value
        int currentSum = 0; // This will track the cumulative sum

        // Iterate through the nums array
        for (int num : nums) {
            currentSum += num; // Update the current sum
            minSum = Math.min(minSum, currentSum); // Update the minimum sum encountered
        }

        // Calculate the minimum start value required
        return Math.max(1, 1 - minSum);
    }
}