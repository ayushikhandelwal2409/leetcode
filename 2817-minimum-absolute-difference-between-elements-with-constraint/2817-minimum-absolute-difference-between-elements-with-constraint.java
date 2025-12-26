class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        if (x == 0) return 0;

        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;

        for (int j = x; j < nums.size(); j++) {
            // add element which is x indices behind
            set.add(nums.get(j - x));

            Integer floor = set.floor(nums.get(j));
            Integer ceil = set.ceiling(nums.get(j));

            if (floor != null) {
                ans = Math.min(ans, Math.abs(nums.get(j) - floor));
            }
            if (ceil != null) {
                ans = Math.min(ans, Math.abs(nums.get(j) - ceil));
            }

            if (ans == 0) return 0; // early exit
        }

        return ans;
    }
}