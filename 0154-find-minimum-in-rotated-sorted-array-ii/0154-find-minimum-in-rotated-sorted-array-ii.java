class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1; // Move to the right half
            } 
            else if(nums[mid] < nums[right]) { // The left part is sorted
                right = mid; // Move to the left half (including mid)
            }
            else{
                right--;
            }
        }
        // At the end of the loop, left == right and points to the minimum element
        return nums[left];
    }
}