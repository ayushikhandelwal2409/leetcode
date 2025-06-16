class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    public int atMostK(int[] nums,int k){
        int start=0;
        int i=0;
        int odd=0;
        int count=0;
        while(i<nums.length){
            if(nums[i]%2!=0){
                odd++;
            }
            while(odd>k){
                if(nums[start]%2!=0){
                    odd--;
                }
                start++;
            }
            count+=i-start+1;
            i++;
        }
        return count;
    }
}