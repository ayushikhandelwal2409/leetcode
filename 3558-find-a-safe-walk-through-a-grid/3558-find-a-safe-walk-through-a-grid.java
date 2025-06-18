class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n=grid.size();
        int m=grid.get(0).size();
        boolean[][][] vis=new boolean[n][m][health+1];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,health-grid.get(0).get(0)});//row,col,health
        vis[0][0][health-grid.get(0).get(0)]=true;;
        int[] rdir={-1,0,1,0};
        int[] cdir={0,-1,0,1};
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int row=arr[0];
            int col=arr[1];
            int currentHealth =arr[2];
            if(row==n-1 && col==m-1 && currentHealth >= 1) return true;
            for(int i=0;i<4;i++){
                int nrow=rdir[i]+row;
                int ncol=cdir[i]+col;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int newHealth = currentHealth - grid.get(nrow).get(ncol);//- 1 for 1 or  - 0 for 0
                    if (newHealth > 0 && !vis[nrow][ncol][newHealth]) {
                        vis[nrow][ncol][newHealth] = true;
                        q.offer(new int[]{nrow, ncol, newHealth});
                    }
                }
            }
        }
        return false;
    }
}