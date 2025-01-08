class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int k=1;
        int tm=0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]!=nums[i+1]){
                k++;
                if(k==3){
                    tm=nums[i] ;
                    break;
                }   
            }
        }
        return k<3? nums[nums.length-1]:tm;
    }
}