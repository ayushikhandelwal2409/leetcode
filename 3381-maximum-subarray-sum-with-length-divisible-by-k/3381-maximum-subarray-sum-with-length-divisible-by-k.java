class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long ans=Long.MIN_VALUE;
        long[] pref=new long[n+1];
        pref[1]=nums[0];
        for(int i=1;i<n;i++){
            pref[i+1]=nums[i]+pref[i];
        }
        // map: (remainder , minimum prefix sum so far)
        HashMap<Integer,Long> map=new HashMap<>();
         for (int i = 0; i <= n; i++) {
            int r = i % k;

            if (map.containsKey(r)) {
                ans = Math.max(ans, pref[i] - map.get(r));
                map.put(r, Math.min(map.get(r), pref[i]));
            } else {
                map.put(r, pref[i]);
            }
        }
        return ans;
    }
}