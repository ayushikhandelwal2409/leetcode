class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int s=i+1;
            int e=nums.length-1;
            while(s<e){
                int sum=nums[i]+nums[s]+nums[e];
                if(sum==0){
                    result.add(Arrays.asList(nums[i], nums[s], nums[e]));
                    while (s < e && nums[s] == nums[s + 1]) s++;
                    while (s < e && nums[e] == nums[e - 1]) e--;
                    s++;
                    e--;
                }
                else if(sum<0){
                    s++;
                }
                else{
                    e--;
                }
            }
        }
        return result;
    }
}