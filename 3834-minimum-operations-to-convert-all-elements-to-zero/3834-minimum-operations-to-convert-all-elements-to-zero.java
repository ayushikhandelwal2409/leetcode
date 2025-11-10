class Solution {
    public int minOperations(int[] nums) {
        List<Integer> s = new ArrayList<>();
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                s.clear();
                continue;
            }
            while(!s.isEmpty() && s.get(s.size()-1)>nums[i]){
                s.remove(s.size()-1);
            }
            if(s.isEmpty() || s.get(s.size() - 1) < nums[i]){
                c++;
                s.add(nums[i]);
            }
        }  
        return c;
    }
}