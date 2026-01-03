class Solution {
    private int aliceNetIncome = Integer.MIN_VALUE;

    private boolean dfsBob(
            List<List<Integer>> adj, int u, int time, int[] bobTimes, boolean[] vis) {
        vis[u] = true;
        bobTimes[u] = time;

        if (u == 0)
            return true;

        for (int v : adj.get(u)) {
            if (vis[v])
                continue;

            if (dfsBob(adj, v, time + 1, bobTimes, vis))
                return true;
        }

        bobTimes[u] = -1;
        return false;
    }


    private void dfsAlice(
            List<List<Integer>> adj, int u, int time, int income, boolean[] vis, int[] bobTimes,
            int[] amount) {
        vis[u] = true;

        if (bobTimes[u] == -1 || time < bobTimes[u])
            income += amount[u];
        else if (time == bobTimes[u])
            income += (amount[u] / 2);

        if (adj.get(u).size() == 1 && u != 0)
            aliceNetIncome = Math.max(aliceNetIncome, income);

        for (int v : adj.get(u)) {
            if (vis[v])
                continue;
            dfsAlice(adj, v, time + 1, income, vis, bobTimes, amount);
        }
    }


    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int[] bob_time = new int[n];
        Arrays.fill(bob_time, -1);

        dfsBob(adj, bob, 0, bob_time, vis);

        Arrays.fill(vis, false);
        dfsAlice(adj, 0, 0, 0, vis, bob_time, amount);

        return aliceNetIncome;
    }
}