class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return subArrayWithLessOrEqualToSum(nums, goal) - subArrayWithLessOrEqualToSum(nums, goal - 1);
    }
    public int subArrayWithLessOrEqualToSum(int[]nums, int goal){ 
        if(goal<0) return 0;
        int count=0;
        int i=0;
        int sum=0;
        int start=0;
        while(i<nums.length){
            sum+=nums[i];
            while(sum>goal){
                sum-=nums[start];
                start++;
            }
            count+=i-start+1;
            i++;
        }
        return count;
    }
}