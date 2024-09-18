class Solution {
    public int majorityElement(int[] nums) {
        int e=nums[0];
        int v=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==e){
                v++;
            }
            else{
                v--;
                if(v==0){
                    e=nums[i];
                    v=1;
                }
            }
        }
        return e;
    }
}