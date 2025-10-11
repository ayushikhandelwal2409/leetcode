class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int n=nums.length;
        int ans=1;
        int start=nums[0];
        while(i<n){
            if(nums[i]-start>k){
                ans++;
                start=nums[i];
            }
            i++;
        }
        return ans;
    }
}