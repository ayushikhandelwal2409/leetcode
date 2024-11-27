class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans=0;
        int p=1;
        int s=0;
        int e=0;
        while(e<nums.length){
            p=p*nums[e];
            while(p>=k && s<=e){
                p=p/nums[s];
                s++;          
            }
            ans=ans+(e-s+1);
            e++;
        }
        return ans;
    }
}