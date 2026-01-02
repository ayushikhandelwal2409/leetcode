class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        int[] dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);//len,node
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int len=arr[0];
            int node=arr[1];
            if(len>dis[node]) continue;
            for(int[] neighbour:adj.get(node)){
                int adjnode=neighbour[0];
                int adjlen=neighbour[1];
                if(adjlen+len<dis[adjnode]){
                    if(adjlen+len>=disappear[adjnode]){
                        continue;
                    }
                    dis[adjnode]=adjlen+len;
                    pq.add(new int[]{adjlen+len,adjnode});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dis[i] == Integer.MAX_VALUE) dis[i] = -1;
        }
        return dis;
    }
}