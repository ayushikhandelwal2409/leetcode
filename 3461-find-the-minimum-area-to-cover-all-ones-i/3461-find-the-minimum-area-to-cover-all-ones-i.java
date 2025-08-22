class Solution {
    public int minimumArea(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int minh=Integer.MAX_VALUE;
        int maxh=Integer.MIN_VALUE;
        int minv=Integer.MAX_VALUE;
        int maxv=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    minh=Math.min(minh,j);
                    maxh=Math.max(maxh,j);
                    minv=Math.min(minv,i);
                    maxv=Math.max(maxv,i);
                }
            }
        }
        int a=((maxh-minh)+1);
        int b=((maxv-minv)+1);
        return a*b;
    }
}