class Solution {
    public int maximumProduct(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        if(nums.length<3) return 0;
        int k=nums[n-3]*nums[n-2]*nums[n-1];
        int p=nums[0]*nums[1]*nums[n-1];
        return Math.max(k,p);
    }
}