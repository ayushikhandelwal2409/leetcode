class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] dp=new int[row][col];
        for(int[] arr:dp){
            Arrays.fill(arr,-66666);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<col;i++){
            ans=Math.min(ans,minpath(matrix,0,i,dp));
        }
        return ans;
    }
    public static int minpath(int[][] mat,int r,int c,int[][] dp){
        if(c<0 || c>=mat[0].length){
            return Integer.MAX_VALUE;
        }
        if(r==mat.length-1){
            return mat[r][c];
        }
        if(dp[r][c]!=-66666){
            return dp[r][c];
        }
        int left=minpath(mat,r+1,c-1,dp);
        int right=minpath(mat,r+1,c+1,dp);
        int down=minpath(mat,r+1,c,dp);

        return dp[r][c]=Math.min(right,Math.min(down,left))+mat[r][c];
    }
}