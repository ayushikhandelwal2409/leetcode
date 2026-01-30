class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        PriorityQueue<int[]>  pq=new PriorityQueue<>((a,b)->b[1]-a[1]);//idx,val;
        for(int i=0;i<k;i++){
            pq.add(new int[]{i,nums[i]});
        }
        ans[0]=pq.peek()[1];
        int j=1;
        for(int i=k;i<n;i++){
            pq.add(new int[]{i,nums[i]});
            while(!pq.isEmpty() && pq.peek()[0]<=i-k){
                pq.poll();
            }
            ans[j++]=pq.peek()[1];
        }
        return ans;
    }
}