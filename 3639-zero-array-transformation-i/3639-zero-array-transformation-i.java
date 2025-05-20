class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] decrements = new int[n + 1]; // +1 to handle the edge case for the last index
        // Apply the difference array technique
        for (int[] query : queries) {
            int li = query[0];
            int ri = query[1];
            decrements[li]++; // Start decrementing from li
            if (ri + 1 < n) {
                decrements[ri + 1]--; // Stop decrementing after ri
            }
        }
        // Calculate the actual decrements using prefix sum
        for (int i = 1; i < n; i++) {
            decrements[i] += decrements[i - 1];
        }
        // Check if we can achieve zero for each element
        for (int i = 0; i < n; i++) {
            if (nums[i] > decrements[i]) {
                return false; // Cannot decrement this index to zero
            }
        }
        return true; // All elements can be decremented to zero
    }
}