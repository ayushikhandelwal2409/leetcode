class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int mink=-1;
        int maxk=-1;
        int start=-1;
        int i=0;
        int n=nums.length;
        long ans=0;
        while(i<n){
            if (nums[i] < minK || nums[i] > maxK) {
                start = i;
                mink=-1;
                maxk=-1;
            }
            if (nums[i] == minK) mink = i;
            if (nums[i] == maxK) maxk = i;
            
            int valid=Math.min(mink,maxk)-start;
            if(mink!=-1 && maxk!=-1){
                ans+=valid;
            }
            i++;
            
        }
        return ans;
    }
}