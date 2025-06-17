class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] dis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dis[i][j]=Integer.MAX_VALUE;
            }
        }
        dis[0][0]=0;
        pq.offer(new int[]{0,0,0});
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        while(!pq.isEmpty()){
            int[] arr=pq.poll();
            int diff=arr[0];
            int row=arr[1];
            int col=arr[2];
            if(row==n-1 && col==m-1) 
                return diff ;
            for(int i=0;i<4;i++){
                int nrow=dir[i][0]+row;
                int ncol=dir[i][1]+col;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m ){
                    int new_effort=Math.max(diff,Math.abs(heights[row][col]-heights[nrow][ncol]));
                    if(new_effort<dis[nrow][ncol]) {
                        dis[nrow][ncol]=new_effort;
                        pq.offer(new int[]{new_effort,nrow,ncol});
                    }
                }
            }
        }
        return 0;
    }
}