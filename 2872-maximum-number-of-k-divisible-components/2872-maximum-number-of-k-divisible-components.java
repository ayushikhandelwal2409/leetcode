class Solution {
    int result = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        dfs(0, -1, graph, values, k);
        return result;
    }

    private long dfs(int node, int parent, List<List<Integer>> graph,
                     int[] values, int k) {

        long sum = values[node];

        for (int nei : graph.get(node)) {
            if (nei == parent) continue;

            long childSum = dfs(nei, node, graph, values, k);
            sum += childSum;
        }

        if (sum % k == 0) {
            result++;
            return 0;
        }
        return sum;
    }
}