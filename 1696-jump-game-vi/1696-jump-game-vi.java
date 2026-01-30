class Solution {
    public int maxResult(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);//idx,value
        dp[0]=nums[0];
        pq.add(new int[]{0,nums[0]});
        for(int i=1;i<n;i++){
            while(!pq.isEmpty() && i-pq.peek()[0]>k){
                pq.poll();
            }
            dp[i]=nums[i]+dp[pq.peek()[0]];
            pq.add(new int[]{i,dp[i]});
        }
        return dp[n-1];

    }
}