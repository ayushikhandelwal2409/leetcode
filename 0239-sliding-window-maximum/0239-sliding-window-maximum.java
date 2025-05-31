class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l=nums.length;
        int[] ans=new int[l-k+1];
        if(k==1){
            return nums;
        }
        Deque<Integer> q=new LinkedList<>();
        for(int i=0;i<l;i++){
            if(!q.isEmpty() && q.peek()<i-k+1){
                q.poll();
            }
            while(!q.isEmpty()&& nums[i]>nums[q.peekLast()]){
                q.pollLast();
            }
            q.offer(i);
            if(i>=k-1) ans[i-k+1]=nums[q.peek()];
        }
        return ans;
    }
}