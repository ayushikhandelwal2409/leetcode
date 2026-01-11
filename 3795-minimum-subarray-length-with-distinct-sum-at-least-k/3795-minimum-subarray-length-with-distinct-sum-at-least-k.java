class Solution {
    public int minLength(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        int start=0;
        int n=nums.length;
        int sum=0;
        int min=n+1;
        while(i<n){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==1){
                sum+=nums[i];
            }
            while(sum>=k){
                map.put(nums[start],map.get(nums[start])-1);
                if(map.get(nums[start])==0){
                    map.remove(nums[start]);
                    sum-=nums[start];
                }
                min=Math.min(min,i-start+1);
                start++;
            }
            i++;
        }
        return min==n+1?-1:min;
    }
}