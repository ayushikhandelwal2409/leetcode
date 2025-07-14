class Solution {
    public int splitArray(int[] nums, int k) {
        int  min=nums[0];
        int max=0;
        for(int i: nums){
            min = Math.max(min, i);
            max += i;
        }
        while(min<=max){
            int mid=min+(max-min)/2;
            if(count(nums,mid,k)){
                max=mid-1;

            }
            else min=mid+1;
        }
        return min;
    }
    public boolean count(int[] nums,int mid,int k){
        int sum=0;
        int partition=1;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]<=mid){
                sum+=nums[i];
            }
            else{
                partition+=1;
                sum=nums[i];
            }
        }
        return partition<=k;
    }
}