class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for (int i = 0; i <=n ; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }

        //min-heap: [distance, node]
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        pq.offer(new int[]{0,k});
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int distance=arr[0];
            int node=arr[1];
            if (distance > dis[node]) continue;
            for(int[] l:adj.get(node)){
                int edgewt=l[1];
                int adjnode=l[0];
                if(distance+edgewt<dis[adjnode]){
                    dis[adjnode]=distance+edgewt;
                    pq.offer(new int[]{dis[adjnode],adjnode});
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,dis[i]);
        }
        return max;
    }
}