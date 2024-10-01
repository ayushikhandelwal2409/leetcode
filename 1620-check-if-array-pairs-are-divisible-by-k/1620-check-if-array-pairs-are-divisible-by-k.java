class Solution {
    public boolean canArrange(int[] arr, int k) {
        int length = arr.length;
        int halfLength = length / 2;
        int[] count = new int[k];

        // Count the frequency of each remainder
        for (int num : arr) {
            count[((num % k)+k)%k]++;
        }

        // Check if the counts are balanced
        for (int i = 1; i <= k / 2; i++) {
            if (count[i] != count[k - i]) {
                return false;
            }
        }

        // If k is even, the count of k/2 must be even
        if (k % 2 == 0 && count[k / 2] % 2 != 0) {
            return false;
        }

        return true;
    }
}