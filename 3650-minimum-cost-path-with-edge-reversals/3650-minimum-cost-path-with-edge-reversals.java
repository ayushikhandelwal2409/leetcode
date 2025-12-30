class Solution {
    public int minCost(int n, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,2*w});
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);  //dis,node
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int dis = arr[0];
            int node = arr[1];
            if (dis > dist[node]) continue;
            
            for (int[] edge : adj.get(node)) {
                int ngh = edge[0];
                int cost = edge[1];
                if (dist[ngh] > dis + cost) {
                    dist[ngh] = dis + cost;
                    pq.offer(new int[]{dist[ngh], ngh});
                }
            }
        }
        return dist[n-1]==Integer.MAX_VALUE?-1:dist[n-1];
    }
}