class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int i=2;i<nums.length;i++) {
            int s=0;
            int e=i-1;
            while(s<e){
                if(nums[s]+nums[e]>nums[i]){
                    count+=(e-s);
                    e--;
                }
                else{
                    s++;
                }
            }
        } 
        return count;
    }
}