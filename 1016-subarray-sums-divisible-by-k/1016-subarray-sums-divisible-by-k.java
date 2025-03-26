class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        // int[] arr=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int i= 0;i<n;i++){
            sum+=nums[i];
            int r=sum%k;
            if (r<0){
                r+=k;
            }
            count+=map.getOrDefault(r,0);
            map.put(r,map.getOrDefault(r,0) + 1);
        }
        return count;
    }
}