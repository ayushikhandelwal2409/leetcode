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
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<mat[0].length;i++){
            if(i==c){
                continue;
            }
            ans=Math.min(ans,minpath(mat,r+1,i,dp));
        }

        return dp[r][c]=ans+mat[r][c];
    }
}