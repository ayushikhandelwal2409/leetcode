class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int s=0;
        int e=n-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==target)return true;;
            if(nums[s]==nums[mid] && nums[e]==nums[mid]){
                s=s+1;
                e=e-1;
                continue;
            }
            //check for sorted side-- right or left half
            if(nums[s]<=nums[mid]){  //sorted left half
                if(nums[s]<=target && target<=nums[mid]){
                    e=mid-1;
                }
                else{
                    s=mid+1;
                }
            }
            else{
                if(nums[e]>=target &&target >=nums[mid]){
                    s=mid+1;
                }
                else{
                    e=mid-1;
                }
            }
        }
        return false;
    }
}


