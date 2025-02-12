class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int c=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                c+=nums[i-1]+1-nums[i];
                nums[i]=nums[i-1]+1;
            }
        }
        return c;
    }
}