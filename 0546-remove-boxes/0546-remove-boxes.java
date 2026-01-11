class Solution {
    public int removeBoxes(int[] boxes) {
        int n=boxes.length;
        int[][][] dp=new int[n][n][n];
        return remove(boxes,0,n-1,0,dp);
    }
    public int remove(int[] b, int i, int j, int streak, int[][][] dp){
        if(i>j) return 0;
        if(dp[i][j][streak]!=0) return dp[i][j][streak];
         //remove boxes[l] now
         int res= (streak+1)*(streak+1) +remove(b,i+1,j,0,dp);
         //  merge boxes[l] with later same-color boxes
         for(int k=i+1;k<=j;k++){
            if(b[k]==b[i]){
                res=Math.max(res,remove(b,i+1,k-1,0,dp)+remove(b,k,j,streak+1,dp));
            }
         }

        return dp[i][j][streak]=res;
    }
}