class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {// floyd warshall algo
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        for(int i=0;i<n;i++){
            dist[i][i]=0;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n ; j++) {
                    if (dist[i][k] < 1e8 && dist[k][j] < 1e8){
                        dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                    }
                }
            }
        }

        int maxcnt=n;
        int cityNo=-1;
        for(int city=0;city<n;city++){
            int cnt=0;
            for(int adjcity=0;adjcity<n;adjcity++){
                if(dist[city][adjcity]<=distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<=maxcnt){
                maxcnt=cnt;
                cityNo=city;
            }
        }
        return cityNo;
    }
}