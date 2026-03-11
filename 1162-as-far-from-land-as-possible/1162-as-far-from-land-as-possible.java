class Solution {
    int[][] dir={{0,1},{-1,0},{1,0},{0,-1}};
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        int max=Integer.MIN_VALUE;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j,0});
                }
            }
        }
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int r=arr[0];
            int c=arr[1];
            int t=arr[2];
            for(int i=0;i<4;i++){
                int nrow=dir[i][0]+r;
                int ncol=dir[i][1]+c;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==0){
                    grid[nrow][ncol] = 1; 
                    q.add(new int[]{nrow,ncol,t+1});
                    max=Math.max(t+1,max);
                }
            }
        }
        return max==Integer.MIN_VALUE?-1:max;
    }
}