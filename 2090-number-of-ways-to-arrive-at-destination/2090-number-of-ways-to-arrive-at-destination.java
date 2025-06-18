class Solution {//dijkstra algo
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road:roads){
            adj.get(road[0]).add(new int[]{road[1],road[2]});
            adj.get(road[1]).add(new int[]{road[0],road[2]});
        }

        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0], b[0]));
        pq.offer(new long[]{0,0});//dis,node
        long[] dis=new long[n];
        int[] ways=new int[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0]=0;
        ways[0]=1;
        int mod=(int)(1e9+7);
        while(!pq.isEmpty()){
            long[] arr=pq.poll();
            int node=(int)arr[1];
            long distance=arr[0];
            for(int[] neighbour:adj.get(node)){
                int adjnode=neighbour[0];
                long edgewt=neighbour[1];
                if(edgewt+distance<dis[adjnode]){
                    dis[adjnode]=edgewt+distance;
                    pq.offer(new long[]{dis[adjnode],adjnode});
                    ways[adjnode]=ways[node];  //Update dis and ways if a new shorter path is found.
                }
                else if(edgewt+distance==dis[adjnode]){
                    ways[adjnode]=(ways[adjnode]+ways[node])%mod;//Add to ways if another equally short path is found.
                }
            }
        }
        return ways[n-1]%mod;
    }
}