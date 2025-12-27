class Solution {
    public long numberOfSubarrays(int[] nums) {
        int cnt=0;
        int n=nums.length;
        Stack<Integer> s=new Stack<>();
        int[] count = new int[n];
        Arrays.fill(count, 1); // 1 for subarrays of size 1
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[i]) {
                if (nums[s.peek()] == nums[i]) {
                    count[i] += count[s.peek()];
                }
                s.pop();
            }
            s.push(i);
        }
        long sum = 0;
        for (int x : count) {
        sum +=(long) x;
        }
        return sum;
    }
}