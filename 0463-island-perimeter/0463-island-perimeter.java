class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int perimeter=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    perimeter+=cal(grid,i,j);
                }
            }
        }
        return perimeter;
    }
    public static int cal(int[][] grid,int row,int col){
        int pm=0;
        int[] rd={-1,0,1,0};
        int[] cd={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+rd[i];
            int ncol=col+cd[i];
            if(nrow < 0 || nrow >= grid.length || ncol < 0 || ncol >= grid[0].length || grid[nrow][ncol] == 0){
                pm+= 1;
            }
        }
        System.out.println(pm);
        return pm;
    }
}