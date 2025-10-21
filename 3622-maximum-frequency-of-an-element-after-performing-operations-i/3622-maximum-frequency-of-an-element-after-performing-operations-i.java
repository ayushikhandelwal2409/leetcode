import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int lastNumIndex = 0;
        int max = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[lastNumIndex]) {
                map.put(nums[lastNumIndex], i - lastNumIndex);
                max = Math.max(max, i - lastNumIndex);
                lastNumIndex = i;
            }
        }
        map.put(nums[lastNumIndex], n - lastNumIndex);
        max = Math.max(max, n - lastNumIndex);

        int ans = max;

        // Iterate only through unique values
        for (int i = nums[0]; i <= nums[nums.length - 1]; i++) {
            int l = leftBound(nums, i - k);
            int r = rightBound(nums, i + k);

            int tempAns;
            if (map.containsKey(i)) {
                tempAns = Math.min(r - l + 1, map.get(i) + numOperations);
            } else {
                tempAns = Math.min(r - l + 1, numOperations);
            }
            ans = Math.max(ans, tempAns);
        }

        return ans;
    }

    private int leftBound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < value)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private int rightBound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > value)
                right = mid - 1;
            else
                left = mid;
        }
        return left;
    }
}
