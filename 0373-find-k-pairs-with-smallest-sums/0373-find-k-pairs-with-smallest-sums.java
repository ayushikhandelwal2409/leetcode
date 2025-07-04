class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        ArrayList<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int n:nums1){
            pq.offer(new int[]{n+nums2[0],0}) ; // sum,index of nums2
        }
        while(k>0 && !pq.isEmpty()){
            int[] pair=pq.poll();
            int sum=pair[0];
            int ind=pair[1];
            ArrayList<Integer> currentPair = new ArrayList<>();
            currentPair.add(sum-nums2[ind]);
            currentPair.add(nums2[ind]);
            ans.add(currentPair);
            if (ind + 1 < nums2.length) {
                pq.offer(new int[]{sum - nums2[ind] + nums2[ind + 1], ind + 1});
            }
            k--;
        }
        return ans;
    }
}