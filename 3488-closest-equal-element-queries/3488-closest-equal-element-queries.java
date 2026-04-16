import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Step 1: Map value → indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        // Step 2: Process queries
        for (int q : queries) {
            List<Integer> list = map.get(nums[q]);

            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, q);

            // neighbors in circular manner
            int left = (pos - 1 + list.size()) % list.size();
            int right = (pos + 1) % list.size();

            int dist1 = getDist(q, list.get(left), n);
            int dist2 = getDist(q, list.get(right), n);

            ans.add(Math.min(dist1, dist2));
        }

        return ans;
    }

    private int getDist(int i, int j, int n) {
        int diff = Math.abs(i - j);
        return Math.min(diff, n - diff);
    }
}