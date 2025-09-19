class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;  // cumulative sum
        int minLen = n + 1;

        // min-heap ==>(cumulativeSum, index)
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        // insert base case: sum=0 at index=-1
        pq.offer(new long[]{0, -1});

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            while (!pq.isEmpty() && sum - pq.peek()[0] >= k) {
                minLen = Math.min(minLen, i - (int) pq.peek()[1]);
                pq.poll();
            }
            pq.offer(new long[]{sum, i});
        }

        return minLen == n+1 ? -1:minLen ;
    }
}