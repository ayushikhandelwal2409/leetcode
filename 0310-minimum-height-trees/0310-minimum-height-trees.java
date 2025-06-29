class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            return Arrays.asList(0);
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> leaves=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while(n>2){
            int leaves_count=leaves.size();
            n-=leaves_count;
            for(int i=0;i<leaves_count;i++){
                int leaf=leaves.poll();
                for(int neighbour:adj.get(leaf)){
                    adj.get(neighbour).remove((Integer)leaf);
                    if(adj.get(neighbour).size()==1){
                        leaves.offer(neighbour);
                    }
                }
            }
        }
        return new ArrayList<>(leaves);
    }
}