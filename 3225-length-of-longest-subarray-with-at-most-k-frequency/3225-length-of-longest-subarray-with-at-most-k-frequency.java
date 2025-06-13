class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        int start=0;
        int i=0;
        while(i<n){
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