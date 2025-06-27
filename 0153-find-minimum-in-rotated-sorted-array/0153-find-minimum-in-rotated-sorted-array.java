class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int ans=Integer.MAX_VALUE;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= nums[right]) {//  right half is sorted
                ans=Math.min(ans,nums[mid]);
                right = mid - 1;
            } else {                // left half sorted
                ans=Math.min(ans,nums[left]);
                left = mid + 1;
            }
        }
        // At the end of the loop, left == right and points to the minimum element
        return ans;
    }
}