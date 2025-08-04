class Solution {
    public int findPairs(int[] nums, int k) {
        int n=nums.length;
        int c=0;
        Arrays.sort(nums);
        int i=0;
        int j=0;
        if(k!=0){
            while(i<n && j<n){
                if(Math.abs(nums[i]-nums[j])==k){
                    i++;
                    j++;
                    c++;
                    while (i < n && nums[i] == nums[i - 1]) i++;
                }
                else if(Math.abs(nums[i]-nums[j])<k){
                    j++;
                }
                else{
                    i++;
                }
            }
        } 
        else{
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (int key : map.keySet()) {
                if (map.get(key) > 1) c++;
            }
        }
        return c;       
    }
}