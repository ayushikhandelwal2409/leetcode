class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int opn=0;
        for(int i=0;i<n-2;i++){
            if(nums[i]==0){
                nums[i]^=1;
                nums[i+1]^=1;
                nums[i+2]^=1;
                opn++;
            }
        }
        if(nums[n-1]==1 && nums[n-2]==1){
            return opn;
        }
        return -1;
    }
}