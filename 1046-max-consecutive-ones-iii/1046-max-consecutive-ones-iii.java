class Solution {
    public int longestOnes(int[] nums, int k) {
        int c=0;
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int start=0;
        int i=0;
        while(i<n && start<=i){
            if(nums[i]==0){
                c++;
            }
            while(c>k){
                if(nums[start]==0){
                    c--;
                }
                start++;
            }
            max=Math.max(max,i-start+1);
            i++;
        }
        return max;
    }
}