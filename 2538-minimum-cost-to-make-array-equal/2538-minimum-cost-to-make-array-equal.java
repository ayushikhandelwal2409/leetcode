class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;

        int[][] arr = new int[n][2];
        long total = 0;
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i]; 
            total += cost[i];     
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        long curr = 0;
        int j = 0;
        while (curr < (total+1) / 2) { // stop when cumulative cost reaches half
            curr += arr[j][1];
            j++;
        }
        long med = arr[j-1][0]; // weighted median
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) arr[i][1] * Math.abs(arr[i][0] - med);
        }

        return ans;
    }
}