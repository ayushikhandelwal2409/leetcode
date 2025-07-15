class Solution {
    public int minTime(int n, int[][] edges) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2], edge[3]});
        }
        boolean[] vis = new boolean[n];
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int time = cur[0];
            int node = cur[1];
            if(node==n-1) return time;
            if(vis[node]){
                continue;
            }
            vis[node]=true;
            for(int[] arr:graph.get(node)){
                int neighbour=arr[0];
                int st=arr[1];
                int end=arr[2];
                if(time<=end){
                    int new_time=Math.max(time,st)+1;
                    if(!vis[neighbour]){
                        pq.add(new int[]{new_time,neighbour});
                    }
                }
            }
        }
        return -1;
    }
}