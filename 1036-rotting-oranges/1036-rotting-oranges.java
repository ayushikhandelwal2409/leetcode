class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int freshcnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    freshcnt++;
                }
            }
        }
        int minutes=0;

        int[][] directions={{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while(!q.isEmpty() && freshcnt>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] arr=q.poll();
                for(int[] l:directions){
                    int row=arr[0]+l[0];
                    int col=arr[1]+l[1];
                    if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1) {
                        grid[row][col] = 2; // Rot the fresh orange
                        freshcnt--; // Decrease the count of fresh oranges
                        q.offer(new int[]{row, col}); // Add to the queue
                    }
                }
            }
            minutes++;
        }
        return freshcnt==0?minutes:-1;
    }
}