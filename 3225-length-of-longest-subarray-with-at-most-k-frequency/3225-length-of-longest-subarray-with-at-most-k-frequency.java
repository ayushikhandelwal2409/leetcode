class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0,start=0,i=0;
        while(i<nums.length){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
            while(map.get(nums[i])>k){
                map.put(nums[start],map.get(nums[start])-1);
                start++;
            }
            max=Math.max(max,i-start+1);
            i++;
        }
        return max;
    }
}