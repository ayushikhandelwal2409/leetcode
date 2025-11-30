//method 1--> giving tle
// class Solution {
//     public int minSubarray(int[] nums, int p) {
//         long sum=0;
//         int n=nums.length;
//         for(int num:nums){
//             sum+=num;
//         }
//         if(sum%p==0) return 0;
//         int minLen = n; 
//         for(int i=0;i<n;i++){
//             long sub_sum=0;
//             for(int j=i;j<n;j++){
//                 sub_sum+=nums[j];
//                 long remainings_sum = (sum - sub_sum) % p;
//                 if (remainings_sum == 0) {
//                     minLen = Math.min(minLen, j - i + 1);
//                 }
//             }
//         }
//         return minLen == n ? -1 : minLen;
//     }
// }


//method 2
class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum=0;
        int n=nums.length;
        for(int num:nums){
            sum=(sum+num)%p;
        }
        int k=sum%p;
        if(k==0) return 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        
        int curr_sum = 0;
        int ans = n;

        for (int i = 0; i < n; i++) {
            curr_sum = (curr_sum + nums[i]) % p;

            // we want prefix[i] - prefix[j] ≡ k (mod p)
            int need = (curr_sum - k + p) % p;

            if (map.containsKey(need)) {
                ans = Math.min(ans, i - map.get(need));
            }

            map.put( curr_sum, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}