class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        int n = nums.length;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1); 
                sum -= nums[left]; 
                left++;
            }
        }
        int p=(min!=Integer.MAX_VALUE)? min: 0;
        return p;
    }
}