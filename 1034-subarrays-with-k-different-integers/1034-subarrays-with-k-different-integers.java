class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    public int atMostKDistinct(int[] nums, int k){
        int count=0;
        int start=0;
        int i=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(i<nums.length){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.size()>k){
                map.put(nums[start],map.get(nums[start])-1);
                if(map.get(nums[start])==0){
                    map.remove(nums[start]);
                }
                start++;
            }
            count+=i-start+1;
            i++;
        }
        return count++;
    }
}