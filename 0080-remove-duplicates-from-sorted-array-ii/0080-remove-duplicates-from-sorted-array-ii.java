class Solution {
    public int removeDuplicates(int[] nums) {
         int c=1;
        int l=0;
        for(int i=0;i<nums.length;i++){
            if(i < nums.length - 1 && nums[i]==nums[i+1])
                c++;
            else
                c=1;
            if(c <= 2){
                nums[l++] = nums[i];
            }
        }
        return l;
    }
}