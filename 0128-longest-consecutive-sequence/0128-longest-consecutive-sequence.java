class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int i=0;
        int max=0;
        int c=1;
        if(n==0) return 0;
        while(i<n-1){
            if(nums[i+1]-nums[i]==1){
                c++;
            }
            else if(nums[i+1]-nums[i]==0){
                i++;
                continue;
            }
            else{
                max=Math.max(max,c);
                c=1;
            }
            i++;
        }
        return Math.max(c,max);

    }
}