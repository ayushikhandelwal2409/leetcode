class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }
        Queue<int[]> q=new LinkedList<>();
        //int[][] vis=new int[n][m];
        int[][] dir={{0, 1}, {1, 0}, {0, -1}, {-1, 0},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        q.add(new int[]{0,0,1});
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int row=arr[0];
            int col=arr[1];
            int pathlength=arr[2];
            if(row==n-1 && col==m-1){
                return pathlength;
            }
            for(int[] k:dir){
                int nrow=row+k[0];
                int ncol=col+k[1];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0){
                    grid[nrow][ncol] = 1;
                    q.offer(new int[]{nrow, ncol,pathlength+1 });
                }
            }
        }
        return -1;
    }
}